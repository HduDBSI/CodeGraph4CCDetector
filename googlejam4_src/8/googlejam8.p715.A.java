package googlejam8.p715;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class A {
	
	public static void main(String[] args) {
		A a = new A();
		try{
			BufferedReader br=new BufferedReader(new FileReader("A-large.in"));
			BufferedWriter out=new BufferedWriter(new FileWriter("A-large.in".split("\\.")[0]+"_output.txt"));
			String s;
		
			if((s=br.readLine())!=null){
				int noLines = Integer.parseInt(s);
				if(noLines!=0){
					for (int index = 0; index < noLines; index++) {
						if ((s = br.readLine()) != null) {
							String outputString = "Case #" + (index + 1) + ": ";
							int inputParties = Integer.parseInt(s.trim());
							String inputString = br.readLine().trim();
							String[] tokenizer = inputString.split(" ");
							HashMap<Character, Integer> hmIn=new HashMap<Character, Integer>();
							for(int i=0;i<inputParties;i++){
								hmIn.put((char)('A'+i), Integer.parseInt(tokenizer[i]));
							}
							String output = "";
							while(hmIn.size()>2){
								int maxValueInMap=(Collections.max(hmIn.values()));
								for(Iterator<HashMap.Entry<Character, Integer>> it = hmIn.entrySet().iterator(); it.hasNext(); ) {
									HashMap.Entry<Character, Integer> entry = it.next();
									if (entry.getValue()==maxValueInMap) {
										output = output + entry.getKey() + " ";
										if(entry.getValue() == 1){
											it.remove();
											break;
										}
										else{
											entry.setValue(entry.getValue()-1);
										}
									}
								}
							}
							if(hmIn.size()==2){
								int key1=-1,key2=-1;
								Character key1c=' ',key2c=' ';
								for(Character key : hmIn.keySet()){
									if(key1==-1){
										key1 = hmIn.get(key);
										key1c = key;
									}
									else{
										key2 = hmIn.get(key);
										key2c = key;
									}
								}
								if(key1>key2){
									for(int i=0;i<(key1-key2);i++)
										output += key1c + " ";
								}
								if(key2>key1){
									for(int i=0;i<(key2-key1);i++)
										output += key2c + " ";
								}
								if(key1==key2){
									for(int i=0;i<key1;i++)
										output +=  key1c + "" + key2c + " ";
								}
							}
							String output1 = output.trim();
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
