package googlejam2.p257;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A1 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int[] C = new int[1000001]; // min counts
		for (int i = 0; i < C.length; i++)
			C[i] = i;
		for (int n = 2; n <= C.length; n++) {
			C[n] = Math.min(C[n], C[n - 1] + 1);
			int r = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
			if (r > n)
				C[r] = Math.min(C[r], C[n] + 1);
		}
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			out.println("Case #" + t + ": " + C[N]);
		}
		out.close();
	}

}
