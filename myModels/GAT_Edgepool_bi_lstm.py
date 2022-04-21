import torch
import torch.nn as nn
import torch.nn.functional as F
from layers.bi_lstm import LSTMModel

class bi_lstm_detect(nn.Module):
    def __init__(self, num_layers, hidden, nheads, nclass, dropout, alpha, training):
        super(bi_lstm_detect, self).__init__()
        self.dropout = dropout
        self.num_classes = nclass
        self.training = training
        self.nheads = nheads

        self.bi_lstm = LSTMModel(hidden*(1+nheads*2+2), 128, 2, self.num_classes)

    def reset_parameters(self):
        self.bi_lstm.reset_parameters()
        
    def forward(self, h1, h2):
        lstm_data = torch.stack([h1,h2],dim=1)
        out = F.softmax(self.bi_lstm(lstm_data),dim=-1)
        return out

    def __repr__(self):
        return self.__class__.__name__

