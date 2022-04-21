package googlejam11.p060;


import java.util.*;
import java.io.*;

public class Round_2_B {

	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;

	static int T, N, K;

	static double[] prob;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		br = new BufferedReader(new FileReader("in.txt"));
		out = new PrintWriter(new FileWriter("out.txt"));

		T = Integer.parseInt(next());

		for (int t = 1; t <= T; t++) {
			System.out.println(t);
			N = Integer.parseInt(next());
			K = Integer.parseInt(next());
			prob = new double[N];

			for (int i = 0; i < N; i++)
				prob[i] = Double.parseDouble(next());

			double ans = 0;

			for (int i = 0; i < 1 << N; i++) {
				int sz = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) > 0)
						sz++;
				}
				if (sz == K) {
					double total = 0;
					for (int j = 0; j < 1 << N; j++) {
						if ((i & j) == j) {
							int sz2 = 0;
							double currProb = 1;
							for (int k = 0; k < N; k++) {
								if ((j & 1 << k) > 0) {
									sz2++;
									currProb *= prob[k];
								} else if ((i & 1 << k) > 0) {
									currProb *= (1 - prob[k]);
								}
								
							}
							if (sz2 == K / 2)
								total += currProb;
						}
					}
					ans = Math.max(ans, total);
				}
			}
			out.printf("Case #%d: %f\n", t, ans);
		}

		out.close();
	}

	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}

