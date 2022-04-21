package googlejam3.p467;
import java.util.*;
import java.io.*;

public class A {

	/*************************************************************************/

	public static void main(String[] args) throws Exception {
		String load = "src/a-small-attempt1.in";
		String save = "src/a-small-attempt1.out";
		in = new Scanner(new File(load));
		out = new PrintWriter(new File(save));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			out.print("Case #" + t + ": ");
			System.out.println("Case #" + t + ": ............");
			A r = new A();
			int R = A.in.nextInt();
			int C = A.in.nextInt();
			int W = A.in.nextInt();
			if (R == 1) {
				int result = (C-W)/W + W + (C%W>0?1:0);
				A.out.println(result);
			} else
				A.out.println(0);
		}
		out.close();
	}

	static Scanner in;
	static PrintWriter out;
}
