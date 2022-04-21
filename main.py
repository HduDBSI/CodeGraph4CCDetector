#-*- coding: utf-8 -*-

import ssl

ssl._create_default_https_context = ssl._create_unverified_context
import torch
import torch.nn as nn
import torch.nn.functional as F
import torch.optim as optim
from tqdm import tqdm, trange
import argparse
from jsonparse import saveAllDataToRam
from jsonparse import getCodePairDataList
from myModels.GAT_Edgepool_clone_detection import CodeCloneDetection
from layers.Focal_loss import FocalLoss
import random
from sklearn.metrics import recall_score,precision_score,f1_score
from myModels.GAT_Edgepool_graphEmb import graphEmb
from myModels.GAT_Edgepool_bi_lstm import bi_lstm_detect



parser = argparse.ArgumentParser()
parser.add_argument('--epochs', type=int, default=100)
parser.add_argument('--batch_size', type=int, default=64)
parser.add_argument('--lr', type=float, default=0.001)
parser.add_argument('--lr_decay_factor', type=float, default=0.5)
parser.add_argument('--weight_decay', type=float, default=5e-4, help='Weight decay (L2 loss on parameters).')
parser.add_argument('--lr_decay_step_size', type=int, default=50)
parser.add_argument('--num_layers', type=int, default=4)
parser.add_argument('--hidden', type=int, default=16)
parser.add_argument('--num_classes', type=int, default=2)
parser.add_argument('--nheads', type=int, default=16)
parser.add_argument('--dropout', type=int, default=0.1)
parser.add_argument('--alpha', type=int, default=0.2)
parser.add_argument("--threshold", default=0)
args = parser.parse_args()
device = "cuda" if torch.cuda.is_available() else "cpu"

def logger(info):
    fold, epoch = info['fold'] + 1, info['epoch']
    val_loss, test_acc = info['val_loss'], info['test_acc']
    print('{:02d}/{:03d}: Val Loss: {:.4f}, Test Accuracy: {:.3f}'.format(fold, epoch, val_loss, test_acc))

#----------------------------------------------------------------
indexdir='DataSetJsonVec/GCJ/javadata/'
id = '11'
jsonVecPath = "DataSetJsonVec/GCJ/dataSetCfgGCJ16/"
sourceCodePath = "googlejam4_src/"
#jsonVecPath = "DataSetJsonVec/BCB/BCB-CFG-16v/"
print(jsonVecPath, " ", id)
if id=='0':
    trainfile=open(indexdir+'trainall.txt')
    validfile = open(indexdir+'valid.txt')
    testfile = open(indexdir+'test.txt')
elif id=='13':
    trainfile = open(indexdir+'train13.txt')
    validfile = open(indexdir+'valid.txt')
    testfile = open(indexdir+'test.txt')
elif id=='11':
    trainfile = open(indexdir+'train11.txt')
    validfile = open(indexdir+'valid.txt')
    testfile = open(indexdir+'test.txt')
elif id=='0small':
    trainfile = open(indexdir+'trainsmall.txt')
    validfile = open(indexdir+'valid.txt')
    testfile = open(indexdir+'test.txt')
elif id == '13small':
    trainfile = open(indexdir+'train13small.txt')
    validfile = open(indexdir+'validsmall.txt')
    testfile = open(indexdir+'testsmall.txt')
elif id=='11small':
    trainfile = open(indexdir+'train11small.txt')
    validfile = open(indexdir+'validsmall.txt')
    testfile = open(indexdir+'testsmall.txt')
else:
    print('file not exist')
    quit()
trainlist=trainfile.readlines()
validlist=validfile.readlines()
testlist=testfile.readlines()

print("trainlist",len(trainlist))
print("validlist",len(validlist))
print("testlist",len(testlist))

def getBatch(line_list, batch_size, batch_index, device):
    start_line = batch_size*batch_index
    end_line = start_line+batch_size
    dataList = getCodePairDataList(ramData,line_list[start_line:end_line])
    return dataList



