package googlejam4.p049;
import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/A-large.in"))));

		String output = "";
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= t; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			sc.nextLine();
			char[][] grid = new char[r][c];
			for (int j = 0; j < r; j++) {
				grid[j] = sc.nextLine().toCharArray();
			}
			int arrowsToChange = 0;
			boolean isImpossible = false;
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					char g = grid[j][k];
					if (g=='.')
						continue;
					if (g=='^') {
						boolean needsToChange = true;
						for (int m = j-1; m >= 0; m--) {
							if (grid[m][k] != '.') {
								needsToChange = false;
								break;
							}
						}
						if (needsToChange) {
							boolean impossible = true;
							for (int m = j+1; m < r; m++) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k-1; m >= 0; m--) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k+1; m < c; m++) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							if (impossible)
								isImpossible = true;
							else
								arrowsToChange++;
						}
					}
					if (g=='v') {
						boolean needsToChange = true;
						for (int m = j+1; m < r; m++) {
							if (grid[m][k] != '.') {
								needsToChange = false;
								break;
							}
						}
						if (needsToChange) {
							boolean impossible = true;
							for (int m = j-1; m >= 0; m--) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k-1; m >= 0; m--) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k+1; m < c; m++) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							if (impossible)
								isImpossible = true;
							else
								arrowsToChange++;
						}
					}
					if (g=='<') {
						boolean needsToChange = true;
						for (int m = k-1; m >= 0; m--) {
							if (grid[j][m] != '.') {
								needsToChange = false;
								break;
							}
						}
						if (needsToChange) {
							boolean impossible = true;
							for (int m = j+1; m < r; m++) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = j-1; m >= 0; m--) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k+1; m < c; m++) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							if (impossible)
								isImpossible = true;
							else
								arrowsToChange++;
						}
					}
					if (g=='>') {
						boolean needsToChange = true;
						for (int m = k+1; m < c; m++) {
							if (grid[j][m] != '.') {
								needsToChange = false;
								break;
							}
						}
						if (needsToChange) {
							boolean impossible = true;
							for (int m = j-1; m >= 0; m--) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = k-1; m >= 0; m--) {
								if (grid[j][m] != '.') {
									impossible = false;
									break;
								}
							}
							for (int m = j+1; m < r; m++) {
								if (grid[m][k] != '.') {
									impossible = false;
									break;
								}
							}
							if (impossible)
								isImpossible = true;
							else
								arrowsToChange++;
						}
					}
				}
			}
			String tempOut = "";
			if (isImpossible)
				tempOut = "IMPOSSIBLE";
			else
				tempOut = ""+arrowsToChange;
			output += "Case #" + i + ": " + tempOut + "\n";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/A-large.out"), "utf-8"));
		bw.write(output);
		bw.close();
	}
}