from collections import namedtuple

import torch
import torch.nn.functional as F
from torch_scatter import scatter_add
from torch_sparse import coalesce
from torch_geometric.utils import softmax


class EdgePooling(torch.nn.Module):
    
    unpool_description = namedtuple(
        "UnpoolDescription",
        ["edge_index", "cluster", "batch", "new_edge_score"])

    def __init__(self, in_channels, edge_score_method=None, dropout=0,
                 add_to_edge_score=0.5):
        super(EdgePooling, self).__init__()
        self.in_channels = in_channels
        if edge_score_method is None:
            edge_score_method = self.compute_edge_score_softmax
        self.compute_edge_score = edge_score_method
        self.add_to_edge_score = add_to_edge_score
        self.dropout = dropout

        self.lin = torch.nn.Linear(3 * in_channels, 1)

        self.reset_parameters()

    def reset_parameters(self):
        self.lin.reset_parameters()

    @staticmethod
    def compute_edge_score_softmax(raw_edge_score, edge_index, num_nodes):
        return softmax(raw_edge_score, edge_index[1], num_nodes=num_nodes)

    @staticmethod
    def compute_edge_score_tanh(raw_edge_score, edge_index, num_nodes):
        return torch.tanh(raw_edge_score)

    @staticmethod
    def compute_edge_score_sigmoid(raw_edge_score, edge_index, num_nodes):
        return torch.sigmoid(raw_edge_score)

    def forward(self, x, edge_index, edge_attr, batch): # added the edge vectors
        
        e = torch.cat([x[edge_index[0]], x[edge_index[1]], edge_attr], dim=-1) #combine the edge vectors
        e = self.lin(e).view(-1)
        e = F.dropout(e, p=self.dropout, training=self.training)
        e = self.compute_edge_score(e, edge_index, x.size(0))
        e = e + self.add_to_edge_score

        x, edge_index, edge_attr, batch, unpool_info = self.__merge_edges__(
            x, edge_index, edge_attr, batch, e)


        return x, edge_index, edge_attr, batch, unpool_info

    def __merge_edges__(self, x, edge_index, edge_attr, batch, edge_score):
        nodes_num = set(range(x.size(0)))

        cluster = torch.empty_like(batch, device='cuda')
        #cluster = torch.zeros((x.size(0)), dtype=torch.int64, device=torch.device('cuda'))
        edge_argsort = torch.argsort(edge_score, descending=True)

        # Iterate through all edges, selecting it if it is not incident to
        # another already chosen edge.
        i = 0
        new_edge_indices = []
        nodes_remaining = nodes_num
        edge_index_cpu = edge_index.cpu()
        for edge_idx in edge_argsort.tolist():
            source = edge_index_cpu[0, edge_idx].item()  # out Node ID(int) of the edge with the maximum score
            if source not in nodes_remaining:
                continue

            target = edge_index_cpu[1, edge_idx].item() # in Node ID(int) of the edge with the maximum score
            if target not in nodes_remaining:
                continue

            new_edge_indices.append(edge_idx)     # store the edge_idx (聚合的边的索引，用于聚合结点信息) to new_edge_indices[]

            cluster[source] = i
            nodes_remaining.remove(source)   #remove the out Node

            if source != target:
                cluster[target] = i
                nodes_remaining.remove(target)  #remove the in Node

            i += 1

        # The remaining nodes are simply kept.
        for node_idx in nodes_remaining:
            cluster[node_idx] = i
            i += 1
        #print("x.device ",x.device)
        cluster = cluster.to(x.device)           # value of the new node_index

        # We compute the new features as an addition of the old ones.
        new_x = scatter_add(x, cluster, dim=0, dim_size=i)
        new_edge_score = edge_score[new_edge_indices]
        if len(nodes_remaining) > 0:
            remaining_score = x.new_ones((new_x.size(0) - len(new_edge_indices), ))
            new_edge_score = torch.cat([new_edge_score, remaining_score])
        new_x = new_x * new_edge_score.view(-1, 1)

        #compute new_edge_attr
        '''
        另外，我们可能需要改变程序来计算新的节点特征；我们建议使用两个节点的特征、所选边的特征和反向边的特征（如果存在）的加权线性组合。
        最后，我们需要一个过程来组合在两个合并节点结束的边的边特征，因此将被合并。我们相信一个简单的求和法在这里也应该很管用。然而，我们还没有对此进行实验。
        '''
        N = new_x.size(0)
        new_edge_index, new_edge_attr = coalesce(cluster[edge_index], edge_attr, N, N)  # None should be the edge_attr, how to compute it?

        new_batch = x.new_empty(new_x.size(0), dtype=torch.long)
        new_batch = new_batch.scatter_(0, cluster, batch)

        unpool_info = self.unpool_description(edge_index=edge_index,
                                              cluster=cluster, batch=batch,
                                              new_edge_score=new_edge_score)

        return new_x, new_edge_index, new_edge_attr, new_batch, unpool_info

    def unpool(self, x, unpool_info):
        r"""Unpools a previous edge pooling step.

        For unpooling, :obj:`x` should be of same shape as those produced by
        this layer's :func:`forward` function. Then, it will produce an
        unpooled :obj:`x` in addition to :obj:`edge_index` and :obj:`batch`.

        Args:
            x (Tensor): The node features.
            unpool_info (unpool_description): Information that has
                been produced by :func:`EdgePooling.forward`.

        Return types:
            * **x** *(Tensor)* - The unpooled node features.
            * **edge_index** *(LongTensor)* - The new edge indices.
            * **batch** *(LongTensor)* - The new batch vector.
        """

        new_x = x / unpool_info.new_edge_score.view(-1, 1)
        new_x = new_x[unpool_info.cluster]
        return new_x, unpool_info.edge_index, unpool_info.batch

    def __repr__(self):
        return '{}({})'.format(self.__class__.__name__, self.in_channels)
