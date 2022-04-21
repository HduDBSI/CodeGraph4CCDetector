import json
import os
from tqdm import tqdm
from pathlib import Path
import torch


def get_adj_node2node(h, edge_index, edge_attr):
    indices = edge_index.to('cuda')
    values = torch.ones((len(edge_index[0]))).to('cuda')
    adjacency = torch.sparse.FloatTensor(indices, values, torch.Size((len(h),len(h)))).to_dense()

    node2node_features = torch.zeros(len(h)*len(h),edge_attr.size()[1]).to('cuda')
    for i in range(len(edge_index[0])):
        node2node_features[len(h)*edge_index[0][i]+edge_index[1][i]] = edge_attr[i]

    return adjacency, node2node_features

def saveAllDataToRam(sourceCodePath,jsonVecPath):

    ramData = {}  #save all data to a dict. i.e. {"jsonVecID1":[lines, features, edge_index, edge_attr], "jsonVecID2":[lines, features, edge_index, edge_attr],...}
    faildFileNum = 0
    count=0
    for root, dirs, files in os.walk(sourceCodePath):
        for file in tqdm(files):
            try:
                sourceCodeFolderID = file.split(".")[0][-1]
                CodePath = sourceCodePath + sourceCodeFolderID +'/'+ file
                jsonPath = jsonVecPath + file + ".json"
               
                #for codedata
                data = json.load(open(jsonPath))

                nodes = []
                features = []
                edgeSrc = []
                edgeTag = []
                edgesAttr = []
                hidden = 16
                max_node_token_num = 0
                for node in data["jsonNodesVec"]:
                    #print("len(data[jsonNodesVec][node])",len(data["jsonNodesVec"][node]))
                    if len(data["jsonNodesVec"][node]) > max_node_token_num:
                        max_node_token_num = len(data["jsonNodesVec"][node])
                
                
                for i in range(len(data["jsonNodesVec"])):
                    nodes.append(i)
                    node_features = []
                    for list in data["jsonNodesVec"][str(i)]:
                        if list != None:
                            node_features.append(list)
                    if len(node_features)==0:
                        #print("node 000000000000000000000000000", jsonPath," ",i)
                        node_features = [[0 for i in range(hidden)]]
                    if len(node_features) < max_node_token_num:
                        for i in range(max_node_token_num-len(node_features)):
                            node_features.append([0 for i in range(hidden)])
                    #print("node_features",len(node_features))
                    features.append(node_features)  # multi vecs offen
                
                for edge in data["jsonEdgesVec"]:
                    #print(len(data["jsonEdgesVec"][edge]))
                    
                    if data["jsonEdgesVec"][edge][0][0] == 1 and data["jsonEdgesVec"][edge][0][1] == 1 and data["jsonEdgesVec"][edge][0][3] ==1:
                        edgeSrc.append(int(edge.split("->")[0]))
                        edgeTag.append(int(edge.split("->")[1]))
                        edgesAttr.append([0 for i in range(hidden)])
                        #continue
                    else:
                        edgeSrc.append(int(edge.split("->")[0]))
                        edgeTag.append(int(edge.split("->")[1]))
                        edgesAttr.append(data["jsonEdgesVec"][edge][0])  # one vec always
                
                for i in range(len(nodes)):
                    edgeSrc.append(i)
                    edgeTag.append(i)
                    #edgesAttr.append([0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536])
                    edgesAttr.append([0 for i in range(hidden)])
                edge_index = [edgeSrc, edgeTag]
                features = torch.tensor(features, dtype=torch.float32).to('cuda')
                edge_index = torch.tensor(edge_index, dtype=torch.long).to('cuda')
                edgesAttr = torch.tensor(edgesAttr, dtype=torch.float32).to('cuda')
                
                adjacency, node2node_features = get_adj_node2node(features, edge_index, edgesAttr)
                ramData[CodePath] = [features, edge_index, edgesAttr, adjacency, node2node_features]
                count+=1
            except:
                faildFileNum+=1
    print(count, faildFileNum)
    print("ramData", len(ramData))
    return ramData  #i.e. {"jsonVecID1":[lines, features, edge_index, edge_attr], "jsonVecID2":[lines, features, edge_index, edge_attr],...}





