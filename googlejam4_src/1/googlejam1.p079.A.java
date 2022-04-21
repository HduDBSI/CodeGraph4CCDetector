package googlejam1.p079;
import java.io.PrintStream;
import java.util.Scanner;


public class A {

	private static PrintStream out = System.out;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTests = in.nextInt();
		for (int test = 1; test <= numTests; ++test) {
			// read input
			int n = in.nextInt();
			int[] cnts = new int[n];
			for (int i = 0; i < n; ++i)
				cnts[i] = in.nextInt();
			// solve first problem
			long ans1 = 0;
			for (int i = 1; i < n; ++i)
				ans1 += Math.max(0, cnts[i - 1] - cnts[i]);
			// solve second
			int diff = 0;
			for (int i = 1; i < n; ++i)
				diff = Math.max(diff, cnts[i - 1] - cnts[i]);
			long ans2 = 0;
			for (int i = 0; i + 1 < n; ++i)
				ans2 += Math.min(diff, cnts[i]);
			// output answer
			out.println("Case #" + test + ": " + ans1 + " " + ans2);
		}
	}

}
