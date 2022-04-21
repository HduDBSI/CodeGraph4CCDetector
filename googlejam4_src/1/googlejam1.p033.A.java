package googlejam1.p033;


import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int cs = 1 ; cs <= t ; cs++) {
            int n = in.nextInt();
            int[] m = new int[n];
            for (int i = 0; i < n ; i++) {
                m[i] = in.nextInt();
            }
			int[] ways = new int[2];
			int n1 = m.length;
			
			for (int i = 0 ; i < n1-1 ; i++) {
			    if (m[i] > m[i+1]) {
			        ways[0] += m[i] - m[i+1];
			    }
			}
			
			int maxrate = 0;
			for (int i = 0 ; i < n1-1 ; i++) {
			    if (m[i] > m[i+1]) {
			        maxrate = Math.max(maxrate, m[i]-m[i+1]);
			    }
			}
			for (int i = 0 ; i < n1-1 ; i++) {
			    ways[1] += Math.min(maxrate, m[i]);
			}
            int[] ret = ways;
            out.println(String.format("Case #%d: %d %d", cs, ret[0], ret[1]));
        }
        out.flush();
    }
}



