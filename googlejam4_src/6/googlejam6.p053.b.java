package googlejam6.p053;
import java.util.*;

public class b {

	//public static int[][] arrs;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for(int caseN = 1; caseN <= t; caseN++) {
			int n = in.nextInt();
			//arrs = new int[2 * n - 1][n];
			int[] counts = new int[2501];
			for(int i = 0; i < 2 * n - 1; i++)
				for(int ii = 0; ii < n; ii++) {
					int x = in.nextInt();
					counts[x]++;
				}

			System.out.print("Case #" + caseN + ":");
			for(int i = 1; i < 2501; i++) {
				if(counts[i] > 0 && counts[i] % 2 == 1)
					System.out.print(" " + i);
			}
			System.out.println();
		}

	}


}