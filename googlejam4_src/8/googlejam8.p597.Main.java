package googlejam8.p597;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);

		Scanner in;
		try {
			in = new Scanner(new File("input.txt"));
		} catch (Exception e) {
			in = new Scanner(System.in);
		}

		PrintWriter out;
		try {
			out = new PrintWriter("output.txt");
		} catch (Exception e) {
			out = new PrintWriter(System.out);
		}

		int t = in.nextInt();

		for (int x = 1; x <= t; ++x) {

			String res = "Case #" + x + ": ";

			int n = in.nextInt();

			int[] ns = new int[n];

			int total = 0;

			for (int i = 0; i < n; ++i) {
				int p = in.nextInt();
				total += p;
				ns[i] = p;
			}

			//System.out.print(Arrays.toString(ns));

			boolean even = false;
			while (!even) {
				int max = ns[0];
				int maxPos = 0;
				int min = ns[0];
				int minPos = 0;
				for (int i = 1; i < n; ++i) {
					if (ns[i] > max) {
						max = ns[i];
						maxPos = i;
					}
					else if (ns[i] < min) {
						min = ns[i];
						minPos = i;
					}
				}
				if (max != min) {
					res += ((char) (65 + maxPos)) + " ";
					--ns[maxPos];
					--total;
				}
				else {
					even = true;
				}
			}

			int totalColumns = 0;

			for (int i = 0; i < n; ++i) {
				if (ns[i] > 0) {
					++totalColumns;
				}
			}
			
			System.out.println(totalColumns);

			for (int i = 0; i < n; ++i) {
				if (totalColumns > 2) {
					while (ns[i] > 0) {
						res += ((char) (65 + i)) + " ";
						--ns[i];
						--total;
					}
					--totalColumns;
				}
				else break;
			}

			int a = -1;
			int b = -1;
			int times = 0;

			for (int i = 0; i < n; ++i) {
				if (ns[i] > 0) {
					if (a == -1) {
						a = i;
						times = ns[i];
					}
					else {
						b = i;
					}
				}
			}

			for (int i = 0; i < times; ++i) {
				res += ((char) (65 + a)) + "" + ((char) (65 + b)) + " ";
			}

			res += "\n";

			System.out.print(res);
			out.print(res);
		}
		out.close();
	}
}