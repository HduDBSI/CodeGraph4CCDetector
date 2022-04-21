
import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F

device = "cuda" if torch.cuda.is_available() else "cpu"
class SingleNodeAttentionLayer(nn.Module):
    
    def __init__(self, in_features, out_features, dropout, alpha, concat=True):
        super(SingleNodeAttentionLayer, self).__init__()
        self.dropout = dropout
        self.in_features = in_features
        self.out_features = out_features
        self.alpha = alpha
        self.concat = concat

        self.W1 = nn.Parameter(torch.empty(size=(in_features, 2*out_features)).to(device))
        nn.init.xavier_uniform_(self.W1.data, gain=1.414)
        self.a1 = nn.Parameter(torch.empty(size=(2*out_features, 1)).to(device))
        nn.init.xavier_uniform_(self.a1.data, gain=1.414)

        self.W2 = nn.Parameter(torch.empty(size=(in_features, 2*out_features)).to(device))
        nn.init.xavier_uniform_(self.W2.data, gain=1.414)
        self.a2 = nn.Parameter(torch.empty(size=(2*out_features, 1)).to(device))
        nn.init.xavier_uniform_(self.a2.data, gain=1.414)

        self.W3 = nn.Parameter(torch.empty(size=(in_features, 2*out_features)).to(device))
        nn.init.xavier_uniform_(self.W3.data, gain=1.414)
        self.a3 = nn.Parameter(torch.empty(size=(2*out_features, 1)).to(device))
        nn.init.xavier_uniform_(self.a3.data, gain=1.414)

        self.W4 = nn.Parameter(torch.empty(size=(in_features, 2*out_features)).to(device))
        nn.init.xavier_uniform_(self.W4.data, gain=1.414)
        self.a4 = nn.Parameter(torch.empty(size=(2*out_features, 1)).to(device))
        nn.init.xavier_uniform_(self.a4.data, gain=1.414)

        self.Wo = nn.Parameter(torch.empty(size=(8*out_features, out_features)).to(device))
        nn.init.xavier_uniform_(self.Wo.data, gain=1.414)

        self.leakyrelu = nn.LeakyReLU(self.alpha)

    def forward(self, features): 
        
        W1_features = torch.matmul(features, self.W1)
        simple_attention1 = F.softmax(torch.matmul(W1_features,self.a1),dim=0)
        weighted_node_feature1 = torch.bmm(simple_attention1.permute(0,2,1), W1_features).squeeze(1)
        
        W2_features = torch.matmul(features, self.W2)
        simple_attention2 = F.softmax(torch.matmul(W2_features,self.a2),dim=0)
        weighted_node_feature2 = torch.bmm(simple_attention2.permute(0,2,1), W2_features).squeeze(1)

        W3_features = torch.matmul(features, self.W3)
        simple_attention3 = F.softmax(torch.matmul(W3_features,self.a3),dim=0)
        weighted_node_feature3 = torch.bmm(simple_attention3.permute(0,2,1), W3_features).squeeze(1)

        W4_features = torch.matmul(features, self.W4)
        simple_attention4 = F.softmax(torch.matmul(W4_features,self.a4),dim=0)
        weighted_node_feature4 = torch.bmm(simple_attention4.permute(0,2,1), W4_features).squeeze(1)

        weighted_node_feature_multi = torch.cat([weighted_node_feature1, weighted_node_feature2, weighted_node_feature3, weighted_node_feature4], dim=1)
        #print("weighted_node_feature_multi",weighted_node_feature_multi.shape)
        
        #print("h",h.shape)
        #print("self.Wo",self.Wo.shape)
        h = F.elu(torch.mm(weighted_node_feature_multi, self.Wo))
        
        #print("nodes", len(features))
        #print("h",h.shape)
        #print("all_token_tensor", all_token_tensor.shape)

        #exit()
        return h  # 返回所有结点的单一向量组成的二维张量特征数据
        
    


































'''

import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F

device = "cuda" if torch.cuda.is_available() else "cpu"
class SingleNodeAttentionLayer(nn.Module):
    
    def __init__(self, in_features, out_features, dropout, alpha, concat=True):
        super(SingleNodeAttentionLayer, self).__init__()
        self.dropout = dropout
        self.in_features = in_features
        self.out_features = out_features
        self.alpha = alpha
        self.concat = concat

        self.W = nn.Parameter(torch.empty(size=(in_features, out_features)))
        nn.init.xavier_uniform_(self.W.data, gain=1.414)
        self.a = nn.Parameter(torch.empty(size=(2*out_features, 1)))
        nn.init.xavier_uniform_(self.a.data, gain=1.414)

        self.leakyrelu = nn.LeakyReLU(self.alpha)

    def forward(self, features): # features是一个二维列表
        h = torch.Tensor([]).to(device)
        all_vec = []
        for features in features:
            
            #print("features ",len(features))
            features = torch.Tensor(features).to(device) # list 2 tensor
            all_vec.append(features)
            #print("features ",features.shape,"self.W ",self.W.shape)
            W_features = torch.mm(features, self.W).to(device)
            a_input = self._prepare_attentional_mechanism_input(W_features).to(device)

            e = self.leakyrelu(torch.matmul(a_input, self.a).squeeze(2))

            attention = F.softmax(torch.sum(e,dim=1), dim=-1)  # 每行e加和为1，（1*N）  

            node_prime = torch.matmul(attention, W_features) #（1*N · N*f = 1*f）
            
            if self.concat:
                h = torch.cat([h, F.elu(node_prime)], dim=-1)
                print("h", h.shape)
            else:
                h = torch.cat([h, node_prime], dim=-1)
        all_token_tensor = torch.cat(all_vec, dim=0)
        return h.view(-1, self.out_features).to(device), all_token_tensor  # 返回所有结点的单一向量组成的二维张量特征数据
        
    def _prepare_attentional_mechanism_input(self, W_features): #[2708, 8]
        N = W_features.size()[0] # number of node features

        Wh_repeated_in_chunks = W_features.repeat_interleave(N, dim=0)   #torch.Size([7333264, 8])
        
        Wh_repeated_alternating = W_features.repeat(N, 1) #torch.Size([7333264, 8])

        all_combinations_matrix = torch.cat([Wh_repeated_in_chunks, Wh_repeated_alternating], dim=1)
        # all_combinations_matrix.shape == (N * N, 2 * out_features)

        return all_combinations_matrix.view(N, N, 2 * self.out_features)

    def __repr__(self):
        return self.__class__.__name__ + ' (' + str(self.in_features) + ' -> ' + str(self.out_features) + ')'


'''