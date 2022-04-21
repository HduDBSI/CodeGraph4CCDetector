package googlejam1.p714;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class A {
	static BufferedReader in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File(
				"/Users/yfo/Downloads/a2.in")));
		out = new PrintWriter(new FileWriter(new File(
				"/Users/yfo/Downloads/a2.out.in")));

		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(in.readLine());
			String[] tok = in.readLine().split(" ");
			int[] res = new int[tok.length];
			for (int i1 = 0; i1 < tok.length; i1++) {
				res[i1] = Integer.parseInt(tok[i1]);
			}
			int[] m = res;
			
			long first = 0;
			for (int i=1;i<N;i++) {
				if (m[i]<m[i-1]) first += m[i-1] - m[i];
			}
			
			long max = 0;
			for (int i=0;i<N-1;i++) {
				if (m[i]>m[i+1]) {
					max = Math.max(max, m[i]-m[i+1]);
				}
			}
			
			
			long second = 0;
			for (int i=0;i<N-1;i++) {
				if (i!=N-1) {
					second += Math.min(max, m[i]);
				}
				
			}
			
			
			out.println("Case #" + (t + 1) + ": " + first + " "+second);
		}

		in.close();
		out.close();
	}
}
