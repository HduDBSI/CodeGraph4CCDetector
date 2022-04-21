package googlejam9.p120;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            long m = in.nextLong();
            boolean[][] b = new boolean[n][n];
            long[] sum = new long[n];
            sum[0] = 1;
            b[0][n - 1] = true;
            --m;
            int cur = 1;
            while (m > 0 && cur < n - 1) {
                b[cur][n - 1] = true;
                b[0][cur] = true;
                --m;
                sum[cur]++;
                for (int prev = cur - 1; prev > 0; --prev) {
                    if (m >= sum[prev]) {
                        b[prev][cur] = true;
                        m -= sum[prev];
                        sum[cur] += sum[prev];
                    }
                }
                ++cur;
            }

            if (m > 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        System.out.print(b[i][j] ? 1 : 0);
                    }
                    System.out.println();
                }
            }
        }
    }
}
