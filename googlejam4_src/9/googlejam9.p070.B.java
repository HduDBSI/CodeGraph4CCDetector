package googlejam9.p070;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Lich on 2016/5/1.
 */
public class B {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("round1C_B.in"));
             PrintWriter writer = new PrintWriter(new File("round1C_B.out"))) {

            int caseCount = scanner.nextInt();
            for (int caseNo = 1; caseNo <= caseCount; ++caseNo) {
                long b = scanner.nextInt();
                long m = scanner.nextLong();
                if ((1L << (b - 2)) < m) {
                    writer.println(String.format("Case #%d: IMPOSSIBLE", caseNo));
                    continue;
                }
                writer.println(String.format("Case #%d: POSSIBLE", caseNo));
                boolean x[] = new boolean[(int) b];
                Arrays.fill(x, false);
                for (int i = 2; i < b; ++i) {
                    if (((1L << (i - 2)) & (m - 1)) > 0) {
                        x[i] = true;
                    }
                }

                writer.print(0);
                for (int j = 2; j <= b; j++)
                    writer.print(1);
                writer.println();

                for (int i = 2; i < b; ++i) {
                    for (int j = 1; j <= i; ++j)
                        writer.print(0);
                    for (int j = i + 1; j < b; ++j)
                        writer.print(1);
                    writer.println(x[i] ? 1 : 0);
                }

                for (int j = 1; j <= b; j++)
                    writer.print(0);
                writer.println();

            }

        }
    }

}
