package googlejam3.p308;
import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(args[1], "UTF-8");

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			out.print("Case #"+t+": ");			

			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			if (W == C)
				out.println(W+R-1);
			else if (C < 2*W)
				out.println(R+W);
			else if (C == 2*W)
				out.println(2*R-1+W);
			else {
				int rem = C%W;
				if (rem == 0) {
					out.println((C*R)/W-1+W);
				}
				else {
					out.println((C/W)*R+W);
				}
			}
		}

		out.flush();
		out.close();

		System.exit(0);
	}
}				
		
