package googlejam8.p054;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("AL.in"));
		int tc = in.nextInt();
		PrintWriter out = new PrintWriter("AL.out");
		for (int cc = 1; cc <= tc; cc++) {
			int n = in.nextInt();
			int[] f = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				f[i] = in.nextInt();
				sum += f[i];
			}
			StringBuilder result = new StringBuilder();
			while (sum > 0) {
				int max = 0;
				TreeSet<Integer> nz = new TreeSet<>();
				for (int i = 0; i < n; i++) {
					if (f[i] > f[max]) {
						max = i;
					}
					if (f[i] > 0) {
						nz.add(i);
					}
				}
				System.out.println(Arrays.toString(f));
				if (f[max] * 2 == sum && nz.size() == 2) {
					int a = nz.pollFirst();
					int b = nz.pollFirst();
					f[a]--;
					f[b]--;
					result.append((char) ('A' + a) + "" + (char) ('A' + b) + " ");
					sum -= 2;
				} else {
					f[max]--;
					result.append((char) ('A' + max) + " ");
					sum -= 1;
				}
			}
			System.out.printf("Case #%d: %s\n", cc, result.toString().trim());
			out.printf("Case #%d: %s\n", cc, result.toString().trim());
		}
		out.close();
	}
}
