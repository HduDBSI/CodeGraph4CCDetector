package googlejam3.p311;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class s {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(
				"D:/works/java/G1A/bin/A-large (2).in");
		Scanner s = new Scanner(in);
		PrintWriter out = new PrintWriter(new FileWriter(
				"D:/works/java/G1A/bin/Abig.out"));

		int n = Integer.parseInt(s.next());
		for (int i = 1; i <= n; i++) {
			int r = s.nextInt(), c = s.nextInt(), w = s.nextInt(), j = -1, count = 0;
			int a[] = new int[c];
			if (w == 1) {
				System.out.println("Case #" + i + ": " + c * r);
				out.println("Case #" + i + ": " + c * r);

			} else {
				j += w;
				while (j < c) {
					a[j] = 1;
					System.out.print(j + " ");
					j += w;
					count++;
				}j-=w;
				count*=r;
				if (c - j - 1 > 0) {
					count++;System.out.print(1);
				}
				System.out.println(w - 1);
				count += w - 1;
				System.out.println("Case #" + i + ": " + count);
				out.println("Case #" + i + ": " + count);

			}
		}
		out.close();

	}
}
