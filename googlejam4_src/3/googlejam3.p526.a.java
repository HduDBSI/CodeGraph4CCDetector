package googlejam3.p526;

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
        Scanner in = new Scanner(a.class.getResourceAsStream("a-in.txt"));
        System.setOut(new PrintStream("src/a-out.txt"));
       
        //Scanner in = new Scanner(System.in);
        int testcases, testcase = 1;
        testcases = in.nextInt();
        while(testcase <= testcases) {
            int r = in.nextInt(), c = in.nextInt(), w = in.nextInt();
            int ans = (r - 1) * ((c - 1) / w + 1);
            if(c > 2 * w - 1) {
                ans += ((c - 1) / w + w);
            } else if(c > w) {
                ans += (w + 1);
            } else {
                ans += w;
            }
            //System.out.println(r + " " + c + " " + w);
            System.out.println("Case #" + testcase + ": " + ans);
            testcase++;
        }
    }

}
