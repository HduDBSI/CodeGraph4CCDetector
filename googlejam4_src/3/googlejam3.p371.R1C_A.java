package googlejam3.p371;


import java.util.*;
import java.io.*;

public class R1C_A {

	static BufferedReader br;
	static PrintWriter pr;
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		//br = new BufferedReader(new InputStreamReader(System.in));
		//pr = new PrintWriter(new OutputStreamWriter(System.out));
		br = new BufferedReader(new FileReader("in.txt"));
		pr = new PrintWriter(new FileWriter("out.txt"));

		int tt = Integer.parseInt(next());
		for (int qq = 1; qq <= tt; qq++) {
			int ans = 0;
			int r = Integer.parseInt(next());
			int c = Integer.parseInt(next());
			int w = Integer.parseInt(next());
			ans = c/w + w-1 + (c % w > 0 ? 1 : 0);
			pr.printf("Case #%d: %d\n", qq, ans);
		}
		
		pr.close();
	}

	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}

