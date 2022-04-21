package googlejam3.p326;


import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("A-sample.in"));
		//BufferedReader br = new BufferedReader(new FileReader("A-small-attempt1.in"));
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		
		//File file = new File("A-sample.out");
		//File file = new File("A-small.out");
		File file = new File("A-large.out");
		
		if(!file.exists()) file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsolutePath());
		BufferedWriter bw = new BufferedWriter(fw);
		
		int numberOfCases = Integer.parseInt(br.readLine());
		for(int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
			
			String[] setup = br.readLine().split(" ");
			int r = Integer.parseInt(setup[0]);
			int c = Integer.parseInt(setup[1]);
			int w = Integer.parseInt(setup[2]);
			
			int findRow = (c / w) * r;
			int rowRemainder = c % w;
			
			int findCol = rowRemainder == 0 ? w - 1 : w;
			int number = findRow + findCol;
			
			String output = "Case #" + caseNum + ": " + number + "\n";
			System.out.println(output);
			bw.write(output);
		}
		
		bw.close();
	}
}
