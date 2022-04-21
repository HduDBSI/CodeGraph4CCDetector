package googlejam6.p068;
import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);

		Scanner in = new Scanner(new File("problem.in"));
		PrintStream out = new PrintStream(new File("problem.out"));

		int T = in.nextInt();

		for (int test = 1; test <= T; test++) {
			int[] count = new int[2501];
			int n = in.nextInt();
			for (int i = 0; i < (2 * n - 1) * n; i++) {
				int a = in.nextInt();
				count[a]++;
			}
			int[] res = new int[n];
			int k = 0;
			for (int i = 1; i <= 2500; i++) {
				if (count[i] % 2 == 1) {
					res[k] = i;
					k++;
				}
			}

			out.printf("Case #%d:", test);
			for (int i = 0; i < n; i++) {
				out.printf(" %d", res[i]);
			}
			out.println();
		}

	}
}
