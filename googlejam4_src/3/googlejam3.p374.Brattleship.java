package googlejam3.p374;


import java.util.Scanner;

public final class Brattleship {

	public static void main(final String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			final int t = sc.nextInt();
			int r;
			int c;
			int w;
			int n;
			for (int i = 0; i < t; i++) {
				r = sc.nextInt();
				c = sc.nextInt();
				w = sc.nextInt();
				n = 0;
				if (w == 1) {
					System.out.println("Case #" + (i + 1) + ": " + r * c);
					continue;
				}

				n = c / w + w;
				if (c % w == 0) {
					n--;
				}

				n += (r - 1) * (c / w);

				/*if ((w & 1) != 0) {
					if (c % w > (w >> 1) + 1) {
						n++;
					}
				} else {
					if (c % w > w >> 1) {
						n++;
					}
				}*/

				// n = c / w + w + c % w;
				/*if ((c & 1) != 0) {
					if ((w & 1) != 0) {
						n--;
					} else {
						n--;
					}
				} else {
					if ((w & 1) != 0) {
						//
					} else {
						//
					}
				}*/

				System.out.println("Case #" + (i + 1) + ": " + n);
			}
		}
	}
}