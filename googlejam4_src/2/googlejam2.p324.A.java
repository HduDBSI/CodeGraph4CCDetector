package googlejam2.p324;
import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
                        System.in
                        )));
        StringBuilder builder;
        long dp[] = new long[1000005];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 20; i++) {
            dp[i] = i;
        }

        for (int i = 20; i < dp.length; i++) {
            int iLength = Integer.toString(i).length();
            builder = new StringBuilder();
            builder.append(i);
            int rev = Integer.parseInt(builder.reverse().toString());
            int revLength = Integer.toString(rev).length();
            if (rev < dp.length && rev < i && iLength == revLength) {
                dp[i] = Math.min(dp[i-1], dp[rev]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            System.out.printf("Case #%d: %d\n", t, dp[N]);
        }
    }
}
