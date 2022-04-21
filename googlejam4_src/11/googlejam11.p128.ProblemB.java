package googlejam11.p128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		ProblemB obj = new ProblemB();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				obj.getClass().getResourceAsStream(fileName)));
		int sfx = fileName.indexOf('.');
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("./src/" + fileName.substring(0, sfx) + ".out"));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
		
			double[] P = new double[N];
			str = br.readLine();
			token = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				P[j] = Double.parseDouble(token.nextToken());
			}
		
			Arrays.sort(P);
			double ans = 0.0;
			for (int s = 0; s <= N - K; s++) {
				for (int e = 0; e <= N - K - s; e++) {
					for (int a = 0; a <= K; a++) {
						double[][] dp = new double[2][K + 1];
						dp[1][0] = 1.0;
						for (int k = 0; k < a; k++) {
							double p = P[k + s];
							for (int j = 0; j <= k + 1; j++) {
								dp[k % 2][j] = dp[(k + 1) % 2][j] * (1 - p);
								if (j != 0) {
									dp[k % 2][j] += dp[(k + 1) % 2][j - 1] * p;
								}
							}
						}
						for (int k = a; k < K; k++) {
							double p = P[N - (k - a) - 1 - e];
							for (int j = 0; j <= k + 1; j++) {
								dp[k % 2][j] = dp[(k + 1) % 2][j] * (1 - p);
								if (j != 0) {
									dp[k % 2][j] += dp[(k + 1) % 2][j - 1] * p;
								}
							}
						}
						ans = Math.max(ans, dp[1][K / 2]);
					}
				}
			}
		
			DecimalFormat ft = new DecimalFormat("0.000000000");
			bw.write("Case #" + (i + 1) + ": " + ft.format(ans));
			bw.write("\r\n");
		}
		bw.close();
		br.close();
	}
}
