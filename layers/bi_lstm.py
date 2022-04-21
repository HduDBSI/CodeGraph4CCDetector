import torch
import torch.nn as nn
from torch.autograd import Variable

class LSTMModel(nn.Module):
    def __init__(self, input_dim, hidden_dim, layer_dim, output_dim):
        super(LSTMModel, self).__init__()
        # Hidden dimensions
        self.hidden_dim = hidden_dim
        
        # Number of hidden layers
        self.layer_dim = layer_dim
        
        # Building your LSTM
        # batch_first=True causes input/output tensors to be of shape
        # (batch_dim, seq_dim, feature_dim)
        self.lstm = nn.LSTM(input_dim, hidden_dim, layer_dim, batch_first = True, bidirectional = True)
        
        # Readout layer
        self.fc = nn.Linear(hidden_dim*2, output_dim)
    
    def forward(self, x):
        #print("x",x.shape)
        # Initialize hidden state with zeros
        #######################
        #  USE GPU FOR MODEL  #
        #######################

        if torch.cuda.is_available():
            #(num_layers * num_directions, batch, hidden_size)
            h0 = Variable(torch.zeros(self.layer_dim*2, x.size(0), self.hidden_dim).cuda())
        else:
            h0 = Variable(torch.zeros(self.layer_dim*2, x.size(0), self.hidden_dim))
        
        # Initialize cell state
        if torch.cuda.is_available():
            c0 = Variable(torch.zeros(self.layer_dim*2, x.size(0), self.hidden_dim).cuda())
        else:
            c0 = Variable(torch.zeros(self.layer_dim*2, x.size(0), self.hidden_dim))
        
        # One time step
        
        out, (hn, cn) = self.lstm(x, (h0,c0))
        #print(out.shape, hn.shape, cn.shape)
        # Index hidden state of last time step
        # out.size() --> 100, 28, 100
        # out[:, -1, :] --> 100, 100 --> just want last time step hidden states! 
        out = self.fc(out[:, -1, :]) 
        # out.size() --> 100, 10
        #print("out",out.shape)
        return out