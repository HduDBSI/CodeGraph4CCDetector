package googlejam2.p186;
import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.System.*;

class A {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = 1000000;
        LinkedList<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> r = new LinkedList<Integer>();
        q.add(1);
        r.add(1);
        HashSet<Integer> set = new HashSet<Integer>();
        int[] len = new int[N+1];
        while(!q.isEmpty()) {
            int x = q.pollFirst();
            int t = r.pollFirst();
            if (x > N) continue;
            if (set.contains(x)) continue;
            set.add(x);
            len[x] = t;
            q.add(x+1);
            r.add(t+1);
            int v = 0;
            while(x > 0) {
                v *= 10;
                v += x % 10;
                x /= 10;
            }
            q.add(v);
            r.add(t+1);
        }

        int T = parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int x = parseInt(br.readLine());
            out.println("Case #" + (i+1) + ": " + len[x]);
        }
    }
}
