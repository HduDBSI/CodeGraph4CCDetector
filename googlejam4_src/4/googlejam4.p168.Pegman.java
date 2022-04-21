package googlejam4.p168;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Pegman {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		Pegman obj = new Pegman();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(fileName + ".out"));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			int R = Integer.parseInt(token.nextToken());
			int C = Integer.parseInt(token.nextToken());
			int[][] map = new int[C][R];
			for (int j = 0 ; j < R ; j++) {
				str = br.readLine();
				for (int k = 0 ; k < C ; k++) {
					switch (str.charAt(k)) {
					case '^':
						map[k][j] = 1;
						break;
					case '>':
						map[k][j] = 2;
						break;
					case 'v':
						map[k][j] = 3;
						break;
					case '<':
						map[k][j] = 4;
						break;
					default:
						map[k][j] = 0;
						break;
					}
				}
			}
			int ans = 0;
			for (int j = 0 ; j < R; j++) {
				for (int k = 0 ; k < C ; k++) {
					if (map[k][j] == 0) {
						continue;
					}
					int x = k;
					int y = j;
					boolean flg = false;
					while (true) {
						x += obj.DIR[map[k][j]][0];
						y += obj.DIR[map[k][j]][1];
						if ( x < 0 || x >= C || y < 0 || y >= R ) {
							break;
						}
						if (map[x][y] != 0) {
							flg = true;
							break;
						}
					}
					if (flg) {
						continue;
					}
					flg = false;
					for (int d = 1 ; d <= 4 ; d++ ) {
						if (map[k][j] == d) {
							continue;
						}
						x = k;
						y = j;
						while (true) {
							x += obj.DIR[d][0];
							y += obj.DIR[d][1];
							if ( x < 0 || x >= C || y < 0 || y >= R ) {
								break;
							}
							if (map[x][y] != 0) {
								flg = true;
								break;
							}
						}
						if (flg) {
							break;
						}
					}
					if (flg) {
						ans += 1;
						continue;
					} else {
						ans = -1;
						break;
					}
				}
				if (ans == -1) {
					break;
				}
			}
		
			if (ans == -1) {
				bw.write("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
			} else {
				bw.write("Case #" + (i + 1) + ": " + ans);
			}
			bw.write("\r\n");
		}
		bw.close();
		br.close();
	}

	final int[][] DIR = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
}
