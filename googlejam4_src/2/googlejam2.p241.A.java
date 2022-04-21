package googlejam2.p241;
import java.util.*;

public class A {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int T = sc.nextInt();
			for (int i = 1; i <= T; ++i) {
				int ans = -1;
				int N = sc.nextInt();
				int[] memo = new int[N+1];
				for (int j = 1; j <= N; ++j) {
					memo[j] = Integer.MAX_VALUE;
				}
				for (int j = 1; j <= N; ++j) {
					memo[j] = Math.min(memo[j], memo[j-1] + 1);
					int k = Integer.parseInt(new StringBuilder(String.valueOf(j)).reverse().toString());

					if (j != k && k > j && k <= N) {
						memo[k] = memo[j] + 1;
						// System.out.println(k + ":" + memo[k]);
					}
					// System.out.println(j + ":" + memo[j]);
				}
				ans = memo[N];
				System.out.printf("Case #%d: %d\n", i, ans);
			}
		}
	}
}