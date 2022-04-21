package googlejam1.p124;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoA {
	public static void main(final String[] args) {

		final String base = "/home/jean/gcj2015/1a/ExoA/";
		final String input = base + "b1.in";
		final String output = base + "b1.out";

		try {
			final Scanner sc = new Scanner(new FileReader(input));
			final PrintWriter pw = new PrintWriter(output);

			final int n = sc.nextInt();
			sc.nextLine();
			for (int c = 0; c < n; c++) {
				System.out.println("Test case " + (c + 1) + "...");
				pw.print("Case #" + (c + 1) + ": ");
				final int N = sc.nextInt();
				int ns[] = new int[N];
				int t = 0;
				int m = 0;
				int t2 = 0;
				for (int i = 0; i < ns.length; i++) {
					ns[i] = sc.nextInt();
					if (i > 0 && ns[i - 1] > ns[i]) {
						t -= ns[i] - ns[i - 1];
					}
					if (i > 0 && ns[i - 1] - ns[i] > m) {
						m = ns[i - 1] - ns[i];
					}
				}
				for (int i = 1; i < ns.length; i++) {
					if (ns[i] == 0) {
						t2 += ns[i - 1];
					} else {
						t2 += Math.min(ns[i - 1], m);
					}
				}
				pw.print(t);
				pw.print(" ");
				pw.print(t2);
				pw.println();
			}
			pw.println();
			pw.flush();
			pw.close();
			sc.close();
		} catch (final FileNotFoundException ex) {
			Logger.getLogger(ExoA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
