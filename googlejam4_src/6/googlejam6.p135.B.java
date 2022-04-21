package googlejam6.p135;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class B {
    public static void main(String[] args) throws Exception {
//        InputStream in = System.in;
        InputStream in = new FileInputStream("/home/floris/Downloads/B-large.in");
        System.setOut(new PrintStream("/home/floris/dev/java/Codejam2016/src/B.out"));
        Scanner sc = new Scanner(in);
        sc.useDelimiter(Pattern.compile("[\n /]"));

        for (int c = 1, cases = sc.nextInt(); c <= cases; c++) {
            int n = sc.nextInt();
            int[] heights = new int[2501];

            for (int i = 0; i < 2*n-1; i++) {
                for (int j = 0; j < n; j++) {
                    heights[sc.nextInt()]++;
                }
            }

            System.out.printf("Case #%d:", c);
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] %2 ==1) System.out.print(" " + i);
            }
            System.out.println("");

        }
    }
}
