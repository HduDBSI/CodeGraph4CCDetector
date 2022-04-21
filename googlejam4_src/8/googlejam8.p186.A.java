package googlejam8.p186;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
	
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter("A-large.out");
		br = new BufferedReader(new FileReader("A-large.in"));
		
		int t = Integer.parseInt(next());
		
		for (int test = 1; test <= t; test++) {
			pw.printf("Case #%d:", test);
			
			int n = Integer.parseInt(next());
			
			int total = 0;
			int[] s = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = Integer.parseInt(next());
				total += s[i];
			}
			
			while (total > 0) {
				String a = "";
				for (int j = 0; j < 2; j++) {
					int m = 0;
					for (int i = 1; i < n; i++) {
						if (s[i] > s[m]) {
							m = i;
						}
					}
					s[m]--;
					if (j == 1) {
						int m2 = 0;
						for (int i = 1; i < n; i++) {
							if (s[i] > s[m2]) {
								m2 = i;
							}
						}
						if (s[m2] > (total - 1) / 2) {
							s[m]++;
							break;
						}
					}
					a += ALPHA.charAt(m);
					total--;
				}
				
				pw.print(" " + a);
			}
			pw.println();
		}
		pw.close();
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out = new PrintWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}