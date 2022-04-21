package googlejam8.p114;
import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class A {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(br.readLine());
        for (int z=0;z<T;z++) {
            int N = parseInt(br.readLine());
            int[] P = new int[N];
            String[] ss = br.readLine().trim().split("\\s+");

            for(int i=0;i<N;i++) P[i] = parseInt(ss[i]);
            int first = 0;
            int second = -1;
            for(int i=1;i<N;i++) {
                if (P[first] < P[i]) {
                    first = i;
                }
            }
            for (int i=0;i<N;i++) {
                if (first == i) continue;
                if (second == -1 || P[second] < P[i]) {
                    second = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            while(P[first] > P[second]) {
                if (P[first] == P[second] + 1) {
                    sb.append((char)(first + 'A'));
                    sb.append(" ");
                    P[first]--;
                } else {
                    sb.append((char)(first + 'A'));
                    sb.append((char)(first + 'A'));
                    sb.append(" ");
                    P[first] -= 2;
                }
            }
            // out.println(">> " + first + " " + second + " " + Arrays.toString(P));
            for (int i=0;i<N;i++) {
                if (i == first || i == second) continue;
                while(P[i] > 0) {
                    if (P[i] >= 2) {
                        sb.append((char)(i + 'A'));
                        sb.append((char)(i + 'A'));
                        sb.append(" ");
                        P[i] -= 2;
                    } else {
                        sb.append((char)(i + 'A'));
                        sb.append(" ");
                        P[i]--;
                    }
                }
            }
            while(P[first] > 0) {
                sb.append((char)(first + 'A'));
                sb.append((char)(second + 'A'));
                sb.append(" ");
                P[first]--;
                P[second]--;
            }
            out.println("Case #"+(z+1)+": " + sb.toString().trim());
        }
    }
}
