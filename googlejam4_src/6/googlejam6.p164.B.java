package googlejam6.p164;
import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		int N = 2500;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] aa = new int[N + 1];
			for (int i = 0; i < 2 * n - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int a = Integer.parseInt(st.nextToken());
					aa[a]++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case #" + t + ":");
			for (int i = 1; i <= N; i++)
				if (aa[i] % 2 == 1)
					sb.append(" " + i);
			pw.println(sb);
		}
		pw.close();
	}
}
