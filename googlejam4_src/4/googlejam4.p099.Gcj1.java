package googlejam4.p099;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Gcj1 {
	static final char LEFT = '<', RIGHT = '>', DOWN = 'v', UP = '^', DOT = '.';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output1.txt"));
		int nrT = Integer.parseInt(br.readLine());

		for (int testNr = 1; testNr <= nrT; testNr++) {
			String[] strs = br.readLine().split(" ");
			int r = Integer.parseInt(strs[0]);
			int c = Integer.parseInt(strs[1]);
			int[][] map = new int[r][c];
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			boolean impossibleCase = false;
			for (int i = 0; i < map.length && !impossibleCase; i++) {
				for (int j = 0; j < map[i].length && !impossibleCase; j++) {
					if (map[i][j] == DOT) {
						continue;
					}
					boolean isOk = false;
					for (int k = 0; k < map.length; k++) {
						if (k == i) {
							continue;
						}
						if (map[k][j] != DOT) {
							isOk = true;
							break;
						}
					}
					if (isOk) {
						continue;
					}
					for (int k = 0; k < map[0].length; k++) {
						if (k == j) {
							continue;
						}
						if (map[i][k] != DOT) {
							isOk = true;
							break;
						}
					}
					if (!isOk) {
						impossibleCase = true;
						break;
					}
				}
			}

			if (impossibleCase) {
				pw.println("Case #" + testNr + ": IMPOSSIBLE");
				continue;
			}

			int res = 0;
			for (int i = 0; i < map.length && !impossibleCase; i++) {
				for (int j = 0; j < map[i].length && !impossibleCase; j++) {
					if (map[i][j] == DOT) {
						continue;
					}
					boolean needsChange = true;
					if (map[i][j] == RIGHT) {
						for (int k = j + 1; k < map[i].length; k++) {
							if (map[i][k] != DOT) {
								needsChange = false;
								break;
							}
						}
					} else if (map[i][j] == LEFT) {
						for (int k = 0; k < j; k++) {
							if (map[i][k] != DOT) {
								needsChange = false;
								break;
							}
						}
					} else if (map[i][j] == UP) {
						for (int k = 0; k < i; k++) {
							if (map[k][j] != DOT) {
								needsChange = false;
								break;
							}
						}
					} else if (map[i][j] == DOWN) {
						for (int k = i + 1; k < map.length; k++) {
							if (map[k][j] != DOT) {
								needsChange = false;
								break;
							}
						}
					}

					if (needsChange) {
						res++;
					}
				}
			}

			pw.println("Case #" + testNr + ": " + res);
		}
		br.close();
		pw.close();

		System.out.println("done!");
	}
}
