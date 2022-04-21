package googlejam1.p415;
import java.io.*;
import java.util.*;

public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));

		int N = Integer.parseInt(br.readLine());

		for(int p = 0; p < N; p++) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] v = new int[n];
			for(int i = 0; i < n; i++) v[i] = Integer.parseInt(s[i]);

			int ret1 = 0;
			int maxslope = 0;

			for(int i = 1; i < n; i++) {
				int d = v[i-1] - v[i];
				if(d > 0) {
					maxslope = Math.max(maxslope, d);
					ret1 += d;
				}
			}

			int ret2 = 0;
			for(int i = 0; i < n-1; i++) {
				ret2 += Math.min(maxslope, v[i]);
			}

			pw.println("Case #" + (p+1) + ": " + ret1 + " " + ret2);
		}


		pw.flush();
		pw.close();

	}
}