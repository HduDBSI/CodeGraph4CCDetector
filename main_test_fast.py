#-*- coding: utf-8 -*-
from collections import namedtuple

import ssl

ssl._create_default_https_context = ssl._create_unverified_context
import torch
import torch.nn as nn
import torch.nn.functional as F
import torch.optim as optim
from jsonparse import saveTestDataToRam
from tqdm import tqdm, trange
import argparse
import torch
import time
from jsonparse import getCodePairDataList
from myModels.GAT_Edgepool_graphEmb import graphEmb
from myModels.GAT_Edgepool_bi_lstm import bi_lstm_detect
from sklearn.metrics import recall_score,precision_score,f1_score

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

#----------------------------------------------------------------
indexdir='DataSetJsonVec/GCJ/javadata/'
id = '11'
jsonVecPath = "DataSetJsonVec/GCJ/dataSetCfgGCJ16/"
sourceCodePath = "googlejam4_src/"
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
    now = time.time()
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
        #print("h1_batch",h1_batch)
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
    print("test speed time:", time.time()-now)
    return p_a, r_a, f_a


model_index = 1

batch_size = 15000
print("add all data to ram...")
testList = []
testFile = open("DataSetJsonVec/GCJ/javadata/test.txt", 'r')
testItems = testFile.readlines()
testFile.close()
for item in testItems:
    code1 = item.split()[0]
    code2 = item.split()[1]
    testList.append(code1)
    testList.append(code2)
print("testList",len(testList))
testList = set(testList)
print("testList",len(testList))
#ramData = saveAllDataToRam(sourceCodePath,jsonVecPath) #i.e. {"jsonVecID1":[lines, features, edge_index, edge_attr], "jsonVecID2":[lines, features, edge_index, edge_attr],...}
ramData = saveTestDataToRam(testList, sourceCodePath,jsonVecPath)
print("model_index",model_index)
print("batch_size",batch_size)


test(testlist, model_index, ramData, batch_size)
