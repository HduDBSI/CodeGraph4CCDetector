package googlejam2.p077;
import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) throws IOException {
		Main r = new Main();
		//		if (new File("input.txt").exists())
		//			in = new BufferedReader(new FileReader("input.txt"));
		//		else
					r.in = new BufferedReader(new InputStreamReader(System.in));
				r.out = new PrintWriter(System.out);
		//		out = new PrintWriter("output.txt");
				int m = 17;
						long x[] = new long[m];
						long d[] = new long[m];
						d[0] = 1;
						for (int i = 1; i < m; i++) {
							d[i] = d[i - 1] * 10;
						}
						x[1] = 1;
						x[2] = 11;
						for (int i = 3; i < m; i++) {
							x[i] = x[i - 1] + (d[(i - 1) / 2] - 2) + 
									(d[(i - 1) / 2 +
									   (((i - 1) % 2 == 0) ? 0 : 1)] - 2) + 3;
				//			System.err.println(x[i]);
						}
						
						int T = Integer.parseInt(r.nextToken());
						
						
						for (int t = 0; t < T; t++) {
							
							long n = Long.parseLong(r.nextToken());
							
							int u = 1;
							while (d[u] < n)
								u++;
				//			System.err.println(u + " " + d[u]);
							long ans = x[u];
							if (n < 12)
								ans = n;
							else if (n == d[u])
								ans = x[u + 1] - 1;
							else {
								String s = Long.toString(n);
								boolean o = false;
								if (s.charAt(s.length() - 1) == '0') {
									s = Long.toString(n - 1);
									o = true;
								}
								
								String k = s.substring(0, s.length() / 2);
								String v = s.substring(s.length() / 2, s.length());
								char c[] = k.toCharArray();
								for (int i = 0; i < c.length / 2; i++) {
									char y = c[i];
									c[i] = c[c.length - i - 1];
									c[c.length - i - 1] = y;
								}
								long l = Long.parseLong(new String(c));
								long r1 = Long.parseLong(v);
				//				System.err.println(ans + " " + l + " " + r);
								ans += r1 - 1;
								if (l > 1)
									ans += l;
								if (o) 
									ans++;
							}
							
							r.out.println("Case #" + (t + 1) + ": " + ans);
						}
				r.in.close();
				r.out.close();		
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}
