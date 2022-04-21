package googlejam3.p046;


import java.util.Scanner;

public class Q1 {
	public static void main(String... args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int caseCount = in.nextInt();
		for (int caseValue = 1; caseValue <= caseCount; caseValue++) {
			int R = in.nextInt();
			int C = in.nextInt();
			int W = in.nextInt();
			int result = 0;
			int eliminateR = R - 1;
			if (eliminateR > 0) {
				result += eliminateR * (
						// C = 1 .. 2W-1, 1
						//   = 2W .. 3W-1, 2
						Math.max(1, C / W)
						);
			}
			int c = C;
			while (c > 2 * W - 1) {
				result++;
				c -= W;
			}
			// assert(c <= 2 * W - 1 && c >= W);
			if (c == W) {
				result += W; // W>=1
			} else if (c == W + 1){ // W>=2
				result += W + 1;
				// xWx
				// ?w
			} else if (c == W + 2) { // W>=3
				result += W + 1;
				// xxWxx
				// _?w
			} else if (c == W + 3) { // W>=4
				result += W + 1;
			} else {
				result += W + 1;
			}
			System.out.println("Case #" + caseValue + ": " + result);
		}
	}
}
