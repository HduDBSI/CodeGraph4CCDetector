package googlejam6.p046;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("Case #" + tc + ":");

			int N = sc.nextInt();
			int[] heightCounts = new int[3000];
			for (int i = 0; i < 2 * N - 1; i++) {
				for (int j = 0; j < N; j++) {
					int height = sc.nextInt();
					heightCounts[height]++;
				}
			}

			List<Integer> missings = new ArrayList<Integer>();
			for (int i = 0; i < heightCounts.length; i++) {
				if (heightCounts[i] % 2 != 0) {
					missings.add(i);
				}
			}

			Collections.sort(missings);
			for (int missing : missings) {
				System.out.print(" " + missing);
			}
			System.out.println();
		}

		sc.close();
	}
}
