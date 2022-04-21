package googlejam6.p078;
import java.io.*;
import java.util.*;

public class B {

	public static void main(String args[]) throws Exception {
		String fn = args.length > 0 ?  args[0] :
		//	"B-.in";
		//	"B-small-attempt1.in";
			"B-large.in";
		LineNumberReader in = new LineNumberReader(new FileReader(fn));
		PrintWriter out = new PrintWriter(new FileWriter(fn.replace(".in", ".out")));
		int T = Integer.parseInt(in.readLine());
		for(int i = 0; i < T; i++) {
			out.print("Case #" + (i+1) + ":");
			final int N = Integer.parseInt(in.readLine());
			ArrayList<Integer> missing = new ArrayList<Integer>();
			for(int l = 2*N-1; --l >= 0; ) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int k = 0; k < N; k++) {
					int s = Integer.parseInt(st.nextToken());
					int n = missing.indexOf(s);
					if(n < 0)
						missing.add(s);
					else
						missing.remove(n);
				}
			}
			Collections.sort(missing);
			for(int k = 0; k < N; k++) {
				out.print(' ');
				out.print(missing.get(k));
			}
			out.println();
			out.flush();
		}
		out.close();
	}
}
