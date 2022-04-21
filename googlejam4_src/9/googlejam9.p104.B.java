package googlejam9.p104;
import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class B {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(br.readLine());
        for (int z=0;z<T;z++) {
            String[] ss = br.readLine().trim().split("\\s+");
            int B = parseInt(ss[0]);
            Long M = Long.parseLong(ss[1]);

            long x = 1L << (B-2);
            if (M > x) {
                out.println("Case #" + (z+1) + ": IMPOSSIBLE");
                continue;
            } 
            boolean[][] mat = new boolean[B][B];
            for(int i=1;i<B;i++) {
                for(int j=i+1;j<B;j++) {
                    mat[i][j] = true;
                }
            }
            if (M == x) {
                for(int j=1;j<B;j++) {
                    mat[0][j] = true;
                }
            } else {
                int u = B-2;
                while (M > 0) {
                    if ((M&1) == 1) {
                        mat[0][u] = true;
                    }
                    u--;
                    M >>= 1;
                }
            }
            out.println("Case #" + (z+1) + ": POSSIBLE");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<B;i++) {
                for(int j=0;j<B;j++) {
                    sb.append(mat[i][j] ? 1 : 0);
                }
                sb.append("\n");
            }
            out.print(sb);
        }
    }
}
