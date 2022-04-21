package googlejam4.p161;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("A-large (4).in"));
		PrintWriter out = new PrintWriter("AL.out");
		int tc = in.nextInt();
		int[] di = new int[128];
		int[] dj = new int[128];

		di['v'] = 1;
		dj['v'] = 0;

		di['>'] = 0;
		dj['>'] = 1;

		di['^'] = -1;
		dj['^'] = 0;

		di['<'] = 0;
		dj['<'] = -1;

		for (int cc = 1; cc <= tc; cc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = in.next().toCharArray();

			int[] rcount = new int[n];
			int[] ccount = new int[m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != '.') {
						rcount[i]++;
						ccount[j]++;
					}
				}
			}
			int count = 0;
			boolean impossible = false;
			for (int i = 0; i < n && !impossible; i++) {
				for (int j = 0; j < m && !impossible; j++) {
					if (map[i][j] != '.') {
						int ci = i + di[map[i][j]];
						int cj = j + dj[map[i][j]];
						boolean found = false;
						while (ci >= 0 && ci < n && cj >= 0 && cj < m) {
							if (map[ci][cj] != '.')
								found = true;
							ci += di[map[i][j]];
							cj += dj[map[i][j]];
						}
						if (!found) {
							count++;
							if (rcount[i] == 1 && ccount[j] == 1) {
								impossible = true;
							}
						}
					}
				}
			}
			if (impossible) {
				System.out.printf("Case #%d: %s\n", cc, "IMPOSSIBLE");
				out.printf("Case #%d: %s\n", cc, "IMPOSSIBLE");

			} else {
				System.out.printf("Case #%d: %d\n", cc, count);
				out.printf("Case #%d: %d\n", cc, count);
			}
		}
		out.close();
	}
}
