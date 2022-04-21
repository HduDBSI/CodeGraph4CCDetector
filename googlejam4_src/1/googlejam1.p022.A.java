package googlejam1.p022;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int ntests = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= ntests; tc++) {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int firstMin = 0;
			int maxDiff = 0;
			for (int i = 1; i < n; i++) {
				int diff = -arr[i] + arr[i - 1];
				if (diff > 0) {
					firstMin += diff;
				}

				maxDiff = Math.max(maxDiff, diff);
			}

			int secondMin = 0;
			for (int i = 1; i < n; i++) {
				secondMin += Math.min(maxDiff, arr[i - 1]);
			}

			System.out.println("Case #" + tc + ": " + firstMin + " " + secondMin);
		}
	}
}
