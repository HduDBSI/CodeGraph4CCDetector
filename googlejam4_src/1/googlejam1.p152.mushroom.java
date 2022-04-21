package googlejam1.p152;


import java.io.*;
import java.util.*;

public class mushroom {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("mushroom.in"));
				//new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter("mushroom.out")));
				//new OutputStreamWriter(System.out)));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans1 = 0;
			int maxDiff = 0;
			int prev = Integer.parseInt(st.nextToken());
			int[] ar = new int[n];
			ar[0] = prev;
			for (int i = 1; i < n; i++) {
				int next = Integer.parseInt(st.nextToken());
				ar[i] = next;
				if (next < prev) {
					ans1 += prev - next;
					if (prev - next > maxDiff) {
						maxDiff = prev - next;
					}
				}
				prev = next;
			}
			int ans2 = 0;
			for (int i = 0; i < n - 1; i++) {
				if (ar[i] < maxDiff) {
					ans2 += ar[i];
				}
				else {
					ans2 += maxDiff;
				}
			}
			out.printf("Case #%d: %d %d\n", tc, ans1, ans2);
		}
		out.flush();
		System.exit(0);
	}
	
}
