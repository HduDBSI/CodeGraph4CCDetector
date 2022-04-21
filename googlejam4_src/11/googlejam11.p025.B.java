package googlejam11.p025;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("BL.in"));
		PrintWriter out = new PrintWriter("BL.out");
		int tc = in.nextInt();
		for (int cc = 1; cc <= tc; cc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			double[] p = new double[n];
			for (int i = 0; i < n; i++) {
				p[i] = in.nextDouble();
			}
			Arrays.sort(p);
//			double result = 0;
//			for (int i = 0; i < 1 << n; i++) {
//				if (Integer.bitCount(i) != k)
//					continue;
//				double[] dp = new double[k + 1];
//				dp[0] = 1;
//				for (int j = 0; j < n; j++) {
//					if ((i & 1 << j) != 0) {
//						for (int m = k; m >= 0; m--) {
//							dp[m] = dp[m] * p[j] + (m == 0 ? 0 : dp[m - 1] * (1 - p[j]));
//						}
//					}
//				}
//				double sum = 0;
//				for (int x = 0; x <= k; x++) {
//					sum += dp[x];
//				}
//				if (Math.abs(sum - 1) > 1e-9) {
//					throw new Exception();
//				}
//				result = Math.max(result, dp[k / 2]);
//			}
			double result2 = 0;
			for (int i = 0; i <= k; i++) {
				double[] dp = new double[k + 1];
				dp[0] = 1;
				for (int j = 0; j < i; j++) {
					for (int m = k; m >= 0; m--) {
						dp[m] = dp[m] * p[j] + (m == 0 ? 0 : dp[m - 1] * (1 - p[j]));
					}
				}
				for (int j = n - (k - i); j < n; j++) {
					for (int m = k; m >= 0; m--) {
						dp[m] = dp[m] * p[j] + (m == 0 ? 0 : dp[m - 1] * (1 - p[j]));
					}
				}
				result2 = Math.max(result2, dp[k / 2]);
			}
//			if (Math.abs(result2 - result) > 1e-9) {
//				throw new Exception();
//			}
			System.out.printf("Case #%d: %.8f\n", cc, result2);
			out.printf("Case #%d: %.8f\n", cc, result2);
		}
		out.close();
	}
}
