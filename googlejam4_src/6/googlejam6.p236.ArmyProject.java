package googlejam6.p236;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class ArmyProject {
	
	Scanner in;	public static void main(String[] args){
		ArmyProject myClass = new ArmyProject();
		try {			
					
					
					myClass.in =  new Scanner(new BufferedReader(new FileReader("B-large.in")));
					//in = new Scanner(System.in);
				myClass.writer = new FileWriter("the-file-name.txt");
				int T = myClass.in.nextInt();
					for(int i = 1; i <= T; i++){
					int N = myClass.in.nextInt();
					
					HashMap<Integer, Integer> countHeights = new HashMap<Integer, Integer>();
					
					
					for(int j = 1; j <= (2*N - 1); j++){
						for(int k = 1; k <= N; k++){
							int h = myClass.in.nextInt();
							
							if(!countHeights.containsKey(h)){
								countHeights.put(h, 0);
							}
							countHeights.put(h, countHeights.get(h)+1);
						}
					}
				
					ArrayList<Integer> list = new ArrayList<Integer>();
					
		for(Integer k : countHeights.keySet()){
			if((countHeights.get(k) % 2) != 0){
				list.add(k);
			}
		}
					Collections.sort(list);
					
					
					
					
					
					StringBuilder s = new StringBuilder();
		
					s.append("Case #");
					s.append(i);
					s.append(": ");
					
					
					
					for(int j = 0; j < list.size(); j++){
						s.append(list.get(j) + " ");
					}
					
					s.append("\n");
					
			myClass.writer.write(s.toString());
					
							}
				myClass.writer.close();			
				}
					catch (IOException e) {
					}
	}
	
	FileWriter writer;
		
		
		
	}
	

