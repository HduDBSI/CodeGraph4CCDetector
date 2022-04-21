package googlejam11.p034;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class RedTapeCommittee1 {


    static int n, k;
    static double[] p;
    static double[] cand;
    static double[][] f;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner cin = new Scanner(new File("B-small-attempt0.in"));
//        PrintStream cout = new PrintStream("B-small-attempt-mine.out");
        Scanner cin = new Scanner(new File("B-large.in"));
        PrintStream cout = new PrintStream("B-large.out");
//        Scanner cin = new Scanner(System.in);
//        PrintStream cout = System.out;

        int _case = 0;

        for (int T = cin.nextInt(); T > 0; T--) {
            _case++;
            StringBuilder ans = new StringBuilder();

            n = cin.nextInt();
            k = cin.nextInt();
            p = new double[n];
            cand = new double[k];
            double max = 0;
            for (int i = 0; i < n; i++) p[i] = cin.nextDouble();
            Arrays.sort(p);

            for (int x = 0; x <= k; x++) {
                int ptr = 0;
                for (int j = 0; j < x; j++) cand[ptr++] = p[j];
                for (int j = n - 1; j >= n + x - k; j--) cand[ptr++] = p[j];

                f = new double[k][k + 1];
                f[0][0] = 1 - cand[0];
                f[0][1] = cand[0];
                for (int i = 1; i < k; i++)
                    for (int j = 0; j <= k; j++) {
                        f[i][j] = (1 - cand[i]) * f[i - 1][j]; // vote for "NO"
                        if (j > 0) f[i][j] += cand[i] * f[i - 1][j - 1]; // vote for "YES"
                    }
                max = Math.max(max, f[k - 1][k / 2]);
            }
            ans.append(String.format("%.10f", max));

            cout.printf("Case #%d: %s%n", _case, ans.toString());
        }

        cin.close();
        cout.close();
    }
}
