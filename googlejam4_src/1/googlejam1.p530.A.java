package googlejam1.p530;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {
	private static final String FILE_NAME = "A-large";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(FILE_NAME + ".in"));
		PrintStream out = new PrintStream(new File(FILE_NAME + ".out"));
		int loopNum = in.nextInt();

		for (int caseNum = 1; caseNum <= loopNum; caseNum++) {
			out.print("Case #" + caseNum + ": ");
			int n = in.nextInt();
			int method1 = 0, method2 = 0;
			int max = 0;
			int[] arr = new int[n];
			arr[0] = in.nextInt();
			for (int i = 1; i < n; ++i) {
				arr[i] = in.nextInt();
				int diff = Math.max(0, arr[i - 1] - arr[i]);
				method1 += diff;
				max = Math.max(max, diff);
			}
			for (int i = 0; i < n - 1; ++i) {
				method2 += Math.min(arr[i], max);
			}
			out.print(method1 + " " + method2);
			out.println();
		}

		in.close();
		out.close();
	}
}
