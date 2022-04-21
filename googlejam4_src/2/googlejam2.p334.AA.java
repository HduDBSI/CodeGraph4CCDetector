package googlejam2.p334;

import java.util.*;
import java.lang.*;
import java.io.*;

public class AA {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new File("A.in"));
		FileWriter out = new FileWriter("aout.txt");
		
		int T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int n = N;
			int r = 1;
			ArrayList<Integer> a = new ArrayList<Integer>();
			boolean[] b = new boolean[1000001];
			a.add(new Integer(1));
			b[1] = true;
			boolean c = true;
			if (N <= 20) r = N;
			else {
				while (c) {
					r++;
					int l = a.size();
					for (int j = 0; j < l; j++) {
						Integer k = a.remove(0);
						String s1 = k.toString();
						String o = "";
						//if (n.intValue() % 10 > 0)
							for (int i1 = 0; i1 < s1.length();) {
								o = s1.substring(i1, ++i1) + o;
							}
						Integer rev = new Integer(Integer.parseInt(o));
						if (!b[rev.intValue()]) {
							b[rev] = true;
							a.add(rev);
						}
						if (!b[++k]) {
							b[k] = true;
							a.add(k);
						}
						if (rev == N || k == N) {
							c = false;
							break;
						}
					}
				}
			}
			String s = "Case #" + i + ": " + r + "\n";
			System.out.print(s);
			out.write(s);
		}
		in.close();
		out.close();
	}
}
