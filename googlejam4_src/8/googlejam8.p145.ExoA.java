package googlejam8.p145;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoA {
	public static void main(final String[] args) {

		final String base = "/home/jfortin/workspace-gcj/Codejam2016/r1c/ExoA/";
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
				int N = sc.nextInt();
				int nn[] = new int[N];
				for (int i = 0; i < N; i++) {
					nn[i] = sc.nextInt();
				}
				
				while (true) {
					int max = Integer.MIN_VALUE;
					int maxi = -1;
					int maxi2 = -1;
					int count = 0;
					for (int i = 0; i < nn.length; i++) {
						if (nn[i] > max) {
							maxi = i;
							max = nn[i];
							maxi2 = -1;
							count = 1;
						} else if (nn[i] == max) {
							maxi2 = i;
							count++;
						}
					}
				
					if (max == 0) {
						break;
					}
				
					pw.print(Character.valueOf((char) ('A' + maxi)));
					nn[maxi]--;
					if (maxi2 != -1 && count == 2) {
						pw.print(Character.valueOf((char) ('A' + maxi2)));
						nn[maxi2]--;
					}
					pw.print(' ');
				}
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
