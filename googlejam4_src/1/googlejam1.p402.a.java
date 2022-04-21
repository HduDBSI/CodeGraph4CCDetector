package googlejam1.p402;



import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(a.class.getResourceAsStream("a-l.in"));
        System.setOut(new PrintStream("a-l.txt"));
        //Scanner in = new Scanner(System.in);
        int testcases, testcase = 1;
        testcases = in.nextInt();
        while (testcase <= testcases) {
            int ans1 = 0, ans2 = 0;
            double rate = 0.0;
            int n = in.nextInt();
            int[] m = new int[n];
            for(int i = 0; i < n; i++) {
                m[i] = in.nextInt();
            }
            for(int i = 1; i < n; i++) {
                if(m[i - 1] > m[i]) {
                    ans1 += (m[i - 1] - m[i]);
                    rate = Math.max(rate, (m[i - 1] - m[i]) / 10.0);
                }
            }
            if(rate != 0) {
                int eat = (int)(rate * 10);
                for(int i = 0; i < n - 1; i++) {
                    if(eat >= m[i]) {
                        ans2 += m[i];
                    } else {
                        ans2 += eat;
                    }
                }
            }
            
            System.out.println("Case #" + testcase + ": " + ans1 + " " + ans2);
            testcase++;
        }
    }

}
