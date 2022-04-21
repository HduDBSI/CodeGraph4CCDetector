package googlejam1.p450;
import java.util.Scanner;


public class Main_Round1A_2015_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int casei = 1; casei <= t; casei++) {
			int n = sc.nextInt();
			int[] m = new int[n];
			m[0] = sc.nextInt();

			int sum = 0;
			int max = 0;
			for (int i = 1; i < n; i++) {
				m[i] = sc.nextInt();
				int diff = Math.max(0, m[i - 1] - m[i]);
				max = Math.max(max, diff);
				sum += diff;
			}

			int ret = 0;
			for (int i = 1; i < n; i++) {
				ret += Math.min(m[i- 1], max);
			}

			System.out.printf("Case #%d: %d %d\n", casei, sum, ret);
		}

		sc.close();
	}
}
