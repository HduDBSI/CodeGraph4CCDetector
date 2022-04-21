
__author__ = "Jaideep Murkute"

import torch
import torch.nn as nn
import torch.nn.functional as F


class FocalLoss(nn.Module):
    def __init__(self, args, gamma=0, alpha=None, logits=False):
        """
        Computes Focal loss based on : https://arxiv.org/pdf/1708.02002.pdf
        :param gamma: Scalar for the the desired amount of cross-entropy skewness.
        :param alpha: Class weights for C classes. If scalar, same value applied for all the classes.
        :param logits: If True, 'inputs' will be assumed to be unnormalized raw outputs of the model.
        """
        super(FocalLoss, self).__init__()
        self.logits = logits

        self.gamma = gamma

        if isinstance(alpha, (float, int)):
            self.alpha = torch.Tensor([alpha]).to(args.device)
        elif isinstance(alpha, list):
            self.alpha = torch.Tensor(alpha).to(args.device)
        elif 'numpy' in str(type(alpha)):
            self.alpha = torch.from_numpy(alpha).to(args.device)
        elif not alpha:
            self.alpha = torch.Tensor([1.0]).to(args.device)

    def forward(self, inputs, targets):
        if not self.logits:
            if not(torch.max(inputs) <= 1 and torch.min(inputs) >= 0):
                print("self.logits is set to False. Expecting probability value in 'inputs'. "
                      "Found values exceeding range [0, 1].")

        if self.logits:
            BCE_loss = F.binary_cross_entropy_with_logits(inputs, targets, reduce=False)
        else:
            BCE_loss = F.binary_cross_entropy(inputs, targets, reduction='none')

        pt = torch.exp(-BCE_loss)

        return self.alpha * (1 - pt) ** self.gamma * BCE_loss
