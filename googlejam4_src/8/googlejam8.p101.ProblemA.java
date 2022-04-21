package googlejam8.p101;
import java.io.*;
import java.util.*;

public class ProblemA {
	
	public static void main(String[] agrs) throws FileNotFoundException {
		String FILENAME = "longA";
		
		File FILE = new File(FILENAME);
		
		Scanner fileReader = new Scanner(FILE);
		
		int T =  fileReader.nextInt();
		
		for (int test = 0; test < T; test ++) {
			int parties = fileReader.nextInt();
			int[] senate = new int[parties];
			int left = 0;
			int partiesLeft = parties;
			
			
			for (int party = 0; party < parties; party ++) {
				int x = fileReader.nextInt();
				senate[party] = x;
				left += x;
			}
			
			ArrayList<String> out = new ArrayList<String>();
			char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			
			while (left > 0) {
				
				int biggest = -1;
				int max = -1;
				int biggest2 = -1;
				int max2 = -1;
				for (int party = 0; party < parties; party ++) {
					if (senate[party] >= max) {
						max2 = max;
						biggest2 = biggest;
						max = senate[party];
						biggest = party;
					}
				}
				String addMe = "";
				
				if (partiesLeft == 2 && max == max2) {
					addMe = "" + alphabet[biggest] + alphabet[biggest2];
					left -= 2;
					senate[biggest] -= 1;
					senate[biggest2] -= 1;
					
					if (senate[biggest2] == 0) {
						partiesLeft --;
					}
				} else {
					left -= 1;
					addMe = "" + alphabet[biggest];
					senate[biggest] -= 1;
				}
				
				if (senate[biggest] == 0) {
					partiesLeft --;
				}
				
				out.add(addMe);
			}
			
			int numOuts = out.size();
			System.out.print("Case #" + (test+1) + ": ");
			for (int i = 0; i < numOuts; i ++) {
				String me = out.get(i);
				System.out.print(me + " ");
			}
			System.out.println("");
		}
		fileReader.close();
	}
}