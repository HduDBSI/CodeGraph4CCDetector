package googlejam1.p821;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class basic {

	public static void main(String[] args) throws IOException {

		FileInputStream in = new FileInputStream(
				"D:/works/java/G1A/bin/A-large (1).in");
		Scanner s = new Scanner(in);
		PrintWriter out = new PrintWriter(new FileWriter(
				"D:/works/java/G1A/bin/3large.out"));

		int n = Integer.parseInt(s.next());
		for (int i = 1; i <= n; i++) {
			int t = s.nextInt();
			int a[] = new int[t];
			int sum = 0, sum2 = 0, fsum = 0, r = 0;
			for (int j = 0; j < a.length; j++) {
				a[j] = s.nextInt();
				if (j > 0 && a[j] < a[j - 1])
					sum += a[j - 1] - a[j];
				if (j > 0 && r < a[j - 1] - a[j]&& a[j] < a[j - 1])
					r = a[j - 1] - a[j];
			}
			for (int j = 0; j < a.length -1; j++) {
				sum2 += a[j];
				if (a[j] >= r) {
					fsum += r;
					sum2 -= r;
				} else {
					fsum += a[j];
					sum2 = 0;
				}
			}
			out.println("Case #" + i + ": " + sum + " " + fsum);
			System.out.println("Case #" + i + ": " + sum + " " + fsum);
		}
		out.close();
	}

}
