package googlejam3.p137;
import java.util.Scanner;

public class Brattleship {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] dp = new int[11][11];
		dp[1][1] = 1;

		dp[2][1] = 2;
		dp[2][2] = 2;

		dp[3][1] = 3;
		dp[3][2] = 3;
		dp[3][3] = 3;

		dp[4][1] = 4;
		dp[4][2] = 3;
		dp[4][3] = 4;
		dp[4][4] = 4;

		dp[5][1] = 5;
		dp[5][2] = 4;
		dp[5][3] = 4;
		dp[5][4] = 5;
		dp[5][5] = 5;

		dp[6][1] = 6;
		dp[6][2] = 4;
		dp[6][3] = 4;
		dp[6][4] = 5;
		dp[6][5] = 6;
		dp[6][6] = 6;

		dp[7][1] = 7;
		dp[7][2] = 5;
		dp[7][3] = 5;
		dp[7][4] = 5;
		dp[7][5] = 6;
		dp[7][6] = 7;
		dp[7][7] = 7;

		dp[8][1] = 8;
		dp[8][2] = 5;
		dp[8][3] = 5;
		dp[8][4] = 5;
		dp[8][5] = 6;
		dp[8][6] = 7;
		dp[8][7] = 8;
		dp[8][8] = 8;

		dp[9][1] = 9;
		dp[9][2] = 6;
		dp[9][3] = 5;
		dp[9][4] = 6;
		dp[9][5] = 6;
		dp[9][6] = 7;
		dp[9][7] = 8;
		dp[9][8] = 9;
		dp[9][9] = 9;

		dp[10][1] = 10;
		dp[10][2] = 6;
		dp[10][3] = 6;
		dp[10][4] = 6;
		dp[10][5] = 6;
		dp[10][6] = 7;
		dp[10][7] = 8;
		dp[10][8] = 9;
		dp[10][9] = 10;
		dp[10][10] = 10;

		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int R = in.nextInt();
			int C = in.nextInt();
			int W = in.nextInt();
			System.out.println("Case #" + (t + 1) + ": " + dp[C][W]);

		}

	}

}
