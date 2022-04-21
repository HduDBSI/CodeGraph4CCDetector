package googlejam8.p095;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProblemASmall {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		in = new Scanner(new File("A-large.in"));
		
		int T = in.nextInt();
		for (int i=1; i<=T; i++) {
			int N = in.nextInt();
			
			int[] P = new int[N];
			int total = 0;
			for (int j=0; j<N; j++) {
				P[j] = in.nextInt();
				total += P[j];
			}
			
			StringBuilder sb = new StringBuilder();
			while (total > 0) {
				int max1 = 0;
				int max2 = 0;
				int max1Idx = 0;
				int max2Idx = 0;
				for (int k=0; k<N; k++) {
					if (P[k] > max1) {
						max2 = max1;
						max1 = P[k];
						max2Idx = max1Idx;
						max1Idx = k;
					} else if (P[k] > max2) {
						max2 = P[k];
						max2Idx = k;
					}
				}
				
				sb.append(' ');
				if (P[max1Idx] > 1 && max2*2 <= total-2) {
					P[max1Idx] -= 2;
					total -= 2;
					sb.append((char)('A'+max1Idx));
					sb.append((char)('A'+max1Idx));
				} else if (max2*2 <= total-1) {
					P[max1Idx]--;
					total--;
					sb.append((char)('A'+max1Idx));
				} else {
					P[max1Idx]--;
					P[max2Idx]--;
					total -= 2;
					sb.append((char)('A'+max1Idx));
					sb.append((char)('A'+max2Idx));
				}
			}
			
			System.out.printf("Case #%d:%s\n", i, sb.toString());
		}
	}
}