package googlejam6.p066;
/**
 * Created by qixinzhu on 4/8/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws FileNotFoundException{
        // test case
//        genLargeP();
//        File inputFile = new File("test.txt");
//        PrintWriter out = new PrintWriter("test_out.txt");

        // real case
        File inputFile = new File("B-large.in");
//        File inputFile = new File("B-small-attempt0.in");
        PrintWriter out = new PrintWriter("B_out_b.txt");

        Scanner in = new Scanner(inputFile);

        int T = in.nextInt();
        int N;
        for (int i=0;i<T;i++) {
            N= in.nextInt();
            int[] nums = new int[2501];
            int cur;
            for (int j=0;j<2*N-1;j++) {
                for (int k=0;k<N;k++) {
                    cur = in.nextInt();
                    nums[cur]++;
                }
            }
            String ans = "";
            for (int m=0;m<2501;m++) {
                if (nums[m] % 2 != 0) {
                    ans += m;
                    ans += " ";
                }
            }
            out.printf("Case #%d: %s\n", i + 1, ans.trim());
        }

        in.close();
        out.close();
    }
}
