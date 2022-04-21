package googlejam1.p030;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("A2.in"));
		PrintWriter out = new PrintWriter("A2.out");
		int tc = in.nextInt();
		for (int cc = 1; cc <= tc; cc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			int r0 = 0;
			int r1 = 0;
			int max = 0;
			for (int i = 0; i < n - 1; i++) {
				if (a[i] > a[i + 1]) {
					r0 += a[i] - a[i + 1];
					max = Math.max(max, a[i] - a[i + 1]);
				}
			}
			for (int i = 0; i < n - 1; i++)
				r1 += Math.min(max, a[i]);
			System.out.printf("Case #%d: %d %d\n", cc, r0, r1);
			out.printf("Case #%d: %d %d\n", cc, r0, r1);
		}
		out.close();
	}
}
