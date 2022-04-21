package googlejam1.p545;
import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
                        System.in
                        )));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] m = new int[N];
            for (int i = 0; i < N; i++) {
                m[i] = sc.nextInt();
            }

            int rate = 0;
            for (int i = 1; i < N; i++) {
                int diff = m[i-1] - m[i];
                if (diff > rate) {
                    rate = diff;
                }
            }

            int c1 = 0, c2 = (m[0] < rate) ? m[0] : rate;

            for (int i = 1; i < N; i++) {
                if (m[i] < m[i-1]) {
                    c1 += m[i-1] - m[i];
                }
                if (i < N - 1) c2 += (m[i] < rate) ? m[i] : rate;
            }

            System.out.printf("Case #%d: %d %d\n", t, c1, c2);
        }
    }
}
