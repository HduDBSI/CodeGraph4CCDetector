import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F

device = "cuda" if torch.cuda.is_available() else "cpu"

class GlobalSelfAttentionLayer(nn.Module):
    
    def __init__(self, in_features, out_features, dropout, alpha, concat=True):
        super(GlobalSelfAttentionLayer, self).__init__()
        self.dropout = dropout
        self.in_features = in_features
        self.out_features = out_features
        self.alpha = alpha
        self.concat = concat

        self.W = nn.Parameter(torch.empty(size=(in_features, out_features)).to('cuda'))
        nn.init.xavier_uniform_(self.W.data, gain=1.414)
        self.a = nn.Parameter(torch.empty(size=(2*out_features, 1)).to('cuda'))
        nn.init.xavier_uniform_(self.a.data, gain=1.414)

        self.leakyrelu = nn.LeakyReLU(self.alpha)

    def forward(self, all_token_tensor): # features是一个二维列表

        W_all_token_tensor = torch.mm(all_token_tensor, self.W).to(device)
        a_input = self._prepare_attentional_mechanism_input(W_all_token_tensor).to(device)
        e = self.leakyrelu(torch.matmul(a_input, self.a).squeeze(2))
        attention = F.softmax(torch.sum(e,dim=1), dim=-1)  # 每行e加和为1，（1*N）
        #print("attention",attention)
        global_vec_tensor = F.elu(torch.matmul(attention, W_all_token_tensor).view(1,-1)) #（1*N · N*f = 1*f）

        return global_vec_tensor  # 返回所有结点的单一向量组成的二维张量特征数据
        
    def _prepare_attentional_mechanism_input(self, W_node_features): #[2708, 8]
        N = W_node_features.size()[0] # number of node features

        Wh_repeated_in_chunks = W_node_features.repeat_interleave(N, dim=0)   #torch.Size([7333264, 8])
        
        Wh_repeated_alternating = W_node_features.repeat(N, 1) #torch.Size([7333264, 8])

        all_combinations_matrix = torch.cat([Wh_repeated_in_chunks, Wh_repeated_alternating], dim=1)
        # all_combinations_matrix.shape == (N * N, 2 * out_features)

        return all_combinations_matrix.view(N, N, 2 * self.out_features)

    def __repr__(self):
        return self.__class__.__name__ + ' (' + str(self.in_features) + ' -> ' + str(self.out_features) + ')'


