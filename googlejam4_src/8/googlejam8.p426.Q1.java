package googlejam8.p426;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//String line = br.readLine();
        //int numberOfCases = Integer.parseInt(line);
		int numberOfCases = in.nextInt();
        for (int i = 1; i <= numberOfCases; i++){
            int party = in.nextInt();
			//build array
			int[] parties = new int[party];
			for (int j = 0; j < party; j++){
				parties[j] = in.nextInt();
			}
            escape(i, parties);
            
        }
    }
	
	
	
    
    public static void escape (int num, int[] parties){
        ArrayList<String> evaculateList = new ArrayList<String>();
		//get the TotalNumber
		int total = 0;
		for (int i = 0; i < parties.length;i++){
			total += parties[i];
		}
		
		while (total > 0){
			
			
			//only escape one
			if (total == 3 || total == 1) {
				int biggest = 0;
				int biggestLocation = 0;
				for (int i = 0; i < parties.length; i++){
					if (parties[i] > biggest){
						biggest = parties[i];
						biggestLocation = i;
					}
				}
				parties[biggestLocation] -= 1;
				HashMap<Integer, String> hm = new HashMap<Integer, String>();
				  // Put elements to the map
				  hm.put(0, "A");
				  hm.put(1, "B");
				  hm.put(2, "C");
				  hm.put(3, "D");
				  hm.put(4, "E");
				  hm.put(5, "F");
				  hm.put(6, "G");
				  hm.put(7, "H");
				  hm.put(8, "I");
				  hm.put(9, "J");
				  hm.put(10, "K");
				  hm.put(11, "L");
				  hm.put(12, "M");
				  hm.put(13, "N");
				  hm.put(14, "O");
				  hm.put(15, "P");
				  hm.put(16, "Q");
				  hm.put(17, "R");
				  hm.put(18, "S");
				  hm.put(19, "T");
				  hm.put(20, "U");
				  hm.put(21, "V");
				  hm.put(22, "W");
				  hm.put(23, "X");
				  hm.put(24, "Y");
				  hm.put(25, "Z");
				  String var = hm.get(biggestLocation);
				String escaper = var;
				String thisEscape = escaper;
				evaculateList.add(thisEscape);
				total -= 1;
			} else {//get the biggest two
				int biggest = 0;
				int biggestLocation = 0;
				for (int i = 0; i < parties.length; i++){
					if (parties[i] > biggest){
						biggest = parties[i];
						biggestLocation = i;
					}
				}
				//get the 
				int secondBiggest = 0;
				int secondBiggestLocation = 0;
				for (int i = 0; i < parties.length; i++){
					if (i == biggestLocation) continue;
					if (parties[i] > secondBiggest){
						secondBiggest = parties[i];
						secondBiggestLocation = i;
					}
				}
				
				//Then evacuate the biggest two parties.
				parties[biggestLocation] -= 1;
				parties[secondBiggestLocation] -= 1;
				total -= 2;
				HashMap<Integer, String> hm = new HashMap<Integer, String>();
				  // Put elements to the map
				  hm.put(0, "A");
				  hm.put(1, "B");
				  hm.put(2, "C");
				  hm.put(3, "D");
				  hm.put(4, "E");
				  hm.put(5, "F");
				  hm.put(6, "G");
				  hm.put(7, "H");
				  hm.put(8, "I");
				  hm.put(9, "J");
				  hm.put(10, "K");
				  hm.put(11, "L");
				  hm.put(12, "M");
				  hm.put(13, "N");
				  hm.put(14, "O");
				  hm.put(15, "P");
				  hm.put(16, "Q");
				  hm.put(17, "R");
				  hm.put(18, "S");
				  hm.put(19, "T");
				  hm.put(20, "U");
				  hm.put(21, "V");
				  hm.put(22, "W");
				  hm.put(23, "X");
				  hm.put(24, "Y");
				  hm.put(25, "Z");
				  String var = hm.get(biggestLocation);
				String escaper = var;
				HashMap<Integer, String> hm = new HashMap<Integer, String>();
				  // Put elements to the map
				  hm.put(0, "A");
				  hm.put(1, "B");
				  hm.put(2, "C");
				  hm.put(3, "D");
				  hm.put(4, "E");
				  hm.put(5, "F");
				  hm.put(6, "G");
				  hm.put(7, "H");
				  hm.put(8, "I");
				  hm.put(9, "J");
				  hm.put(10, "K");
				  hm.put(11, "L");
				  hm.put(12, "M");
				  hm.put(13, "N");
				  hm.put(14, "O");
				  hm.put(15, "P");
				  hm.put(16, "Q");
				  hm.put(17, "R");
				  hm.put(18, "S");
				  hm.put(19, "T");
				  hm.put(20, "U");
				  hm.put(21, "V");
				  hm.put(22, "W");
				  hm.put(23, "X");
				  hm.put(24, "Y");
				  hm.put(25, "Z");
				  String var = hm.get(secondBiggestLocation);
				String escaper2 = var;
				String thisEscape = escaper + escaper2;
				evaculateList.add(thisEscape);
				}
		}
		
		System.out.print("Case #" + num + ": ");
		for (int i = 0; i < evaculateList.size(); i++){
			System.out.print(evaculateList.get(i) + " ");
		}
		System.out.println();
		}
		
		
		
		
		
		
    
    
}
