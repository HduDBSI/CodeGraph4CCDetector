import numpy as np
import torch
from torch._C import device
import torch.nn as nn
import torch.nn.functional as F


class GraphAttentionLayer(nn.Module):
    """
    Simple GAT layer, similar to https://arxiv.org/abs/1710.10903
    """
    def __init__(self, in_features, out_features, dropout, alpha, concat=True, training=True):
        super(GraphAttentionLayer, self).__init__()
        self.dropout = dropout
        self.in_features = in_features
        self.out_features = out_features
        self.alpha = alpha
        self.concat = concat
        self.training = training

        self.W = nn.Parameter(torch.empty(size=(in_features, out_features)).to('cuda'))
        nn.init.xavier_uniform_(self.W.data, gain=1.414)
        self.a = nn.Parameter(torch.empty(size=(3*out_features, 1)).to('cuda'))
        nn.init.xavier_uniform_(self.a.data, gain=1.414)

        self.leakyrelu = nn.LeakyReLU(self.alpha)

    def forward(self, h, edge_attr, adjacency, node2node_features):
        
        # 以下部分参数不一样要分别计算
        h = F.dropout(h, self.dropout, training=self.training)
        
        Wh = torch.mm(h, self.W) # h.shape: (N, in_features), Wh.shape: (N, out_features)
        
        a_input = self._prepare_attentional_mechanism_input(Wh, node2node_features) 
        
        e = self.leakyrelu(torch.matmul(a_input, self.a).squeeze(2))

        zero_vec = -9e15*torch.ones_like(e) #为神马是负无穷？

        attention = torch.where(adjacency > 0, e, zero_vec)
        
        attention = F.softmax(attention, dim=1)  #exp（-无穷）= 0， 0/正数 = 0  即对非边的注意力设置为0，只关注相邻边
        
        attention = F.dropout(attention, self.dropout, training=self.training)
        #print("self.training",self.training)
        if self.concat:
            edge_attr = F.elu(torch.mm(edge_attr, self.W))
            h_prime = F.elu(torch.matmul(attention, Wh))
        else:
            edge_attr = torch.mm(edge_attr, self.W)
            h_prime = torch.matmul(attention, Wh)

        return h_prime, edge_attr

    def _prepare_attentional_mechanism_input(self, Wh, node2node_features): #[2708, 8]
        N = Wh.size()[0] # number of nodes
        # Below, two matrices are created that contain embeddings in their rows in different orders.
        # (e stands for embedding)
        # These are the rows of the first matrix (Wh_repeated_in_chunks): 
        # e1, e1, ..., e1,            e2, e2, ..., e2,            ..., eN, eN, ..., eN
        # '-------------' -> N times  '-------------' -> N times       '-------------' -> N times
        # 
        # These are the rows of the second matrix (Wh_repeated_alternating): 
        # e1, e2, ..., eN,            e1, e2, ..., eN, ...,            e1, e2, ..., eN 
        # '----------------------------------------------------' -> N times
        # 
        Wh_repeated_in_chunks = Wh.repeat_interleave(N, dim=0)   #torch.Size([7333264, 8])
        Wh_repeated_alternating = Wh.repeat(N, 1) #torch.Size([7333264, 8])
        node2node_features = torch.mm(node2node_features, self.W)

        # Wh_repeated_in_chunks.shape == Wh_repeated_alternating.shape == (N * N, out_features)

        # The all_combination_matrix, created below, will look like this (|| denotes concatenation):
        # e1 || e1  || 1->1
        # e1 || e2  || 1->2
        # e1 || e3  || 1->3
        # ...
        # e1 || eN  || 1->N
        # e2 || e1  || 2->1
        # e2 || e2  || 2->2
        # e2 || e3  || 2->3
        # ...
        # e2 || eN  || 2->N
        # ...
        # eN || e1  || N->1
        # eN || e2  || N->2
        # eN || e3  || N->3
        # ...
        # eN || eN  || N->N

        all_combinations_matrix = torch.cat([Wh_repeated_in_chunks, Wh_repeated_alternating, node2node_features], dim=1)
        # all_combinations_matrix.shape == (N * N, 2 * out_features)

        return all_combinations_matrix.view(N, N, 3 * self.out_features)

    def __repr__(self):
        return self.__class__.__name__ + ' (' + str(self.in_features) + ' -> ' + str(self.out_features) + ')'

