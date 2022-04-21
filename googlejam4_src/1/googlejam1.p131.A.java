package googlejam1.p131;
import java.util.Scanner;

public class A {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
			int[] m = new int[N];
			
			for (int i2 = 0; i2 < N; i2++) {
			    m[i2] = sc.nextInt();
			}
			
			long diff_tot = 0;
			int diff_max = 0;
			int prev = m[0];
			for (int i3 = 1; i3 < N; i3++) {
			    int diff = m[i3] - m[i3-1];
			
			    if (diff <= 0) {
			        diff_tot -= diff;
			        diff_max = Math.max(diff_max, -diff);
			    }
			
			    prev = m[i3];
			}
			
			long e2_tot = 0;
			for (int i1 = 0; i1 < N - 1; i1++) {
			    if (m[i1] >= diff_max) {
			        e2_tot += diff_max;
			    } else {
			        //if (m[i+1] == 0) {
			        e2_tot += m[i1];
			    }
			}
			
			System.out.printf("Case #%d: %d %d\n", i+1, diff_tot, e2_tot);
        }
    }
}
