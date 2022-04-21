package googlejam9.p044;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("BL.in"));
		PrintWriter out = new PrintWriter("BL.out");
		long[] counts = new long[55];
		counts[0] = 1;
		for (int i = 1; i < 55; i++) {
			for (int j = 0; j < i; j++) {
				counts[i] += counts[j]; // 2^(i-1)
			}
		}
		int tc = in.nextInt();
		for (int cc = 1; cc <= tc; cc++) {
			int b = in.nextInt();
			long t = in.nextLong();
			char[][] result = new char[b][b];
			for (char[] a : result)
				Arrays.fill(a, '0');
			for (int i = b - 1; i > 0; i--) {
				for (int j = i + 1; j < b; j++) {
					result[i][j] = '1';
				}
			}
			if (t > counts[b - 1]) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", cc);
				out.printf("Case #%d: IMPOSSIBLE\n", cc);

			} else {
				System.out.printf("Case #%d: POSSIBLE\n", cc);
				out.printf("Case #%d: POSSIBLE\n", cc);

				if (t == counts[b - 1]) {
					for (int i = 1; i < b; i++) {
						result[0][i] = '1';
					}
				} else {
					while (t > 0) {
						long bit = t & -t;
						int idx = 0;
						while (1L << idx < bit)
							idx++;
						if (idx >= b) {
							throw new Exception("That's how you know you ....ed up");
						}
						result[0][b - 1 - (idx + 1)] = '1';
						t -= bit;
					}
				}
				for (int i = 0; i < b; i++) {
					System.out.printf(new String(result[i]) + "\n");
					out.printf(new String(result[i]) + "\n");

				}
			}
		}
		out.close();
	}
}
