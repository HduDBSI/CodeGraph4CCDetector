package googlejam1.p538;

import java.util.*;
import java.lang.*;
import java.io.*;

public class A {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new File("A.in"));
		FileWriter out = new FileWriter("aout.txt");
		
		int T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int[] m = new int[N];
			int min1 = 0;
			for (int j = 0; j < N; j++) {
				m[j] = in.nextInt();
			}
			
			for (int j = 1; j < N; j++) {
				min1 += (m[j] < m[j-1]) ? m[j - 1] - m[j] : 0;
			}
			
			int minRate = 0;
			for (int j = 1; j < N; j++) {
				minRate = Math.max(minRate, m[j-1] - m[j]);
			}
			
			int min2 = 0;
			for (int j = 0; j < N - 1; j++) {
				min2 += Math.min(m[j], minRate);
			}
			
			out.write("Case #" + i + ": " + min1 + " " + min2 + "\n");
			System.out.print("Case #" + i + ": " + min1 + " " + minRate + "\n");
			System.out.print("Case #" + i + ": " + min1 + " " + min2 + "\n");
		}
		in.close();
		out.close();
	}

}
