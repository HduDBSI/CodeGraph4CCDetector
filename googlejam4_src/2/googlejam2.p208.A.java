package googlejam2.p208;
import java.util.*;
import java.io.*;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

public class A {

	static int[] q;
	
	/*************************************************************************/

	public static void main(String[] args) throws Exception {
		int n = 1000006;
		q= new int[n];
		q[1] = 1;
		for (int i = 2; i < n; i++) {
			String s0 = ""+i;
			String s1 = new StringBuilder(s0).reverse().toString();
			int i1 = Integer.parseInt(s1);
			int q1 = q[i-1] + 1;
			int q2 = Integer.MAX_VALUE;
			if (i % 10 != 0 && i1 < i) {
				q2 = q[i1] + 1;
			}
			q[i] = Math.min(q1, q2);
		}
		String load = "src/a-small-attempt0.in";
		String save = "src/a-small-attempt0.out";
		in = new Scanner(new File(load));
		out = new PrintWriter(new File(save));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			out.print("Case #" + t + ": ");
			System.out.println("Case #" + t + ": ............");
			A r = new A();
			int N = A.in.nextInt();
			A.out.println(A.q[N]);
		}
		out.close();
	}

	static Scanner in;
	static PrintWriter out;
}
