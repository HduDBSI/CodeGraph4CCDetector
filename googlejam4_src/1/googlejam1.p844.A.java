package googlejam1.p844;
import java.util.*;

public class A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int caze = 1; caze <= T; caze++) {
			int ans1 = 0;
			int ans2 = Integer.MAX_VALUE;
			int N = sc.nextInt();
			int[] mush = new int[N];
			for (int i = 0; i < N; i++) {
				mush[i] = sc.nextInt();
			}	

			for (int i = 0; i < N-1; i++) {
				int best = 100000000;
				if (mush[i] > mush[i+1]) {
					best = Math.abs(mush[i]-mush[i+1]);
					best = Math.min(best, mush[i]);
				} else {
					best = 0;
				}
				//System.out.println("BEST: " + best);
				ans1 += best;
			}

			M:
			for (int c = 0; c < 10000; c++) {
				int mushPer10 = c;
				int cnt = 0;
				for (int i = 0; i < N-1; i++) {
					int amt = 0;
					cnt += Math.min(mushPer10, mush[i]);
					int mushi = mush[i] - mushPer10;
					if (mushi > mush[i+1]) continue M;
				}
				ans2 = Math.min(ans2, cnt);
			}
			System.out.printf("Case #%d: %d %d\n", caze, ans1, ans2);
		}
	}
}