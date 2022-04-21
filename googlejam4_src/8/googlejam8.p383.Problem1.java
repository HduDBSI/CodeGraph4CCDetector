package googlejam8.p383;
import java.util.*;
import java.io.*;

public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = in.nextInt();
			int p[] = new int[n];
			int total = 0;
			for (int i = 0; i < n; i++) {
				p[i] = in.nextInt();
				total += p[i];
			}
			StringBuilder sb = new StringBuilder();
			while (total > 0) {
				sb.append(" ");
				int max = 0;
				for (int i1 = 1; i1 < p.length; i1++) {
					if (p[i1] > p[max]) {
						max = i1;
					}
				}
				int i = max;
				total -= 1;
				p[i] -= 1;
				sb.append((char) ('A' + i));
				for (int j = 0; j < n; j++) {
					if (p[j] * 1.0 / total > 0.5) {
						total -= 1;
						p[j] -= 1;
						sb.append((char)('A' + j));
					}
				}
			}
			System.out.println("Case #" + testCase + ":" + sb.toString());
		}
		in.close();
	}
}