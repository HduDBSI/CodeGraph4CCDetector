package googlejam1.p134;
import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);

		Scanner in = new Scanner(new File("problem.in"));
		PrintStream out = new PrintStream(new File("problem.out"));

		int T = in.nextInt();
		for (int test = 1; test <= T; test++) {
			int n = in.nextInt();
			int[] m = new int[n];

			for (int i = 0; i < n; i++) {
				m[i] = in.nextInt();
			}

			int min1 = 0;
			for (int i = 1; i < n; i++) {
				if (m[i] < m[i - 1]) {
					min1 += m[i - 1] - m[i];
				}
			}

			int min2 = 0;
			
			int d = 0;
			for (int i = 1; i < n; i++) {
				if (m[i] < m[i - 1]) {
					if (m[i-1] - m[i] > d) {
						d = m[i-1] - m[i];
					}
				}
			}
			
			if (d > 0) {
				for (int i = 1; i < n; i++) {
					min2 += Math.min(m[i-1], d);
				}				
			}

			out.println("Case #" + test + ": " + min1 + " " + min2);
		}
	}
}
