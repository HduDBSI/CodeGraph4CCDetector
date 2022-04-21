package googlejam7.p030;
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
	private static final String FILENAME = "b";

	public static void main(String[] args) throws IOException {
		Main r = new Main();
		r.in = new BufferedReader(new FileReader(Main.FILENAME + ".in"));
		r.out = new PrintWriter(Main.FILENAME + ".out");
		int T = Integer.parseInt(r.nextToken());
				for (int t = 0; t < T; t++) {
					
					int alc = 1000000;
					int arc = 10000;
					
					char[] s = r.nextToken().toCharArray();
					char[] g = r.nextToken().toCharArray();
					r.len = s.length;
					
					for (int i = 0; i < 1000; i++) {
						char[] x = String.format("%0" + r.len + "d", i).toCharArray();
		//				System.err.println(x);
						if (x.length > r.len)
							break;
						boolean o = true;
						for (int k = 0; k < r.len; k++) {
							if (s[k] != '?' && s[k] != x[k])
								o = false;
						}
						if (!o)
							continue;
						for (int j = 0; j < 1000; j++) {
							char[] y = String.format("%0" + r.len + "d", j).toCharArray();
							if (y.length > r.len)
								break;
							o = true;
							for (int k = 0; k < r.len; k++) {
								if (g[k] != '?' && g[k] != y[k])
									o = false;
							}
							if (!o)
								continue;
		//					System.err.println(x);
		//					System.err.println(s);
		//					System.err.println(y);
		//					System.err.println(g);
							if (abs(i - j) < abs(alc - arc) ||
									(abs(i - j) == abs(alc - arc) && 
									(i < alc || (i == alc && j < arc)))) {
								alc = i;
								arc = j;
							}
						}
					}
					
					
					r.out.print("Case #" + (t + 1) + ": " + 
							String.format("%0" + r.len + "d %0" + r.len + "d", alc, arc));
					
					r.out.println();
				}
		r.in.close();
		r.out.close();		
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	long alc = 20000;
	long arc = 10000;
	int len = 0;
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}
