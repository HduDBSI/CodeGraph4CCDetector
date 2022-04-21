package googlejam8.p080;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Lich on 2016/5/1.
 */
public class A {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("round1C_A.in"));
             PrintWriter writer = new PrintWriter(new File("round1C_A.out"))) {

            int caseCount = scanner.nextInt();
            for (int caseNo = 1; caseNo <= caseCount; ++caseNo) {
                int n = scanner.nextInt();
                int[] x = new int[n];
                int sum = 0;
                for (int i = 0; i < n; ++i) {
                    x[i] = scanner.nextInt();
                    sum += x[i];
                }

                writer.print(String.format("Case #%d: ", caseNo));
                if (sum % 2 == 1) {
                    int max = 0, index = 0;
                    for (int i = 0; i < n; ++i) {
                        if (x[i] > max) {
                            max = x[i];
                            index = i;
                        }
                    }
                    writer.print((char)('A' + index));
                    writer.print(" ");
                    x[index]--;
                }
                while (true) {
                    int max = 0, index = 0;
                    for (int i = 0; i < n; ++i) {
                        if (x[i] > max) {
                            max = x[i];
                            index = i;
                        }
                    }
                    if (max == 0)
                        break;
                    writer.print((char)('A' + index));
                    x[index]--;
                    max = 0;
                    index = 0;
                    for (int i = 0; i < n; ++i) {
                        if (x[i] > max) {
                            max = x[i];
                            index = i;
                        }
                    }
                    if (max == 0)
                        break;
                    writer.print((char)('A' + index));
                    x[index]--;
                    writer.print(" ");
                }
                writer.println();

            }

        }
    }

}