class FocalLoss(nn.Module):
    def __init__(self, alpha=1, gamma=2, logits=False, reduce=True):
        super(FocalLoss, self).__init__()
        self.alpha = alpha
        self.gamma = gamma
        self.logits = logits
        self.reduce = reduce

    def forward(self, inputs, targets):
        if self.logits:
            BCE_loss = F.binary_cross_entropy_with_logits(inputs, targets, size_average=None, reduce=None)
        else:
            BCE_loss = F.binary_cross_entropy(inputs, targets, size_average=None, reduce=None)
        
        pt = torch.exp(-BCE_loss)
        F_loss = self.alpha * (1-pt)**self.gamma * BCE_loss

        if self.reduce:
            return torch.mean(F_loss)
        else:
            return F_loss

criterion=FocalLoss().to(device)

def graph_emb(data,epoch):
    model = graphEmb(args.num_layers, args.hidden, args.nheads, args.num_classes, args.dropout, args.alpha, False).to(device)
    saveModel = torch.load('./saveModel/epoch'+str(epoch)+'.pkl')
    model_dict = model.state_dict()
    state_dict = {k:v for k,v in saveModel.items() if k in model_dict.keys()}
    #print(state_dict.keys())
    model_dict.update(state_dict)
    model.load_state_dict(model_dict)
    #print("loaded "+ 'epoch'+str(epoch)+'.pkl')
    model.eval()
    features, edge_index, edgesAttr, adjacency, node2node_features = data
    data = features, edge_index, edgesAttr, adjacency, node2node_features
    h = model(data)
    return h
def bi_lstm_detection(data,epoch):
    model = bi_lstm_detect(args.num_layers, args.hidden, args.nheads, args.num_classes, args.dropout, args.alpha, False).to(device)
    saveModel = torch.load('./saveModel/epoch'+str(epoch)+'.pkl')
    model_dict = model.state_dict()
    state_dict = {k:v for k,v in saveModel.items() if k in model_dict.keys()}
    #print(state_dict.keys())
    model_dict.update(state_dict)
    model.load_state_dict(model_dict)
    #print("loaded "+ 'epoch'+str(epoch)+'.pkl')
    model.eval()
    h1, h2 = data
    out = model(h1, h2)
    return out

def split_batch(init_list, batch_size):
    groups = zip(*(iter(init_list),) * batch_size)
    end_list = [list(i) for i in groups]
    count = len(init_list) % batch_size
    end_list.append(init_list[-count:]) if count != 0 else end_list
    return end_list

def test(testlist,model_index, ramData, batch_size):
    graphEmbDict = {}
    print("save graphEmbDict...")
    for codeID in tqdm(ramData):
        data = ramData[codeID]
        graphEmbDict[codeID] = graph_emb(data, model_index).tolist()

    notFound = 0
    testCount = 0
    y_preds = []
    y_trues = []
    batches = split_batch(testlist, batch_size)
    Test_data_batches = trange(len(batches), leave=True, desc = "Test")
    for i in Test_data_batches:
        h1_batch = []
        h2_batch = []
        label_batch = []
        for codepair in batches[i]:
            try:
                test_data = codepair.split()
                graphEmbDict[test_data[0]]
                graphEmbDict[test_data[1]]
                testCount+=1
            except:
                notFound+=1
                continue

            test_data = codepair.split()
            h1 = torch.as_tensor(graphEmbDict[test_data[0]]).to(device)
            h2 = torch.as_tensor(graphEmbDict[test_data[1]]).to(device)
            label = int(test_data[2])
            
            h1_batch.append(h1)
            h2_batch.append(h2)
            label_batch.append(label)

        h1_batch_t = torch.stack(h1_batch, dim=1).squeeze(0)
        h2_batch_t = torch.stack(h2_batch, dim=1).squeeze(0)
        #print("h1_batch",h1_batch.shape)
        data = h1_batch_t, h2_batch_t
        outputs = bi_lstm_detection(data, model_index)
        _, predicted = torch.max(outputs.data, 1)
        y_preds += predicted.tolist()
        y_trues += label_batch

        h1_batch = []
        h2_batch = []
        label_batch = []

        r_a=recall_score(y_trues, y_preds, average='macro')
        p_a=precision_score(y_trues, y_preds, average='macro')
        f_a=f1_score(y_trues, y_preds, average='macro')

        Test_data_batches.set_description("Test (p_a=%.4g,r_a=%.4g,f_a=%.4g)" % (p_a, r_a, f_a))
    print("testCount",testCount)
    print("notFound",notFound)
    return p_a, r_a, f_a

