package googlejam8.p633;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class a1 {

	private static final String[] PL = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public static void main(String[] args) {
//		readAndSolve("resource/gcj2016/c1/a1/sample.in", "resource/gcj2016/c1/a1/sample.out");
//		readAndSolve("resource/gcj2016/c1/a1/A-small-attempt0.in", "resource/gcj2016/c1/a1/A-small-attempt0.out");
		BufferedReader input = null;
		BufferedWriter output = null;
		Date d1 = new Date();
		try {
			input = new BufferedReader(new FileReader("resource/gcj2016/c1/a1/A-large.in"));
			output = new BufferedWriter(new FileWriter("resource/gcj2016/c1/a1/A-large.out"));
			String line1 = null;
			String line2 = null;
			int expectedCases = 0;
			int actualCase = -1;
			line1=input.readLine();
			expectedCases = Integer.parseInt(line1);
			for (actualCase = 1; actualCase<=expectedCases; actualCase++) {
				line1=input.readLine();
				line2=input.readLine();
				Scanner sc = new Scanner(line1);
						int partynum = sc.nextInt();
						Scanner sc1 = new Scanner(line2);
						int[] parties1 = new int[partynum];
						for (int i2 = 0; i2< partynum; i2++ ) {
							parties1[i2] = sc1.nextInt();
						}
						int[] parties = parties1;
						int result2 = 0;
						for(int i1 : parties) {
							result2 +=i1;
						}
						int totalcount = result2;
						StringBuffer sb = new StringBuffer(2*partynum);
						while (totalcount > 0) {
							int[] result1 = new int[2];
							int[] maxvalues = new int[2];
							result1[0] = -1;
							result1[1] = -1;
							maxvalues[0] = -1;
							maxvalues[1] = -1;
							for (int i = 0; i<parties.length; i++){
								if (parties[i]> maxvalues[0]) {
									result1[1] = result1[0];
									maxvalues[1] = maxvalues[0];
									result1[0] = i;
									maxvalues[0] = parties[i];
								} else {
									if (parties[i] > maxvalues[1]) {
										result1[1] =i;
										maxvalues[1] = parties[i];
									}
								}
							}
							int[] x = result1;
				//			System.out.println(x[0] + " " +x[1]);
							if ((totalcount ==3) || ((x[1] == -1) && (parties[x[0]] == 1)) ) {
								sb.append(PL[x[0]]);
								parties[x[0]]--;
								totalcount --;
							} else {
								if ((x[1] == -1) || (parties[x[0]] - parties[x[1]] > 1)) {
									sb.append(PL[x[0]]);					
									sb.append(PL[x[0]]);
									parties[x[0]]-=2;
									totalcount-=2;
								} else {
									sb.append(PL[x[0]]);
									parties[x[0]]--;
									sb.append(PL[x[1]]);
									parties[x[1]]--;
									totalcount-=2;
								}
							}
							sb.append(" ");
						}
				String result = sb.toString().trim();
				output.write("Case #" + actualCase +": " + result + "\n");				
				System.out.println("Case #" + actualCase +": " + result );				
			}
			input.close();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
