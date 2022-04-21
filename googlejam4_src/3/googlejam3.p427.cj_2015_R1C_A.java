package googlejam3.p427;

import java.util.Scanner;

public class cj_2015_R1C_A {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		for (int i = 1; i <= n; i++) {
			int r = read.nextInt();
			int c = read.nextInt();
			int w = read.nextInt();
			System.out.printf("Case #%d: %d\n", i, r * c / w + w + (c % w == 0 ? -1 : 0));
		}
		read.close();
	}

}
