package googlejam8.p500;
import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class A {

//			final static String FILE_NAME = "A-test";
//	final static String FILE_NAME = "A-small-attempt2";
	final static String FILE_NAME = "A-large";

	private Scanner in;
	private PrintWriter out;

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		A r = new A();
		r.in = new Scanner(new File(A.FILE_NAME + ".in"));
		r.out = new PrintWriter(new File(A.FILE_NAME + ".out"));
		int tcn = r.in.nextInt();
		for (int tc = 1; tc <= tcn; tc++) {
			int n = r.in.nextInt();
			int[] s = new int[n];
			int total = 0;
			for (int i = 0; i < n; i++) {
				s[i] = r.in.nextInt();
				total += s[i];
			}
			
			String res = "";
			while (total > 0) {
				res += ' ';
				int a = 0;
				for (int i = 1; i < n; i++) {
					if (s[a] < s[i]) {
						a = i;
					}
				}
				s[a]--;
				total--;
				res += (char) ('A' + a);
			
				if (total == 0) {
					break;
				}
			
				boolean ok = true;
				int b = 0;
				for (int i = 1; i < n; i++) {
					if (s[b] < s[i]) {
						b = i;
					}
				}
				s[b]--;
				total--;
			
				for (int i = 0; i < n; i++) {
					if (s[i] * 2 > total) {
						ok = false;
						break;
					}
				}
			
				if (ok) {
					res += (char) ('A' + b);
				} else {
					s[b]++;
					total++;
				}
			}
			res.trim();
			r.out.format("Case #%d: %s\n", tc, res);
			System.out.format("Case #%d: %s\n", tc, res);
		}
		r.out.close();
	}
}
