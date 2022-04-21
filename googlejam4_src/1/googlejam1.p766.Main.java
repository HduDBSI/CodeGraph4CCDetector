package googlejam1.p766;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = scan.nextInt();
            int[] m = new int[N];
            for(int j = 0; j < N; j++) {
                m[j] = scan.nextInt();
            }
            int strategyA = 0;
			int strategyB = 0;
			int rate1 = 0;
			for (int i2 = 1; i2 < m.length; i2++) {
			    rate1 = Math.max(rate1, m[i2-1] > m[i2] ? m[i2-1] - m[i2] : 0);
			}
			int rate = rate1;
			for (int i1 = 1; i1 < m.length; i1++) {
			    strategyA += m[i1-1] > m[i1] ? m[i1-1] - m[i1] : 0;
				int prev = m[i1-1];
			    strategyB += prev - rate > 0 ? rate : prev;
			}
			System.out.println("Case #" + i + ": " + strategyA + " " + strategyB);
        }
    }
}
