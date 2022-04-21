package googlejam1.p515;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ProblemASmall {

	
	public static void main(String[] args) throws IOException {
		
		
		
//		File inf = new File("input.txt");
//		File inf = new File("A-small-attempt0.in");
		File inf = new File("A-large.in");
		File outf = new File("output.txt");
		Scanner scanner = new Scanner(inf);
		BufferedWriter out = new BufferedWriter(new FileWriter(outf));
		int caseNum = scanner.nextInt();
		for (int i = 1; i <= caseNum; i++) {
			String outStr = "Case #" + i + ": ";
			// TODO Auto-generated method stub
//			int ans1 = 0;
//			int ans2 = 0;
			int N = scanner.nextInt();
			int[] list = new int [N];
			for (int j = 0; j < list.length; j++) {
				list[j] = scanner.nextInt();
			}
			BigInteger ans = new BigInteger("0");
			for (int i1 = 1; i1 < list.length; i1++) {
				if (list[i1] < list[i1-1]) {
					int num = list[i1-1] - list[i1];
					ans = ans.add(new BigInteger(Integer.toString(num)));
				}
			}
			BigInteger ans1 = ans;
			int maxInter = 0;
			for (int i1 = 1; i1 < list.length; i1++) {
				if (list[i1] < list[i1-1] && list[i1-1] - list[i1] > maxInter) {
					maxInter = list[i1-1] - list[i1];
				}
			}
			BigInteger ans3 = new BigInteger("0");
			for (int i2 = 0; i2 < list.length-1; i2++) {
				int num = (list[i2]  < maxInter) ? list[i2] : maxInter;
				ans3 = ans3.add(new BigInteger(Integer.toString(num)));
				
			}
			BigInteger ans2 = ans3;
			outStr += ans1 + " " + ans2;
			System.out.println(outStr);
			out.write(outStr + "\n");
		}
//		in.close();
		scanner.close();
		out.close();
	}

}
