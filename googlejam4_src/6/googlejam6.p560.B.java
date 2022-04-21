package googlejam6.p560;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("b.in"));
		PrintWriter writer = new PrintWriter(new File("b.out"));

		int t = scanner.nextInt();
		for (int tt = 1; tt <= t; ++tt) {
			writer.print("Case #" + tt + ":");

			int n = scanner.nextInt();
			int m = 2 * n - 1;
			boolean flag[] = new boolean[2501];
			Arrays.fill(flag, false);
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					int x = scanner.nextInt();
					flag[x] = !flag[x];
				}
			}

			ArrayList<Integer> result = new ArrayList<Integer>();
			for (int i = 1; i <= 2500; ++i) {
				if (flag[i]) {
					result.add(i);
				}
			}

			Collections.sort(result);

			for (int i : result) {
				writer.print(" " + i);
			}
			writer.println();
		}

		scanner.close();
		writer.close();
	}

}
