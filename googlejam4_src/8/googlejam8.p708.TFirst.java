package googlejam8.p708;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class TFirst {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner reader = new Scanner(System.in);

		HashMap<Character,Integer>map=new HashMap<Character, Integer>();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		
		int z = 0;
		
		
		PrintStream out = new PrintStream(new FileOutputStream("output5.txt"));
		System.setOut(out);
		
		int num = reader.nextInt();
		int curr;
		for(curr = 0;curr<num;curr++){
			map.clear();
			int i1 = 0;
			
			System.out.print("Case #" + (curr+1) + ":");
			int n = reader.nextInt();
			int i;
			char a;
			char b;
			int sum = 0;
			for(i=0;i<n;i++){
				int value = reader.nextInt();
				map.put(letters.charAt(i), value);
				sum+=value;
			}
			int found;
			while(sum>2){
				found = 0;
				int total = 0;
		        int maxValueInMap=(Collections.max(map.values()));
		        for (Entry<Character, Integer> entry : map.entrySet()) {  
		            if (entry.getValue()==maxValueInMap) {
		            	total++;
		            }
		        }
		        for (Entry<Character, Integer> entry : map.entrySet()) {  
		            if (entry.getValue()==maxValueInMap) {
		            	if(total!=2){
			                System.out.print(" " + entry.getKey());     
			                map.put(entry.getKey(),entry.getValue()-1);
			                sum--;
			                break;
		            	}
		            	else{
		            		found++;
			            	if(found == 1){
			            		a = entry.getKey();
			            		System.out.print(" " + a);
				                map.put(entry.getKey(),entry.getValue()-1);
				                sum--;
			            	}else if(found == 2){
			            		b = entry.getKey();			                
			            		map.put(entry.getKey(),entry.getValue()-1);

				                System.out.print(b); 
				                sum--;
				                break;
			            	}
		            	}
		            }
		        }
			}
			System.out.print(" "); 		        
			for (Entry<Character, Integer> entry : map.entrySet()) {
			   if(entry.getValue()!=0){
				   System.out.print(entry.getKey());
			   }
	        }
			System.out.println();
		}
	}
}