def get_parameter_number(model):
    total_num = sum(p.numel() for p in model.parameters())
    trainable_num = sum(p.numel() for p in model.parameters() if p.requires_grad)
    return {'Total': total_num, 'Trainable': trainable_num}

def train():
    #start_train_model_index = 7
    addNum = 0
    model = CodeCloneDetection(args.num_layers, args.hidden, args.nheads, args.num_classes, args.dropout, args.alpha, True).to(device)
    #model.load_state_dict(torch.load('./saveModel/epoch'+str(start_train_model_index)+'.pkl'))
    #优化器使用Adam
    optimizer = optim.Adam(model.parameters(), lr=args.lr, weight_decay=args.weight_decay)
    model.train()
    #print("loaded ", './saveModel/epoch'+str(start_train_model_index)+'.pkl')
    for name, param in model.named_parameters():
        if param.requires_grad:
            print(name)
    print("模型总参：", get_parameter_number(model))
    print("nheads ", args.nheads," batch_size ", args.batch_size)
    print("dropout = ",args.dropout)
    random.shuffle(trainlist)
    epochs = trange(args.epochs, leave=True, desc = "Epoch")
    iterations = 0
    for epoch in epochs:
        #print(epoch)
        totalloss=0.0
        main_index=0.0
        #batches = create_batches(trainDataList)
        #for index, batch in tqdm(enumerate(batches), total=len(batches), desc = "Batches"):
        count = 0
        right = 0
        acc = 0
        for batch_index in tqdm(range(int(len(trainlist)/args.batch_size))):
            batch = getBatch(trainlist, args.batch_size, batch_index, device)
            optimizer.zero_grad()
            batchloss= 0
            recoreds = open("recoreds.txt", 'a')
            
            for data in batch:
                
                features1, features2, edge_index1, edge_index2, edgesAttr1, edgesAttr2, adjacency1, adjacency2, node2node_features1, node2node_features2, label = data
                
                data = features1, features2, edge_index1, edge_index2, edgesAttr1, edgesAttr2, adjacency1, adjacency2, node2node_features1, node2node_features2
                
                label=torch.Tensor([[0,1]]).to(device) if label==1 else torch.Tensor([[1,0]]).to(device)
                #print("label ",label.device," ",label)
                output = model(data)
                #print("criterion",criterion(prediction,label))
                #cossim=F.cosine_similarity(h1,h2)
                #print("output",output)
                #print("label",label)
                batchloss = batchloss + criterion(output, label)
                count += 1
                right += torch.sum(torch.eq(torch.argmax(output, dim=1), torch.argmax(label, dim=1)))
            #print("batchloss",batchloss)
            acc = right*1.0/count
            batchloss.backward(retain_graph = True)
            optimizer.step()
            loss = batchloss.item()
            totalloss += loss
            main_index = main_index + len(batch)
            loss = totalloss/main_index
            epochs.set_description("Epoch (Loss=%g) (Acc = %g)" % (round(loss,5) , acc))
            iterations += 1
            recoreds.write(str(iterations+addNum*14078) +" "+ str(acc.item()) +" "+ str(loss)+"\n")
            recoreds.close()
        #if(epoch%10==0 and epoch>0):
        torch.save(model.state_dict(), './saveModel/epoch'+str(epoch+addNum)+'.pkl')
        val_recoreds = open("val_recoreds.txt", 'a')
        p,r,f1 = test(validlist,epoch+addNum, ramData, 15000)
        val_recoreds.write(str(epoch+addNum) +" "+ str(p) +" "+ str(r) +" "+ str(f1)+"\n")
        val_recoreds.close()

        test_recoreds = open("test_recoreds.txt", 'a')
        p,r,f1 = test(testlist,epoch+addNum, ramData, 15000)
        test_recoreds.write(str(epoch+addNum) +" "+ str(p) +" "+ str(r) +" "+ str(f1)+"\n")
        test_recoreds.close()




print("add all data to ram...")
ramData = saveAllDataToRam(sourceCodePath,jsonVecPath)

train()

