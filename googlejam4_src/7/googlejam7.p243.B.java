package googlejam7.p243;
import java.util.*;
import java.io.*;

public class B
{
	public static void main(String[] args) throws Exception
	{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("B-small-attempt0.in"));
		PrintStream out = new PrintStream(new File("B-small-attempt0.out"));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) 
		{
			String ccs = in.next();
			String jjs = in.next();
			
			char[] c = ccs.toCharArray();
			char[] j = jjs.toCharArray();

			int cnt = 0;
			ArrayList<Integer> cs = new ArrayList<Integer>();
			ArrayList<Integer> js = new ArrayList<Integer>();

			for (int k = 0; k < 1000; k++) {
				int cur = k;
				boolean ok = true;
				for (int kk = c.length-1; kk >= 0; kk--) {
					if (cur%10 + '0' != c[kk] && c[kk] != '?') {
						ok = false;
					}
					cur /= 10;
				}
				if (ok && cur == 0) {
					cs.add(k);
				}

				cur = k;
				ok = true;
				for (int kk = j.length-1; kk >= 0; kk--) {
					if (cur%10 + '0' != j[kk] && j[kk] != '?') {
						ok = false;
					}
					cur /= 10;
				}
				if (ok && cur == 0) {
					js.add(k);
				}
			}

			int min = Integer.MAX_VALUE;
			int cc = 0, jj = 0;
			for (int k = 0; k < cs.size(); k++) {
				for (int kk = 0; kk < js.size(); kk++) {
					if (Math.abs(cs.get(k)-js.get(kk)) < min) {
						min = Math.abs(cs.get(k)-js.get(kk));
						cc = cs.get(k);
						jj = js.get(kk);
					}
				}
			}

			String format = "Case #%d: %0" + c.length + "d %0"+c.length+"d\n";
			out.printf(format, i, cc, jj);
		}
	}
}