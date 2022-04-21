package googlejam9.p141;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CodeJam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int T = Integer.parseInt(sc.nextLine());
		for (int caseCount = 1; caseCount <= T; caseCount++) {
			final int B = sc.nextInt();
			final long M = sc.nextLong();
			int[][] g = new int[B][B];
			long[] pathCounts = new long[B];
			g[B-2][B-1] = 1;
			pathCounts[B-1] = 1;
			for (int y = B - 2; y >= 0; y--) {
				long count = 0;
				for (int x = y + 1; x < B; x++) {
					try {
					if (count + pathCounts[x] <= M) {
						g[y][x] = 1;
						count += pathCounts[x];
					}
					
					} catch (InputMismatchException e) {
					    System.out.print(e.getMessage()); //try to find out specific reason.
					}
				}
				pathCounts[y] = count;
			}
			boolean possible = (pathCounts[0] == M);

			System.out.print("Case #" + caseCount + ": ");
			if (possible) {
				System.out.println("POSSIBLE");
				for (int y = 0; y < B; y++) {
					for (int x = 0; x < B; x++) {
						System.out.print(g[y][x]);
					}
					System.out.println();
				}
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
		sc.close();
	}

}