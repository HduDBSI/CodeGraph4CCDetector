package googlejam4.p111;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException,
			FileNotFoundException {
		String file = "A-large";

		Scanner scan = new Scanner(new BufferedReader(new FileReader(file
				+ ".in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file
				+ ".out")));

		int T = Integer.parseInt(scan.nextLine());
		for (int t = 1; t <= T; t++) {
			String[] info = scan.nextLine().split(" ");
			int R = Integer.parseInt(info[0]);
			int C = Integer.parseInt(info[1]);
			char[][] grid = new char[R][C];
			for (int r = 0; r < R; r++)
				grid[r] = scan.nextLine().toCharArray();

			char[] arrow = { '^', '>', 'v', '<' };
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int cnt = 0;
			boolean impossible = false;
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (grid[r][c] != '.') {
						boolean stop = false;
						boolean found = false;
						for (int d = 0; d < 4; d++) {
							int nr = r, nc = c;
							while (true) {
								nr += dr[d];
								nc += dc[d];
								if (nr < 0 || nr >= R || nc < 0 || nc >= C)
									break;
								if (grid[nr][nc] != '.') {
									found = true;
									if (arrow[d] == grid[r][c])
										stop = true;
									break;
								}
							}
						}
						if (!found)
							impossible = true;
						if (!stop)
							cnt++;
					}
			if (impossible)
				pw.println("Case #" + t + ": IMPOSSIBLE");
			else
				pw.println("Case #" + t + ": " + cnt);
		}

		scan.close();
		pw.close();
	}

}
