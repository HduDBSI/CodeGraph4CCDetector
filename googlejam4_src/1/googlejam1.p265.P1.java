package googlejam1.p265;


import java.io.*;
import java.util.*;

public class P1 {
	public static final String filename = "A-large";
	public static Scanner in;
	public static PrintStream out;

	public static void main(String[] args) throws Exception {
		in = new Scanner(new File(filename + ".in"));
		out = new PrintStream(new FileOutputStream(filename + ".out"));
		
		int num = Integer.parseInt(in.nextLine());
		for (int i = 1; i <= num; i++) {
			String line = in.nextLine();
			int n = Integer.parseInt(line);
			int[] arr = new int[n];
			String[] ss = in.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(ss[j]);
			}
			int sum = 0;
			for (int i1 = 0; i1 < arr.length - 1; i1++) {
				if (arr[i1] > arr[i1 + 1])
					sum += arr[i1] - arr[i1 + 1];
			}
			int res1 = sum;
			int sum1 = 0;
			int rate = 0;
			for (int i2 = 0; i2 < arr.length - 1; i2++) {
				if (arr[i2] - arr[i2 + 1] > rate)
					rate = arr[i2] - arr[i2 + 1];
			}
			
			for (int i1 = 0; i1 < arr.length - 1; i1++) {
				if (arr[i1] >= rate) {
					sum1 += rate;
					arr[i1] -= rate;
				} else { // a[i] < rate
					sum1 += arr[i1];
					arr[i1] = 0;
				}
			}
			int res2 = sum1;
			String s = "Case #" + i + ": " + res1 + " " + res2;
			System.out.println(s);
			out.println(s);
		}
		in.close();
		out.close();
	}
}
