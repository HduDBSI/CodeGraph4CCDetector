package googlejam1.p843;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mushrooms {

	public static void main(String[] args) throws Exception {
		Mushrooms r = new Mushrooms();
		Scanner sc = new Scanner(new BufferedReader(new FileReader(
				"A-small-attempt0.in")));
		PrintWriter pw = new PrintWriter(new FileWriter("A-small-attempt0.out"));
		
		int nc = sc.nextInt();
		for (int tc = 1; tc <= nc; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int ans0 = 0;
			int ans1 = 0;
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				if (i > 0 && a[i - 1] > a[i])
					ans0 += a[i - 1] - a[i];
			}
			if (ans0 > 0) {
				int lo = 1;
				int hi = 10000;
				while (lo < hi) {
					int rate = (lo + hi) / 2;
					boolean ok = true;
					for (int i = 1; i < n; i++) {
						if (a[i - 1] - rate > a[i]) {
							ok = false;
							break;
						}
					}
					if (ok)
						hi = rate;
					else
						lo = rate + 1;
				}
				for (int i = 1; i < n; i++) {
					if (lo <= a[i - 1]) {
						ans1 += lo;
					} else {
						ans1 += a[i - 1];
					}
				}
			}
			pw.printf("Case #%d: %d %d\n", tc, ans0, ans1);
		}
		sc.close();
		pw.close();
	}

}
