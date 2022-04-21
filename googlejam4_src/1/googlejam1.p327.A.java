package googlejam1.p327;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int c = 0; c < cases; c++) {
			int n = input.nextInt();
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = input.nextInt();
			}
			int minA = 0;
			int maxD = 0;
			for (int i = 1; i < n; i++) {
				int d = m[i-1] - m[i];
				if (d > 0) {
					minA += d;
					maxD = Math.max(maxD, d);
				}
			}
			int minB = 0;
			for (int i = 0; i < n-1; i++) {
				minB += (m[i] < maxD ? m[i] : maxD);
			}
			System.out.println(String.format("Case #%d: %d %d", c+1, minA, minB));
		}
	}
}
