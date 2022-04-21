package googlejam1.p294;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {

	public static final int MAX = 1000;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N, j, r1, r2,d,max;
		int[] A = new int[MAX];
		
		for (int i=1; i<=T; i++) {
			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for (j=0; j<N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			// method 1
			r1 = 0;
			for (j=1; j<N; j++) {
				d = A[j] - A[j-1];
				if (d < 0) {
					r1 += Math.abs(d);
				}
				if (Math.abs(d) > max && d < 0) {
					max = -d;
				}
			}
			//System.out.println(max);
			// method 2
			max = Math.max(0, max);
			r2 = 0;
			for (j=0; j<N-1; j++) {
				/*d = A[j] - A[j-1];
				if (d < 0) {*/
					r2 += Math.min(A[j], max); 
				//}
			}
			
			System.out.println("Case #" + i + ": " + r1 + " " + r2);
		}
	}

}
