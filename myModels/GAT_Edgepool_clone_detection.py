import torch
from torch._C import device
import torch.nn as nn
import torch.nn.functional as F
from torch.nn import Linear
from layers.singleNodeAttention import SingleNodeAttentionLayer
from layers.GAT_with_edge import GraphAttentionLayer
from layers.edge_pool_my import EdgePooling
from layers.bi_lstm import LSTMModel
from layers.global_self_att import GlobalSelfAttentionLayer
from torch_geometric.nn import (global_mean_pool, JumpingKnowledge)
from torch_geometric.nn.glob import GlobalAttention

class CodeCloneDetection(nn.Module):
    def __init__(self, num_layers, hidden, nheads, nclass, dropout, alpha, training):
        super(CodeCloneDetection, self).__init__()
        self.dropout = dropout
        self.num_classes = nclass
        self.training = training
        self.nheads = nheads

        self.h = SingleNodeAttentionLayer(hidden, hidden, dropout=dropout, alpha=alpha, concat=True)
        '''
        self.global_self_att = [GlobalSelfAttentionLayer(hidden, 2*hidden, dropout=dropout, alpha=alpha) for _ in range(self.nheads)]
        for i, global_self_att in enumerate(self.global_self_att):
            self.add_module('attention_{}'.format(i), global_self_att)
        '''
        self.GAT = [GraphAttentionLayer(hidden, 2*hidden, concat=True, dropout=dropout, alpha=alpha, training = training) for _ in range(self.nheads)]
        for i, attention in enumerate(self.GAT):
            self.add_module('attention_{}'.format(i), attention)

        self.edge_pool1 = EdgePooling(nheads*2*hidden)

        self.out_att = GraphAttentionLayer(nheads*2*hidden, 2*hidden, concat=False, dropout=dropout, alpha=alpha, training = training)

        self.edge_pool2 = EdgePooling(2*hidden)

        self.jump = JumpingKnowledge(mode='cat')
        self.lin1 = Linear((1+nheads*2+2)*hidden, hidden)

        self.bi_lstm = LSTMModel(hidden*(1+nheads*2+2), 128, 2, self.num_classes)
        #self.lin2 = Linear(2*hidden, self.num_classes)

        self.mlp_gate1=nn.Sequential(nn.Linear(hidden,1),nn.Sigmoid())
        self.gpool1=GlobalAttention(gate_nn=self.mlp_gate1)

        self.mlp_gate2=nn.Sequential(nn.Linear(hidden*32,1),nn.Sigmoid())
        self.gpool2=GlobalAttention(gate_nn=self.mlp_gate2)

        self.mlp_gate3=nn.Sequential(nn.Linear(hidden*2,1),nn.Sigmoid())
        self.gpool3=GlobalAttention(gate_nn=self.mlp_gate3)

    def reset_parameters(self):
        self.h.reset_parameters()
        self.GAT.reset_parameters()
        self.out_att.reset_parameters()
        self.edge_pool1.reset_parameters()
        self.edge_pool2.reset_parameters()
        self.lin1.reset_parameters()
        self.bi_lstm.reset_parameters()
        
    def forward(self, data):
        features1, features2, edge_index1, edge_index2, edgesAttr1, edgesAttr2, adjacency1, adjacency2, node2node_features1, node2node_features2 = data

        #code patch 1
        h1 = self.h(features1)
        #print()
        #print("input ",h1.shape)
        batch1 = torch.zeros(len(h1), dtype=torch.int64, device='cuda')
       
        hs1 = [self.gpool1(h1, batch1)]
        #h1 = F.dropout(h1, self.dropout, training=self.training)

        GAT1_out_list1 = [att(h1, edgesAttr1, adjacency1, node2node_features1) for att in self.GAT]
        h1 = torch.cat([item[0] for item in GAT1_out_list1], dim=1)
        edgesAttr1 = torch.cat([item[1] for item in GAT1_out_list1], dim=1)
        
        #print("layer1 ",h1.shape, edgesAttr1.shape)
        h1, edge_index1, edgesAttr1, batch1, _ = self.edge_pool1(h1, edge_index1, edgesAttr1, batch=batch1)
        batch1 = torch.zeros(len(h1), dtype=torch.int64, device='cuda')
        #print("h1",h1.shape)
        hs1 += [self.gpool2(h1, batch1)]
        #h1 = F.dropout(h1, self.dropout, training=self.training)

        adjacency1, node2node_features1 = self._get_adj_node2node(h1, edge_index1, edgesAttr1)
        h1, edgesAttr1 = self.out_att(h1, edgesAttr1, adjacency1, node2node_features1)

        #print("layer2 ",h1.shape, edgesAttr1.shape)
        h1, edge_index1, edgesAttr1, batch1, _ = self.edge_pool2(h1, edge_index1, edgesAttr1, batch=batch1)
        batch1 = torch.zeros(len(h1), dtype=torch.int64, device='cuda')
        
        hs1 += [self.gpool3(h1, batch1)]
        
        #print("global_mean_pool(h1, batch1)",global_mean_pool(h1, batch1).shape)
        '''
        global_vec_tensor_list1 = []
        for global_att in self.global_self_att:
            global_vec_tensor1 = global_att(all_token_tensor1)
            global_vec_tensor_list1.append(global_vec_tensor1)
        global_self_att_cat1 = torch.cat(global_vec_tensor_list1, dim=1)

        hs1 += [global_self_att_cat1]
        '''
        h1 = self.jump(hs1)

        #code patch 2
        h2 = self.h(features2)
        #print("input ",h2.shape)
        batch2 = torch.zeros(len(h2), dtype=torch.int64, device='cuda')
        hs2 = [self.gpool1(h2, batch2)]
        #h2 = F.dropout(h2, self.dropout, training=self.training)

        GAT1_out_list2 = [att(h2, edgesAttr2, adjacency2, node2node_features2) for att in self.GAT]
        h2 = torch.cat([item[0] for item in GAT1_out_list2], dim=1)
        edgesAttr2 = torch.cat([item[1] for item in GAT1_out_list2], dim=1)

        #print("layer1 ",h2.shape, edgesAttr2.shape)
        h2, edge_index2, edgesAttr2, batch2, _ = self.edge_pool1(h2, edge_index2, edgesAttr2, batch=batch2)
        batch2 = torch.zeros(len(h2), dtype=torch.int64, device='cuda')
        hs2 += [self.gpool2(h2, batch2)]
        #h2 = F.dropout(h2, self.dropout, training=self.training)

        adjacency2, node2node_features2 = self._get_adj_node2node(h2, edge_index2, edgesAttr2)
        h2, edgesAttr2 = self.out_att(h2, edgesAttr2, adjacency2, node2node_features2)

        #print("layer2 ",h2.shape, edgesAttr2.shape)
        h2, edge_index2, edgesAttr2, batch2, _ = self.edge_pool2(h2, edge_index2, edgesAttr2, batch=batch2)
        batch2 = torch.zeros(len(h2), dtype=torch.int64, device='cuda')
        hs2 += [self.gpool3(h2, batch2)]
        
        '''
        global_vec_tensor_list2 = []
        for global_att in self.global_self_att:
            global_vec_tensor2 = global_att(all_token_tensor2)
            global_vec_tensor_list2.append(global_vec_tensor2)
        global_self_att_cat2 = torch.cat(global_vec_tensor_list2, dim=1)
        hs2 += [global_self_att_cat2]
        '''
        h2 = self.jump(hs2)

        lstm_data = torch.stack([h1,h2],dim=1)
        #print("lstm_data",lstm_data.shape)

        out = F.softmax(self.bi_lstm(lstm_data),dim=-1)
        return out

    def _get_adj_node2node(self, h, edge_index, edge_attr):
        indices = edge_index.to('cuda')
        values = torch.ones((len(edge_index[0]))).to('cuda')
        adjacency = torch.sparse.FloatTensor(indices, values, torch.Size((len(h),len(h)))).to_dense()

        node2node_features = torch.zeros(len(h)*len(h),edge_attr.size()[1]).to('cuda')
        for i in range(len(edge_index[0])):
            node2node_features[len(h)*edge_index[0][i]+edge_index[1][i]] = edge_attr[i]
        # 以上 邻接矩阵 和 node2node_features 在多头注意力机制中是一样的，只计算一次就好，不一样的是 W 和 a

        return adjacency, node2node_features
        
    def __repr__(self):
        return self.__class__.__name__

