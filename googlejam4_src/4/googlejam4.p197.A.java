package googlejam4.p197;
import java.util.*;

public class A {
static int dx[] = {0, -1, 0, 1, 0};
static int dy[] = {0, 0, 1, 0, -1};
public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	int nCase = scanner.nextInt();
	
	for (int nc = 1; nc <= nCase; nc++) {
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		scanner.nextLine();
		
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String in = scanner.nextLine();
			for (int j = 0; j < C; j++)
				switch (in.charAt(j)) {
					case '.':
						map[i][j] = 0;
						break;
					case '^':
						map[i][j] = 1;
						break;
					case '>':
						map[i][j] = 2;
						break;
					case 'v':
						map[i][j] = 3;
						break;
					case '<':
						map[i][j] = 4;
						break;
				}
		}
		
		int ans = 0;
		
		for (int i = 0; i < R && ans >= 0; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] > 0) {
					int R1 = map.length;
					int C1 = map[0].length;	
					int oldDir = map[i][j];
					int ans1 = -1;
					for (int dir = 1; dir <= 4 && ans1 != 0; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						while (0 <= nx && nx < R1 && 0 <= ny && ny < C1) {
							if (map[nx][ny] > 0) {
								if (dir == oldDir) {
									ans1 = 0;
									break;
								} else {
									ans1 = 1;
									break;
								}
							}
							nx = nx + dx[dir];
							ny = ny + dy[dir];
						}
						//System.out.printf("x:%d y:%d oldDir:%d dir:%d ans:%d", x, y, oldDir, dir, ans);
					}
					int need = ans1;
					if (need < 0) {
						ans = -1;
						break;
					} else
						ans += need;
				}
					
		if (ans >= 0)
			System.out.println("Case #" + nc + ": " + ans);
		else
			System.out.println("Case #" + nc + ": IMPOSSIBLE");
	}
}
}