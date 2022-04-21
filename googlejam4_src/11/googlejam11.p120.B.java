package googlejam11.p120;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class B {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		br = new BufferedReader(new FileReader("B-small.in"));
//		pw = new PrintWriter(new BufferedWriter(new FileWriter("B-small.out")));
		int tests = Integer.parseInt(next());
		for (int test = 1; test <= tests; test++) {
			pw.print("Case #"+test+": ");
			int n = Integer.parseInt(next());
			int k = Integer.parseInt(next());
			double[]p = new double[n];
			for (int i = 0; i < n; i++) {
				p[i] = Double.parseDouble(next());
			}
			double[]pp = new double[1 << n];
			double[]pp0 = new double[1 << n];
			for (int mask = 0; mask < (1 << n); mask++) {
				pp[mask] = 1;
				pp0[mask] = 1;
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) != 0) {
						pp[mask] *= p[i];
						pp0[mask] *= 1-p[i];
					}
				}
			}
			double ans = 0;
			for (int mask = 0; mask < (1 << n); mask++) {
				if (Integer.bitCount(mask)==k) {
					double cur = 0;
					for (int sub_mask = mask; sub_mask != 0; sub_mask = ((sub_mask-1) & mask)) {
						if (Integer.bitCount(sub_mask)==k/2) {
							cur += pp[sub_mask] * pp0[mask ^ sub_mask];
							ans = Math.max(ans, cur);
						}
					}
					ans = Math.max(ans, cur);
				}
			}
			pw.println(ans);
		}
		pw.close();
	}

	private static String next() throws IOException{
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

}
