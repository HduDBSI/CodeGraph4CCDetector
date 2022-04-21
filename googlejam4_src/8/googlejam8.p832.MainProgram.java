package googlejam8.p832;
import java.io.*;
import java.util.*;

public class MainProgram {

	public static void main(String args[]) throws FileNotFoundException {
		// System.out.println("yokoso!");

		// String inFile = "input.in";
		// String outFile = "output.out";

		// String inFile = "B-small-practice.in";
		// String outFile = "B-small-practice.out";
		// String inFile = "A-large-practice.in";
		// String outFile = "A-large-practice.out";

//		String inFile = "A-small-attempt2.in";
//		String outFile = "A-small-attempt2.out";
		 String inFile = "A-large.in";
		 String outFile = "A-large.out";

		File file = new File(inFile);
		Scanner scan = new Scanner(file);
		PrintWriter writer = new PrintWriter(outFile);

		int t = scan.nextInt();

		for (int i = 0; i < t; i++) {
			// TODO
			int n = scan.nextInt();
			int[][] p = new int[2][n];
			int s = 0;
			for (int u = 0; u < n; u++) {
				p[0][u] = u;
				p[1][u] = scan.nextInt();
				s += p[1][u];
			}

			for (int u = 0; u < n - 1; u++) {
				int minIndex = u;
				for (int v = u + 1; v < n; v++)
					if (p[1][v] < p[1][minIndex])
						minIndex = v;
				if (minIndex != u) {
					int tmp = p[1][u];
					p[1][u] = p[1][minIndex];
					p[1][minIndex] = tmp;

					tmp = p[0][u];
					p[0][u] = p[0][minIndex];
					p[0][minIndex] = tmp;
				}
			}

			int u = p[1].length - 2;
			String str = "";
			while (u >= 0) {
				while (p[1][n - 1] > p[1][u]) {
					for (int v = n - 1; v > u; v--) {
						char ch = (char) ('A' + p[0][v]);
						str = str + ch + " ";
						p[1][v]--;
						s--;
					}
				}
				u = u - 1;
			}

			/*
			 * while (p[1][0] > 0) { for (int v = n - 1; v >= 0; v--) { if (s ==
			 * 2) { char ch1 = (char) ('A' + p[0][0]); char ch2 = (char) ('A' +
			 * p[0][1]); str = str + ch1 + ch2;
			 * 
			 * p[1][0]--; p[1][1]--; break; } char ch = (char) ('A' + p[0][v]);
			 * str = str + ch + " "; p[1][v]--; s--; } }
			 */

			if (n > 2) {
				while (p[1][2] > 0) {
					for (int v = n - 1; v >= 2; v--) {
						char ch = (char) ('A' + p[0][v]);
						str = str + ch + " ";
						p[1][v]--;
						s--;
					}
				}
			}

			while (p[1][0] > 0) {
				char ch1 = (char) ('A' + p[0][0]);
				char ch2 = (char) ('A' + p[0][1]);
				str = str + ch1 + ch2 + " ";
				p[1][0]--;
				p[1][1]--;
			}

			///////
			writer.printf("Case #%d: %s", i + 1, str);
			writer.println();

		}

		writer.close();
	}

}
