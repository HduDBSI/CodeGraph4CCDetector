package googlejam1.p593;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mushrooms {
	
	public static void main(String[] args) throws IOException{
		String folder = "round1a/";
		String fileInPath = folder + "A-large.in"; 
		String fileOutPath = folder + "mushrooms.txt";
		
		Scanner sc = new Scanner(new FileReader(fileInPath));
		FileWriter fOut = new FileWriter(fileOutPath);
		
		int numCases = sc.nextInt();
		for (int caseNo=1; caseNo <= numCases; caseNo++){
			int numTimes = sc.nextInt();
			int eaten1 = 0;
			int eaten2 = 0;
			int[] mushrooms = new int[numTimes];
			for (int i = 0; i < numTimes; i++) { //gather data
				mushrooms[i] = sc.nextInt();
			}
			
			int diff = 0;
			int eatRate = 0;
			for (int i = 1; i < numTimes; i++) {
				diff = mushrooms[i-1] - mushrooms[i];
				if (diff > 0) {
					eaten1 += diff; 
				} 
				if (diff > eatRate) {
					eatRate = diff;
				}
			}
			// now eaten1 is done and we have the eating rate
			for (int i = 0; i < numTimes - 1; i++) {
				int leftover = mushrooms[i] - eatRate;
				if (leftover > 0) {
					eaten2 += eatRate;
				} else {
					eaten2 += mushrooms[i];
				}
			}
			
			fOut.write("Case #" + caseNo + ": " + eaten1 + " " + eaten2 + '\r' + '\n');
			if (caseNo % 10 == 0) {
				System.out.println("Case " + caseNo + " done");
			}			
		}
				
		sc.close();
		fOut.close();
		System.out.println("Done!");
	}
}
