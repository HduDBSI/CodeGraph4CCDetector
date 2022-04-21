package googlejam1.p560;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MushroomMonster {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("src/in.txt"));
		PrintWriter out = new PrintWriter("out.txt");

		int t = in.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = in.nextInt();

			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = in.nextInt();
			}

			int y = 0;
			int dif = 0;
			for (int i = 1; i < n; i++) {
				if (m[i] < m[i - 1]) {
					y += Math.abs(m[i] - m[i - 1]);
					if (Math.abs(m[i] - m[i-1]) > dif) {
						dif = Math.abs(m[i] - m[i-1]);
					}
				}
			}

			double rate = (double) dif / (double) 10;
			
			int z = 0;
			for (int i = 0; i < n-1; i++) {
				z += Math.min(m[i], rate * 10);
			}

			out.println("Case #" + tc + ": " + y + " " + z);
		}

		in.close();
		out.close();
	}
}
