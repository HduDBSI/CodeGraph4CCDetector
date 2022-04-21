package googlejam2.p276;


import java.io.*;
import java.util.*;

public class P1 {
	public static final String filename = "A-small-attempt1";
	public static Scanner in;
	public static PrintStream out;

	public static void main(String[] args) throws Exception {
		in = new Scanner(new File(filename + ".in"));
		out = new PrintStream(new FileOutputStream(filename + ".out"));
		
		int num = Integer.parseInt(in.nextLine());
		for (int i = 1; i <= num; i++) {
			int n = Integer.parseInt(in.nextLine());
			int[] arr = new int[n + 1];
			for (int i2 = 0; i2 <= n; i2++)
				arr[i2] = i2;
			
			for (int i1 = 1; i1 <= n; i1++) {
				int count = arr[i1 - 1];
				if (arr[i1] > count)
					arr[i1] = count + 1;
				int num1 = arr[i1];
				String s = "" + i1;
				String ns = "";
				for (int i2 = 0; i2 < s.length(); i2++)
					ns += s.charAt(s.length() - i2 - 1);
				int x = Integer.parseInt(ns);
				if (x <= n && x > i1 && arr[x] > arr[i1])
					arr[x] = num1 + 1;
			}
			int res = arr[n];
			String s = "Case #" + i + ": " + res;
			System.out.println(s);
			out.println(s);
		}
		in.close();
		out.close();
	}
}
