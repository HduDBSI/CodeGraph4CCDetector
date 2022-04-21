package googlejam1.p101;


import java.io.*;
import java.util.*;

public class A {

    static final String TYPE = "A";
    static String inputFile;
    static String outputFile;
    static String keyFile;

    public static void main(String[] args) throws FileNotFoundException {

        String root = "data/CJ2015/r1A";

        // Test
        inputFile = "A-large" + ".in";
		outputFile = "A-large" + ".out";
		keyFile = "A-large" + ".key";

        Scanner in = new Scanner(new File(root, inputFile));
        PrintWriter out = new PrintWriter(new File(root, outputFile));

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] m = new int[N];
            for (int j = 0; j < N; j++) {
                m[j] = in.nextInt();
            }

            int res1 = 0;
            int rate = 0;
            for (int j = 1; j < N; j++) {
                if (m[j] < m[j - 1]) {
                    int sub = m[j - 1] - m[j];
                    res1 += sub;
                    if (sub > rate) {
                        rate = sub;
                    }
                }
            }

            int res2 = 0;
            System.out.println(i + 1 + ": " + rate);
            int sum = 0;
            for (int j = 0; j < N - 1; j++) {
                // sum += m[j];
                // if (sum >= rate) {
                // sum = sum - rate;
                // res2 += rate;
                // } else {
                // res2 += sum;
                // sum = 0;
                // }
                if (m[j] > rate) {
                    res2 += rate;
                } else {
                    res2 += m[j];
                }
            }
            out.println("Case #" + (i + 1) + ": " + res1 + " " + res2);

        }

        in.close();
        out.close();

        // check(root);

    }

}