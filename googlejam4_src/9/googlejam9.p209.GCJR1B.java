package googlejam9.p209;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class GCJR1B {

	public static void main(String[] args) throws Exception {
		Scanner cin = new Scanner(new FileInputStream("B-small-attempt1.in"));
		PrintWriter cout = new PrintWriter(new FileOutputStream("output.txt"));
		int T = cin.nextInt();
		for (int t = 0; t < T; ++t) {
			int B = cin.nextInt(), M = cin.nextInt();
			cout.print("Case #" + (t + 1) + ": ");
			if (M > (1 << (B - 2))) {
				cout.println("IMPOSSIBLE");
				continue;
			}
			int[][] a = new int[10][10];
			for (int i = 0; i < 10; ++i)
				Arrays.fill(a[i], 0);
			switch (M) {
			case 1:
				a[0][B - 1] = 1;
				break;
			case 2:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				break;
			case 3:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				break;
			case 4:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[1][2] = 1;
				break;
			case 5:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[1][2] = 1;
				break;
			case 6:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				break;
			case 7:
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				break;
			case 8:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				break;
			case 9:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				break;
			case 10:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				break;
			case 11:
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				break;
			case 12:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				break;
			case 13:
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				a[3][4] = 1;
				break;
			case 14:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				a[3][4] = 1;
				break;
			case 15:
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				a[3][4] = 1;
				break;
			case 16:
				a[0][B - 1] = 1;
				a[0][1] = 1;
				a[1][B - 1] = 1;
				a[0][2] = 1;
				a[2][B - 1] = 1;
				a[0][3] = 1;
				a[3][B - 1] = 1;
				a[0][4] = 1;
				a[4][B - 1] = 1;
				a[1][2] = 1;
				a[1][3] = 1;
				a[2][3] = 1;
				a[1][4] = 1;
				a[2][4] = 1;
				a[3][4] = 1;
				break;
			}
			cout.println("POSSIBLE");
			for (int i = 0; i < B; ++i) {
				for (int j = 0; j < B; ++j)
					cout.print(a[i][j]);
				cout.println();
			}
			/*
			 * if (M >= 1) a[0][B - 1] = 1; if (M >= 2){ a[0][1] = 1; a[1][B -
			 * 1] = 1; if (M >= 3){ a[0][2] = 1; a[2][B - 1] = 1; } } if (M >=
			 * 4){ a[1][2] = 1; if (M >= 5){ a[0][3] = 1; a[3][B - 1] = 1; } if
			 * (M >= 6){ a[1][3] = 1; } }
			 */
		}
		cout.flush();
	}

}
