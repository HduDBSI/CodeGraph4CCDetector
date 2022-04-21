package googlejam4.p121;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int t = 1; t <= T; t++) {
			int res = 0;
			int R = in.nextInt();
			int C = in.nextInt();
			in.nextLine();

			char[][] board = new char[R][C];
			int[] rowArrows = new int[R];
			int[] colArrows = new int[C];

			for (int r = 0; r < R; r++) {
				board[r] = in.nextLine().toCharArray();
			}

			for (int r = 0; r < R; r++) {
				boolean first = true;
				char lastArrow = '.';
				for (int c = 0; c < C; c++) {
					if (board[r][c] != '.') {
						if (first && board[r][c] == '<') {
							res++;
						}
						first = false;
						lastArrow = board[r][c];
						rowArrows[r]++;
					}
				}
				if (lastArrow == '>') {
					res++;
				}
			}

			for (int c = 0; c < C; c++) {
				boolean first = true;
				char lastArrow = '.';
				for (int r = 0; r < R; r++) {
					if (board[r][c] != '.') {
						if (first && board[r][c] == '^') {
							res++;
						}
						first = false;
						lastArrow = board[r][c];
						colArrows[c]++;
					}
				}
				if (lastArrow == 'v') {
					res++;
				}
			}

			boolean imp = false;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c] != '.') {
						if (rowArrows[r] == 1 && colArrows[c] == 1) {
							imp = true;
							break;
						}
					}
				}
				if (imp) {
					break;
				}
			}
			
			if (imp) {
				System.out.format("Case #%d: IMPOSSIBLE\n", t);
			} else {
				System.out.format("Case #%d: %d\n", t, res);
			}

		}

		in.close();
	}

}
