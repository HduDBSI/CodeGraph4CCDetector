package googlejam4.p144;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static boolean[][]used;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int test = Integer.parseInt(next());
		for (int t = 1; t <= test; t++) {
			System.out.print("Case #"+t+": ");
			int n = Integer.parseInt(next());
			int m = Integer.parseInt(next());
			char[][]a = new char[n+1][m+1];
			for (int i = 1; i <= n; i++) {
				String s = next();
				for (int j = 1; j <= m; j++) {
					a[i][j] = s.charAt(j-1);
				}
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (a[i][j] != '.') {
						boolean found = false;
						int add = 1;
						for (int k = i+1; k <= n; k++) {
							if (a[k][j] != '.') {
								if (a[i][j]=='v')
									add = 0;
								found = true;
							}
						}
						for (int k = i-1; k >= 1; k--) {
							if (a[k][j] != '.') {
								if (a[i][j]=='^')
									add = 0;
								found = true;
							}
						}
						for (int k = j+1; k <= m; k++) {
							if (a[i][k] != '.') {
								if (a[i][j]=='>')
									add = 0;
								found = true;
							}
						}
						for (int k = j-1; k >= 1; k--) {
							if (a[i][k] != '.') {
								if (a[i][j]=='<')
									add = 0;
								found = true;
							}
						}
						if (!found) {
							ans = -1;
							break;
						}
						ans += add;
					}
				}
			}
			if (ans==-1)
				System.out.println("IMPOSSIBLE");
			else {
				System.out.println(ans);
			}
		}
		pw.close();
	}

	private static String next() throws IOException{
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

}
