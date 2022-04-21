package googlejam1.p114;
import java.util.Scanner;

/**
 * Created by poly on 4/18/15.
 */
public class MashroomMonster {
    public static void main(String argv[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] m = new int[n];
            for (int i = 0; i < n; i++) {
                m[i] = scanner.nextInt();
            }
            int res1 = 0;
            int res2 = 0;
            int maxd = 0;
            for (int i = 0; i < n - 1; i++) {
                int d = m[i] - m[i + 1];
                if (d > 0) {
                    res1 += d;
                }
                maxd = Math.max(maxd, d);
            }
            for (int i = 0; i < n - 1; i++) {
                res2 += Math.min(m[i], maxd);
            }
            System.out.println("Case #" + (t + 1) + ": " + res1 + " " + res2);
        }
    }
}
