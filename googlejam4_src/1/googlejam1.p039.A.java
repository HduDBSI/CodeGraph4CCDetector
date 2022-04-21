package googlejam1.p039;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException,
			FileNotFoundException {
		String file = "A-large";

		Scanner scan = new Scanner(new BufferedReader(new FileReader(file
				+ ".in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file
				+ ".out")));

		int T = Integer.parseInt(scan.nextLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(scan.nextLine());
			String[] info = scan.nextLine().split(" ");
			long[] num = new long[N];
			for (int i = 0; i < N; i++)
				num[i] = Long.parseLong(info[i]);

			long y = 0;
			for (int i = 1; i < N; i++)
				if (num[i] < num[i - 1])
					y += num[i - 1] - num[i];

			long z = 0;
			long max = 0;
			for (int i = 1; i < N; i++)
				if (num[i] <= num[i - 1])
					max = Math.max(max, num[i - 1] - num[i]);
			for (int i = 1; i < N; i++)
				z += Math.min(num[i - 1], max);

			pw.println("Case #" + t + ": " + y + " " + z);
		}

		scan.close();
		pw.close();
	}

}
