package googlejam1.p813;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			String[] data = in.readLine().split(" ");
			int[] M1 = new int[N];
			for (int i = 0; i < N; i++)
				M1[i] = Integer.parseInt(data[i]);
			int[] M = M1;
			int m = 0;
			for (int i = 1; i < M.length; i++)
				if (M[i] < M[i - 1])
					m += M[i - 1] - M[i];
			int y = m;
			int m1 = 0;
			
			double rate = 0;
			for (int i = 1; i < M.length; i++) {
				int diff = M[i - 1] - M[i];
				if (diff > 0) {
					double r = diff / 10.0;
					if (r > rate)
						rate = r;
				}
			}
			
			for (int i = 1; i < M.length; i++)
				m1 += Math.min(rate * 10, M[i - 1]);
			int z = m1;
			out.println("Case #" + t + ": " + y + " " + z);
		}
		out.close();
	}
}
