package googlejam1.p090;


import java.util.Scanner;

public class Q1 {
	public static void main(String... args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int caseCount = in.nextInt();
		int[] m = new int[1001];
		for (int caseValue = 1; caseValue <= caseCount; caseValue++) {
			int N = in.nextInt();
			for (int i = 0; i < N; i++) {
				m[i] = in.nextInt();
			}
			int result1 = 0; {
				int prev = m[0];
				for (int i = 1; i < N; i++) {
					int curr = m[i];
					result1 += Math.max(0, prev - curr);
					prev = curr;
				}
			}
			int result2 = 0; {
				int minEatenMax = 0;
				int prev = m[0];
				for (int i = 1; i < N; i++) {
					int curr = m[i];
					int minEaten = Math.max(0, prev - curr);
					{
						if (minEatenMax < minEaten) {
							minEatenMax = minEaten;
						}
					}
					prev = curr;
				}
				prev = m[0];
				for (int i = 1; i < N; i++) {
					int curr = m[i];
					{
						if (prev < minEatenMax) {
							result2 += prev;
						} else {
							result2 += minEatenMax;
						}
					}
					prev = curr;
				}
			}
			System.out.println("Case #" + caseValue + ": " + result1 + " " + result2);
		}
	}
}
