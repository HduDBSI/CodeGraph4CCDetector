package googlejam1.p407;

import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws IOException {
		String inFile = "//Users//user//Documents//workspace//Runnables//src//codejam//y2014//qualification//copy//A-large (1).in";
		//		String outFile = "//Users//user//Documents//workspace//Runnables//src//codejam//Outputs";
		
				Scanner in = new Scanner(new FileReader(inFile));
		//		FileWriter out = new FileWriter(outFile);
				int totalRounds = in.nextInt();
				for (int round = 1; round <= totalRounds; round++) {
					// FORMATTING HERE
					int len = in.nextInt();
					int[] arr = new int[len];
					for (int i = 0; i < len; i++) {
						arr[i] = in.nextInt();
					}
					System.out.format("Case #%d: ", round);
					int y = 0;
					int z = 0;
					int speed = 0;
					int len1 = arr.length;
					for (int i = 0; i < len1 - 1; i++) {
						if(arr[i+1] < arr[i]) {
							int diff = arr[i] - arr[i+1];
							y += diff;
							// for method 2
							if (diff > speed) speed = diff;
						}
					}
					
					//method 2
					for(int i = 0; i < len1 - 1; i++) {
						
						int ate = Math.min(speed, arr[i]);
						//System.out.println("mins: " + speed + " " + arr[i] + "===> " + ate);
						z += ate;
						//System.out.println("ate: " + ate);
					}
					
					System.out.println(y + " " + z);
				}
				in.close();
		//		out.close();
	}
}
