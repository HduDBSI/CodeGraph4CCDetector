package googlejam4.p205;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int caseNum = 1;  caseNum <= t; caseNum++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			char[][] grid = new char[r][c];
			for (int i = 0; i < r; i++) {
				grid[i] = sc.next().toCharArray();
			}

			int count = 0;
			boolean isImpossible = false;
			for (int i = 0; i < r; i++) {
				boolean firstFound = false;
				boolean lastFound = false;
				char first = '.';
				int firstIdx = -1;
				char last = '.';
				int lastIdx = -1;
				for (int j = 0; j < c; j++) {
					if (!firstFound) {
						if (grid[i][j] != '.') {
							first = grid[i][j];
							firstIdx = j;
							firstFound = true;
						}
					}
					else {
						if (grid[i][j] != '.') {
							last = grid[i][j];
							lastIdx = j;
							lastFound = true;
						}
					}
				}
				if (lastFound) {
					if (first == '<') {
						count += 1;
					}
					if (last == '>') {
						count += 1;
					}
				}
				else {
					if (first == '<' || first == '>') {
						grid[i][firstIdx] = '*';
					}
				}
				// System.out.printf("first: %c, firstIdx: %d, last: %c, lastIdx: %d\n", first, firstIdx, last, lastIdx);
				// System.out.println(i + " " + count);
			}

			for (int j = 0; j < c; j++) {
				boolean firstFound = false;
				boolean lastFound = false;
				char first = '.';
				int firstIdx = -1;
				char last = '.';
				int lastIdx = -1;
				for (int i = 0; i < r; i++) {
					if (grid[i][j] == '*') {
						count += 1;
					}

					if (!firstFound) {
						if (grid[i][j] != '.') {
							first = grid[i][j];
							firstIdx = i;
							firstFound = true;
						}
					}
					else {
						if (grid[i][j] != '.') {
							last = grid[i][j];
							lastIdx = i;
							lastFound = true;
						}
					}
				}
				if (lastFound) {
					if (first == '^') {
						count += 1;
					}
					if (last == 'v') {
						count += 1;
					}
				}
				else {
					if (first == '^' || first == 'v') {
						grid[firstIdx][j] = '&';
					}
					else if (first == '*') {
						isImpossible = true;
					}
				}
			}
			/*
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			System.out.println(count);
			*/

			for (int i = 0; i < r; i++) {
				boolean firstFound = false;
				boolean lastFound = false;
				boolean ampFound = false;
				char first = '.';
				int firstIdx = -1;
				char last = '.';
				int lastIdx = -1;
				for (int j = 0; j < c; j++) {
					if (grid[i][j] == '&') {
						ampFound = true;
						count += 1;
					}
					if (!firstFound) {
						if (grid[i][j] != '.') {
							first = grid[i][j];
							firstIdx = j;
							firstFound = true;
						}
					}
					else {
						if (grid[i][j] != '.') {
							last = grid[i][j];
							lastIdx = j;
							lastFound = true;
						}
					}
				}
				if (ampFound && !lastFound) {
					isImpossible = true;
				}
			}
			// System.out.println(count);

			/*
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			*/
				
			if (isImpossible) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
			}
			else {
				System.out.printf("Case #%d: %d\n", caseNum, count);
			}
		}
	}
}
