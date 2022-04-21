package googlejam11.p140;
/**
 * Created by qixinzhu on 4/8/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {


    public static void main(String[] args) throws FileNotFoundException {
        // test case
//        genLargeP();
//        File inputFile = new File("test.txt");
//        PrintWriter out = new PrintWriter("test_out.txt");

        // real case
//        File inputFile = new File("B-small-practice.in");

        File inputFile = new File("B-small-attempt0.in");
        PrintWriter out = new PrintWriter("B-small-out.txt");

//        File inputFile = new File("B-large-practice.in");

//        File inputFile = new File("B-large.in");
//        PrintWriter out = new PrintWriter("B-large-out.txt");

        Scanner in = new Scanner(inputFile);

        long time0 = System.currentTimeMillis();

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            double[] P = new double[N];
            for (int n = 0; n < N; n++) {
                P[n] = in.nextDouble();
            }

            double maxProb = 0;

            for (int i = 0; i < (1 << N); i++) {
                int k = 0;
                for (int n = 0; n < N; n++) {
                    if ((i & 1 << n) != 0) {
                        k++;
                    }
                }
                if (k != K) continue;
                double[] p = new double[K];
                int loc = 0;
                for (int n = 0; n < N; n++) {
                    if ((i & 1 << n) != 0) {
                        p[loc] = P[n];
                        loc++;
                    }
                }

                double curProb = 0;
                for (int j = 0; j < (1 << K); j++) {
                    int yes = 0;
                    for (k = 0; k < K; k++) {
                        if ((j & 1 << k) != 0) {
                            yes++;
                        }
                    }
                    if (yes != K/2) continue;
                    double temp = 1;
                    for (k = 0; k < K; k++) {
                        if ((j & 1 << k) != 0) {
                            temp *= p[k];
                        } else {
                            temp *= (1-p[k]);
                        }
                    }
                    curProb += temp;
                }
                if (curProb > maxProb) maxProb = curProb;
            }

            out.printf("Case #%d: %f\n", t + 1, maxProb);     //// -----
        }

        long time1 = System.currentTimeMillis();
        System.out.printf("[%dms] Nodes created.\n", time1 - time0);

        in.close();
        out.close();
    }
}
