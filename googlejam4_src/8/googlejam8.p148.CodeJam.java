package googlejam8.p148;
import java.util.Scanner;

public class CodeJam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int T = Integer.parseInt(sc.nextLine());
		for (int caseCount = 1; caseCount <= T; caseCount++) {
			final int N = sc.nextInt();
			int[] senates = new int[N];
			for (int i = 0; i < N; i++) {
				senates[i] = sc.nextInt();
			}
			System.out.print("Case #" + caseCount + ": ");
			boolean done = false;
			while (true) {
				int onesLeft = 0;
				for (int i = 0; i < N; i++) {
					if (senates[i] > 1) {
						onesLeft = 0;
						break;
					} else if (senates[i] == 1) {
						onesLeft++;
					}
				}
				if (onesLeft == 2) {
					for (int i = 0; i < N; i++) {
						if (senates[i] == 1) {
							System.out.print((char) (65 + i));
						}
					}
					System.out.println();
					break;
				}
				if (onesLeft == 3) {
					for (int i = 0; i < N; i++) {
						if (senates[i] == 1) {
							senates[i]--;
							System.out.print((char) (65 + i) + " ");
							break;
						}
					}
					continue;
				}
				done = true;
				int max = 0;
				int maxNext = 0;
				for (int i = 0; i < N; i++) {
					if (senates[i] > 0) {
						done = false;
					}
					if (senates[i] >= senates[max]) {
						maxNext = max;
						max = i;
					}
				}
				if (done) {
					System.out.println();
					break;
				}
				if (senates[max] > senates[maxNext] || max == maxNext) {
					senates[max]--;
					System.out.print((char) (65 + max) + " ");
				} else {
					senates[max]--;
					senates[maxNext]--;
					System.out.print((char) (65 + max));
					System.out.print((char) (65 + maxNext) + " ");
				}
			}
		}
		sc.close();
	}

}