def saveTestDataToRam(testList,sourceCodePath,jsonVecPath):

    ramData = {}  #save all data to a dict. i.e. {"jsonVecID1":[lines, features, edge_index, edge_attr], "jsonVecID2":[lines, features, edge_index, edge_attr],...}
    faildFileNum = 0
    count=0
    for root, dirs, files in os.walk(sourceCodePath):
        for file in tqdm(files):
            try:
                sourceCodeFolderID = file.split(".")[0][-1]
                CodePath = sourceCodePath + sourceCodeFolderID +'/'+ file
                if CodePath not in testList:
                    continue
                jsonPath = jsonVecPath + file + ".json"
               
                #for codedata
                data = json.load(open(jsonPath))

                nodes = []
                features = []
                edgeSrc = []
                edgeTag = []
                edgesAttr = []
                hidden = 16
                max_node_token_num = 0
                for node in data["jsonNodesVec"]:
                    #print("len(data[jsonNodesVec][node])",len(data["jsonNodesVec"][node]))
                    if len(data["jsonNodesVec"][node]) > max_node_token_num:
                        max_node_token_num = len(data["jsonNodesVec"][node])
                for i in range(len(data["jsonNodesVec"])):
                    nodes.append(i)
                    node_features = []
                    for list in data["jsonNodesVec"][str(i)]:
                        if list != None:
                            node_features.append(list)
                    if len(node_features)==0:
                        #print("node 000000000000000000000000000", jsonPath," ",i)
                        node_features = [[0 for i in range(hidden)]]
                    if len(node_features) < max_node_token_num:
                        for i in range(max_node_token_num-len(node_features)):
                            node_features.append([0 for i in range(hidden)])
                    #print("node_features",len(node_features))
                    features.append(node_features)  # multi vecs offen
                
                for edge in data["jsonEdgesVec"]:
                    #print(len(data["jsonEdgesVec"][edge]))
                    
                    if data["jsonEdgesVec"][edge][0][0] == 1 and data["jsonEdgesVec"][edge][0][1] == 1 and data["jsonEdgesVec"][edge][0][3] ==1:
                        edgeSrc.append(int(edge.split("->")[0]))
                        edgeTag.append(int(edge.split("->")[1]))
                        edgesAttr.append([0 for i in range(hidden)])
                        #continue
                    else:
                        edgeSrc.append(int(edge.split("->")[0]))
                        edgeTag.append(int(edge.split("->")[1]))
                        edgesAttr.append(data["jsonEdgesVec"][edge][0])  # one vec always
                
                for i in range(len(nodes)):
                    edgeSrc.append(i)
                    edgeTag.append(i)
                    #edgesAttr.append([0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536, 0.3536])
                    edgesAttr.append([0 for i in range(hidden)])
                edge_index = [edgeSrc, edgeTag]
                features = torch.as_tensor(features, dtype=torch.float32).to('cuda')
                edge_index = torch.as_tensor(edge_index, dtype=torch.long).to('cuda')
                edgesAttr = torch.as_tensor(edgesAttr, dtype=torch.float32).to('cuda')
                adjacency, node2node_features = get_adj_node2node(features, edge_index, edgesAttr)
                ramData[CodePath] = [features, edge_index, edgesAttr, adjacency, node2node_features]
                count+=1
            except:
                faildFileNum+=1
    print(count, faildFileNum)
    return ramData 


def getCodePairDataList(ramData, pathlist):
    datalist = []
    notFindNum = 0
    for line in pathlist:
        try:
            pairinfo = line.split()
            codedata1 = ramData[pairinfo[0]]
            codedata2 = ramData[pairinfo[1]]
            label = int(pairinfo[2])
            
            pairdata = [codedata1[0], codedata2[0], codedata1[1], codedata2[1], codedata1[2], codedata2[2], codedata1[3], codedata2[3], codedata1[4], codedata2[4], label]
            
            datalist.append(pairdata)
        except:
            notFindNum += 1
    
    return datalist