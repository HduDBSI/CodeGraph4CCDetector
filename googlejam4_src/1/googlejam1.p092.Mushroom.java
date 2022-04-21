package googlejam1.p092;
import java.io.*;
import java.util.*;

class Mushroom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] aa = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				aa[i] = Integer.parseInt(st.nextToken());
			int sum1 = 0;
			for (int i = 1; i < n; i++)
				if (aa[i - 1] > aa[i])
					sum1 += aa[i - 1] - aa[i];
			int max = 0;
			for (int i = 1; i < n; i++)
				if (aa[i - 1] - aa[i] > max)
					max = aa[i - 1] - aa[i];
			int sum2 = 0;
			for (int i = 1; i < n; i++)
				sum2 += Math.min(max, aa[i - 1]);
			pw.println("Case #" + t + ": " + sum1 + " " + sum2);
		}
		pw.close();
	}
}
