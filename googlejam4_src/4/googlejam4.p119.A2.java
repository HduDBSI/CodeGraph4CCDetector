package googlejam4.p119;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A2 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int ntests = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= ntests; tc++) {
			String[] line = bf.readLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			char[][] grid = new char[r][];
			for (int i = 0; i < r; i++) {
				grid[i] = bf.readLine().toCharArray();
			}

			boolean isImpossible = false;
			int numChanged = 0;
			int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			// this is n^3, but we could make it faster if we wanted
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					int curDir = 0;
					switch (grid[i][j]) {
					case '.':
						// safe, nothing to do
						continue;
					case '^':
						curDir = 0;
						break;
					case '>':
						curDir = 1;
						break;
					case 'v':
						curDir = 2;
						break;
					case '<':
						curDir = 3;
						break;
					}

					boolean hasArrowInCurDir = false;
					for (int[] pos = { i + dirs[curDir][0], j + dirs[curDir][1] }; pos[0] >= 0 && pos[1] >= 0 && pos[0] < r
							&& pos[1] < c; pos[0] += dirs[curDir][0], pos[1] += dirs[curDir][1]) {
						if (grid[pos[0]][pos[1]] != '.') {
							hasArrowInCurDir = true;
							break;
						}
					}
					if (!hasArrowInCurDir) {
						for (int otherDirs = 0; otherDirs <= 3; otherDirs++) {
							if (otherDirs == curDir)
								continue;

							for (int[] pos = { i + dirs[otherDirs][0], j + dirs[otherDirs][1] }; pos[0] >= 0 && pos[1] >= 0
									&& pos[0] < r && pos[1] < c; pos[0] += dirs[otherDirs][0], pos[1] += dirs[otherDirs][1]) {
								if (grid[pos[0]][pos[1]] != '.') {
									hasArrowInCurDir = true;
									break;
								}
							}

							if (hasArrowInCurDir) {
								break;
							}
						}

						if (hasArrowInCurDir) {
							numChanged++;
						} else {
							isImpossible = true;
						}
					}
				}
			}

			if (isImpossible) {
				System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
			} else {
				System.out.println("Case #" + tc + ": " + numChanged);
			}
		}
	}
}
