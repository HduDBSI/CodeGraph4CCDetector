import torch
from torch._C import device
import torch.nn as nn
import torch.nn.functional as F
from torch.nn import Linear
from layers.singleNodeAttention import SingleNodeAttentionLayer
from layers.GAT_with_edge import GraphAttentionLayer
from layers.edge_pool_my import EdgePooling
from torch_geometric.nn import (global_mean_pool, JumpingKnowledge)
from torch_geometric.nn.glob import GlobalAttention

class graphEmb(nn.Module):
    def __init__(self, num_layers, hidden, nheads, nclass, dropout, alpha, training):
        super(graphEmb, self).__init__()
        self.dropout = dropout
        self.num_classes = nclass
        self.training = training
        self.nheads = nheads

        self.h = SingleNodeAttentionLayer(hidden, hidden, dropout=dropout, alpha=alpha, concat=True)
        
        self.GAT = [GraphAttentionLayer(hidden, 2*hidden, concat=True, dropout=dropout, alpha=alpha, training = training) for _ in range(self.nheads)]
        for i, attention in enumerate(self.GAT):
            self.add_module('attention_{}'.format(i), attention)

        self.edge_pool1 = EdgePooling(nheads*2*hidden)

        self.out_att = GraphAttentionLayer(nheads*2*hidden, 2*hidden, concat=False, dropout=dropout, alpha=alpha, training = training)

        self.edge_pool2 = EdgePooling(2*hidden)

        self.jump = JumpingKnowledge(mode='cat')

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
        
    def forward(self, data):
        features1, edge_index1, edgesAttr1, adjacency1, node2node_features1= data

        #code patch 1
        h1 = self.h(features1)
        #print()
        #print("input ",h1.shape)
        batch1 = torch.zeros(len(h1), dtype=torch.int64, device='cuda')
       
        hs1 = [self.gpool1(h1, batch1)]
        #h1 = F.dropout(h1, self.dropout, training=self.training)

        h1_list = []
        edgesAttr1_list = []
        for att in self.GAT:
            h11, edgesAttr11 = att(h1, edgesAttr1, adjacency1, node2node_features1)
            h1_list.append(h11)
            edgesAttr1_list.append(edgesAttr11)
        h1, edgesAttr1 = torch.cat(h1_list, dim=1), torch.cat(edgesAttr1_list, dim=1)
        
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
        
        h1 = self.jump(hs1)

        return h1



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

