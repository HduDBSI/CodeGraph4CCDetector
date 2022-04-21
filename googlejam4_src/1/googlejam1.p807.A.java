package googlejam1.p807;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {

		try {
			System.setOut(new PrintStream("src/output.out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner in = null;
		try {
			in = new Scanner(new File("src/A-large (2).in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] tab = new int[n];
			int s = 0;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < tab.length; j++) {
				tab[j] = in.nextInt();
				if (j != 0) {
					if ((tab[j] - tab[j - 1]) < 0) {
						s += -(tab[j] - tab[j - 1]);
						if ((tab[j - 1] - tab[j]) > max) {
							max = -(tab[j] - tab[j - 1]);
						}
					}
				}
			}
			int k = 0;
			int r = tab[0];
			if (max < 0)
				max = 0;
			for (int j = 0; j < tab.length; j++) {
				if (j != tab.length - 1) {
					if (tab[j] >= max) {
						k += max;
					} else {
						k += tab[j];
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + s + " " + k);
		}

	}

}
