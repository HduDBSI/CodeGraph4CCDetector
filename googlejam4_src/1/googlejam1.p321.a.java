package googlejam1.p321;
import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			// TODO

			int m1 = 0;
			int m2 = 0;
			int max = 0;
			
			int n = in.nextInt();
			int[] interv = new int[n];
			for (int i = 0; i < n; i++) {
				interv[i] = in.nextInt();
				
				if (i > 0 && interv[i] < interv[i-1]) {
					int diff = (interv[i-1] - interv[i]);
					m1 += diff;
					max = Math.max(max, diff);
				}
			}
			
			for (int i = 0; i < n-1; i++) {
				if (interv[i] < max) m2 += interv[i];
				else m2 += max;
			}
			
			 
			System.out.printf("Case #%d: %d %d\n", t, m1, m2);
		}
	}
}
