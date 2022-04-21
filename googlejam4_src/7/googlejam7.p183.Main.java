package googlejam7.p183;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("B-small-attempt0.in"));
        //Scanner in = new Scanner(new File("B-small.in"));
        PrintWriter out = new PrintWriter("out.txt");
        int t = in.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            String q = in.next();
            int len = q.length();
            String c = "00" + q;
            String j = "00" + in.next();
            c = c.substring(c.length() - 3);
            j = j.substring(j.length() - 3);
			int cRes = (c.charAt(0) == '?' ? 0 : (int)c.charAt(0) - (int)'0') * 100 +
			        (c.charAt(1) == '?' ? 0 : (int)c.charAt(1) - (int)'0') * 10 +
			        (c.charAt(2) == '?' ? 0 : (int)c.charAt(2) - (int)'0');
			int jRes = (j.charAt(0) == '?' ? 0 : (int)j.charAt(0) - (int)'0') * 100 +
			        (j.charAt(1) == '?' ? 0 : (int)j.charAt(1) - (int)'0') * 10 +
			        (j.charAt(2) == '?' ? 0 : (int)j.charAt(2) - (int)'0');
			int[] m = new int[6];
			for (int i = 0; i < c.length(); i++) {
			    if (c.charAt(i) == '?') {
			        m[i] = 9;
			    }
			}
			for (int i = 0; i < j.length(); i++) {
			    if (j.charAt(i) == '?') {
			        m[i + 3] = 9;
			    }
			}
			for (int c1 = 0; c1 <= m[0]; c1++) {
			    for (int c2 = 0; c2 <= m[1]; c2++) {
			        for (int c3 = 0; c3 <= m[2]; c3++) {
			            for (int j1 = 0; j1 <= m[3]; j1++) {
			                for (int j2 = 0; j2 <= m[4]; j2++) {
			                    for (int j3 = 0; j3 <= m[5]; j3++) {
			                        int curC = (c.charAt(0) == '?' ? c1 : (int)c.charAt(0) - (int)'0') * 100 +
			                                (c.charAt(1) == '?' ? c2 : (int)c.charAt(1) - (int)'0') * 10 +
			                                (c.charAt(2) == '?' ? c3 : (int)c.charAt(2) - (int)'0');
			                        int curJ = (j.charAt(0) == '?' ? j1 : (int)j.charAt(0) - (int)'0') * 100 +
			                                (j.charAt(1) == '?' ? j2 : (int)j.charAt(1) - (int)'0') * 10 +
			                                (j.charAt(2) == '?' ? j3 : (int)j.charAt(2) - (int)'0');
			                        if (Math.abs(curC - curJ) < Math.abs(cRes - jRes) ||
			                                (Math.abs(curC - curJ) == Math.abs(cRes - jRes) &&
			                                        (curC < cRes || (curC == cRes && curJ < jRes)))) {
			                            cRes = curC;
			                            jRes = curJ;
			                        }
			                    }
			                }
			            }
			        }
			    }
			}
			String cS = "00" + Integer.toString(cRes);
			String jS = "00" + Integer.toString(jRes);
            String res = cS.substring(cS.length() - len) + " " + jS.substring(jS.length() - len);
            out.println("Case #" + cases + ": " + res);
        }
        out.close();
    }
}