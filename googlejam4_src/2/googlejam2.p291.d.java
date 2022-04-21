package googlejam2.p291;

import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(d.class.getResourceAsStream("a.in"));
        System.setOut(new PrintStream("d.txt"));
        //Scanner in = new Scanner(System.in);
        int testcases, testcase = 1;
        testcases = in.nextInt();
        int N = 1000002;
        int[] dp = new int[N];
        Arrays.fill(dp, 1 << 28);
        dp[1] = 1;
        for(int i = 2; i < N; i++) {
            StringBuilder sb = new StringBuilder();
			sb.append(i);
			sb.reverse();
			int rev = Integer.valueOf(sb.toString());
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            if(rev < N)
                dp[rev] = Math.min(dp[rev], dp[i - 1] + 2);
        }
        //System.out.println(Arrays.toString(dp));
        while(testcase <= testcases) {
            int n = in.nextInt();
            System.out.println("Case #" + testcase + ": " + dp[n]);
            testcase++;
        }
    }
}
