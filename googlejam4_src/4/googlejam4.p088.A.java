package googlejam4.p088;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException {
		A r = new A();
		Scanner sc = new Scanner(new FileReader("A-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("A-large.out"));
		
		int nc = sc.nextInt();
		for (int tc = 1; tc <= nc; tc++) {
		
			int r1 = sc.nextInt();
			int c = sc.nextInt();
			char[][] g = new char[r1][c];
			for (int i = 0; i < r1; i++) {
				g[i] = sc.next().toCharArray();
			}
		
			boolean imp = false;
			int ans = 0;
			for (int j = 0; j < c; j++) {
				int i = 0;
				while (i < r1) {
					if (g[i][j] == '.')
						i++;
					else if (g[i][j] == '^') {
						boolean ok = false;
						int i1 = i - 1;
						while (i1 >= 0) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1--;
						}
						i1 = i + 1;
						while (i1 < g.length) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1++;
						}
						int j1 = j - 1;
						while (j1 >= 0) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1--;
						}
						j1 = j + 1;
						while (j1 < g[0].length) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1++;
						}
						imp |= !ok;
						ans++;
						break;
					} else
						break;
				}
			}
			for (int j = 0; j < c; j++) {
				int i = r1 - 1;
				while (i >= 0) {
					if (g[i][j] == '.')
						i--;
					else if (g[i][j] == 'v') {
						boolean ok = false;
						int i1 = i - 1;
						while (i1 >= 0) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1--;
						}
						i1 = i + 1;
						while (i1 < g.length) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1++;
						}
						int j1 = j - 1;
						while (j1 >= 0) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1--;
						}
						j1 = j + 1;
						while (j1 < g[0].length) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1++;
						}
						imp |= !ok;
						ans++;
						break;
					} else
						break;
				}
			}
		
			for (int i = 0; i < r1; i++) {
				int j = 0;
				while (j < c) {
					if (g[i][j] == '.')
						j++;
					else if (g[i][j] == '<') {
						boolean ok = false;
						int i1 = i - 1;
						while (i1 >= 0) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1--;
						}
						i1 = i + 1;
						while (i1 < g.length) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1++;
						}
						int j1 = j - 1;
						while (j1 >= 0) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1--;
						}
						j1 = j + 1;
						while (j1 < g[0].length) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1++;
						}
						imp |= !ok;
						ans++;
						break;
					} else
						break;
				}
			}
			for (int i = 0; i < r1; i++) {
				int j = c - 1;
				while (j >= 0) {
					if (g[i][j] == '.')
						j--;
					else if (g[i][j] == '>') {
						boolean ok = false;
						int i1 = i - 1;
						while (i1 >= 0) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1--;
						}
						i1 = i + 1;
						while (i1 < g.length) {
							if (g[i1][j] != '.') {
								ok = true;
								break;
							}
							i1++;
						}
						int j1 = j - 1;
						while (j1 >= 0) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1--;
						}
						j1 = j + 1;
						while (j1 < g[0].length) {
							if (g[i][j1] != '.') {
								ok = true;
								break;
							}
							j1++;
						}
						imp |= !ok;
						ans++;
						break;
					} else
						break;
				}
			}
			String ansStr = imp ? "IMPOSSIBLE" : (ans + "");
			pw.printf("Case #%d: %s\n", tc, ansStr);
		}
		
		pw.close();
		sc.close();
	}

}
