package googlejam1.p025;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("A-practice.in"));
//		 Scanner sc = new Scanner(new File("A-small-attempt0.in"));
		 Scanner sc = new Scanner(new File("A-large.in"));
		sc.useLocale(Locale.US);
		int cases = sc.nextInt();

		for (int i = 1; i <= cases; i++) {
			System.out.format(Locale.US, "Case #%d: ", i);
			int N = sc.nextInt();
			int[] m = new int[N];
			int maxDiff = 0;
			int eaten1 = 0;
			for (int i1 = 0; i1 < m.length; i1++) {
				m[i1] = sc.nextInt();
				if (i1 > 0) {
					maxDiff = Math.max(maxDiff, m[i1 - 1] - m[i1]);
					if (m[i1 - 1] - m[i1] > 0) {
						eaten1 += m[i1 - 1] - m[i1];
					}
				}
			}
			int eaten2 = 0;
			for (int i2 = 0; i2 < m.length - 1; i2++) {
				eaten2 += Math.min(maxDiff, m[i2]);
			}
			System.out.println(eaten1 + " " + eaten2);
		}
		sc.close();
	}
}
