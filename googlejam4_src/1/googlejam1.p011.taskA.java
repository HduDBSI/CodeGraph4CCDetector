package googlejam1.p011;
import java.io.*;
import java.util.*;

public class taskA {

	PrintWriter out;
	BufferedReader br;
	StringTokenizer st;

	String nextToken() throws IOException {
		while ((st == null) || (!st.hasMoreTokens()))
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public static void main(String[] args) {
		taskA r = new taskA();
		try {
			r.br = new BufferedReader(new InputStreamReader(System.in));
			r.out = new PrintWriter(System.out);
		
			r.br = new BufferedReader(new FileReader("taskA.in"));
			r.out = new PrintWriter("taskA.out");
			int n = Integer.parseInt(r.nextToken());
			for (int i = 0; i < n; i++) {
		
				r.out.print("Case #" + (i + 1) + ": ");
				int n1 = Integer.parseInt(r.nextToken());
						int[] a = new int[n1];
						for (int i2 = 0; i2 < n1; i2++) {
							a[i2] = Integer.parseInt(r.nextToken());
						}
						int y = 0;
						int z = 0;
						int minS = 0;
						for (int i3 = 1; i3 < n1; i3++) {
							if (a[i3] < a[i3 - 1]) {
								y += a[i3 - 1] - a[i3];
								minS = Math.max(minS, a[i3 - 1] - a[i3]);
							}
						}
				//		System.err.println("==");
						for (int i1 = 0; i1 < n1 - 1; i1++) {
				//			System.err.println(a[i] + " " + minS);
							z += Math.min(a[i1], minS);
						}
						r.out.println(y + " " + z);
			}
			r.out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
