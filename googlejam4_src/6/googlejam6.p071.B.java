package googlejam6.p071;
import java.util.*;
public class B {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			
			int N = sc.nextInt();
			int [] heights = new int [3000];
			for (int i = 0; i<2*N-1; ++i) {
				for (int j = 0; j<N; ++j) {
					int height = sc.nextInt();
					heights[height]++;
				}
			}
			int [] ans = new int [N+1];
			int ptr = 0;
			System.err.print(ii + " : ");
			for (int i = 0; i<heights.length; ++i) {
				if (heights[i] % 2 == 1) {
					ans[ptr] = i;
					ptr++;
					System.err.print(i + " ");
				}
			}
			System.err.println();
			
			System.out.printf("Case #%d: ", ii);
			for (int i = 0; i<N; ++i) {
				System.out.print(ans[i]);
				if (i != N-1) System.out.print(" ");
				if (i == N-1) System.out.println();
			}
		}
	}
}