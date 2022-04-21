package googlejam1.p380;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MushroomMonster {
	static String PATH = "data/gcj2015/1a/", PROBLEM = "A", SIZE = "large",
			ATTEMPT = "0";

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		String filename = PATH + PROBLEM + "-" + SIZE;
		if (SIZE.equals("small"))
			filename += "-attempt" + ATTEMPT;
		Scanner sc = new Scanner(new File(filename + ".in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + PROBLEM
				+ "-" + SIZE + "-attempt" + ATTEMPT + ".out"));
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] m = new int[N];
			for (int n = 0; n < N; n++) {
				m[n] = sc.nextInt();
			}
			// Strategy 1
			long s1 = 0;
			for (int n = 0; n < N - 1; n++) {
				if (m[n] > m[n + 1])
					s1 += m[n] - m[n + 1];
			}
			// Strategy 2
			// First find the max decrease
			int maxDiff = 0;
			for (int n = 0; n < N - 1; n++) {
				if (m[n] - m[n + 1] > maxDiff)
					maxDiff = m[n] - m[n + 1];
			}
			// Then try eating
			long s2 = 0;
			for (int n = 0; n < N - 1; n++) {
				if (m[n] > maxDiff) {
					// eat only max
					s2 += maxDiff;
				} else {
					// eat the remaining
					s2 += m[n];
				}
			}
			bw.write("Case #" + (t + 1) + ": " + s1 + " " + s2);
			bw.newLine();
		}
		sc.close();
		bw.close();
	}
}
