package googlejam6.p458;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class B {
	
	public static void main(String[] args) {
		B b = new B();
		try{
			BufferedReader br=new BufferedReader(new FileReader("B-large.in"));
			BufferedWriter out=new BufferedWriter(new FileWriter("B-large.in".split("\\.")[0]+"_output.txt"));
			String s;
		
			if((s=br.readLine())!=null){
				int noLines = Integer.parseInt(s);
				if(noLines!=0){
					for (int index = 0; index < noLines; index++) {
						if ((s = br.readLine()) != null) {
							int[][] inputMatrix = new int[2*Integer.parseInt(s.trim()) - 1][Integer.parseInt(s.trim())];
							for(int i=0;i<(2*Integer.parseInt(s.trim()) - 1);i++){
								String inA = br.readLine();
								String[] tokenizer = inA.split(" ");
								for(int j =0;j<tokenizer.length;j++){
									inputMatrix[i][j] = Integer.parseInt(tokenizer[j]);
								}
							}
							String outputString = "Case #" + (index + 1) + ": ";
							HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
							for(int[] in : inputMatrix){
								for(int key : in){
									if(hm.containsKey(key)){
										hm.put(key, hm.get(key)+1);
									}
									else{
										hm.put(key, 1);
									}
								}
							}
							
							List<Integer> tempList = new ArrayList<>();
							for(int key:hm.keySet()){
								if(hm.get(key)%2 != 0){
									tempList.add(key);
								}
							}
							
							Collections.sort(tempList);
							
							String returnStr = "";
							for(int rI:tempList){
								returnStr += rI+" ";
							}
							String output1 = returnStr.trim();
							outputString += output1;
							System.out.println(outputString);
							out.write(outputString);
							out.newLine();
						}
					}
				}
			}
			out.close();
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
