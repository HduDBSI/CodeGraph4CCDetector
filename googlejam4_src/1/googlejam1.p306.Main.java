package googlejam1.p306;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] m = new int[N];
			for (int i = 0; i < m.length; i++) {
				m[i] = sc.nextInt();
			}

			int first = 0;
			for (int i = 1; i < m.length; i++) {
				if (m[i] <= m[i - 1]) {
					first += m[i - 1] - m[i];
				}
			}

			int max = 0;
			for (int i = 1; i < m.length; i++) {
				max = Math.max(max, m[i - 1] - m[i]);
			}
			int second = 0;
			for (int i = 0; i < m.length - 1; i++) {
				second += Math.min(max, m[i]);
			}

			System.out.println("Case #" + (t + 1) + ": " + first + " " + second);

		}
	}
}