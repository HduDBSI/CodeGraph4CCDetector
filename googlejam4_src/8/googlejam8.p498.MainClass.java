package googlejam8.p498;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {

		File fin = new File("input.in");
		File fout = new File("output.out");

		Scanner in = new Scanner(fin);
		PrintWriter out = new PrintWriter(fout);

		int T = in.nextInt();
		int n;
		ArrayList<Integer> senators = new ArrayList<Integer>();
		int sum;
		String sol = "";

		for (int cT = 1; cT <= T; cT++) {
			senators.clear();
			sol = "";
			n = in.nextInt();
			for (int i = 0; i < n; i++)
				senators.add(in.nextInt());
			sum = 0;
			for (int i = 0; i < n; i++)
				sum += senators.get(i);

			while (sum-- > 2) {
				int max = 0, index = -1, index2 = -1;
				boolean match3 = false;
				for (int i = 0; i < n; i++)
					if (senators.get(i) > max) {
						index = i;
						max = senators.get(i);
						index2 = -1;
					} else if (senators.get(i) == max) {
						if (index2 == -1)
							index2 = i;
						else
							match3 = true;
					}
				if (index2 == -1 || match3) {
					senators.set(index, max - 1);
					sol += " " + (char) (index + 'A');
				} else {
					senators.set(index, max - 1);
					senators.set(index2, max - 1);
					sol += " " + (char) (index + 'A') + (char) (index2 + 'A');
					sum--;
				}
				for (int i = 0; i < n; i++)
					if (senators.get(i) > sum / 2)
						System.out.println("flawed");
			}
			sol += " ";
			for (int i = 0; i < n; i++)
				if (senators.get(i) > 0)
					sol += (char) (i + 'A');
			out.println("Case #" + cT + ":" + sol);
		}
		in.close();
		out.close();
	}

}
