package googlejam11.p101;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            double[] p = new double[N];
            for (int i = 0; i < N; i++) {
                p[i] = sc.nextDouble();
            }

            double best = 0;
            for (long mask = 0; mask < (1 << N); mask++) {
                if (Long.bitCount(mask) != K) {
                    continue;
                }
                double total = 0;
                for (long yesMask = mask; yesMask != 0; yesMask = ((yesMask - 1) & mask)) {
                    if (Long.bitCount(yesMask) != K / 2) {
                        continue;
                    }
                    double prob = 1;
                    for (int i = 0; i < N; i++) {
                        if ((yesMask & (1 << i)) != 0) {
                            prob *= p[i];
                        } else if ((mask & (1 << i)) != 0) {
                            prob *= (1 - p[i]);
                        }
                    }
                    total += prob;
                }
                best = Math.max(total, best);
            }
            System.out.print("Case #" + caseNum + ": ");
            System.out.println(best);
        }
        sc.close();
    }
}
