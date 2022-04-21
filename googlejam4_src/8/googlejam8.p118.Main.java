package googlejam8.p118;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final String inputPath = "/home/abduqodir/Programming/ideaProjects/Other/functions.in";
    private static final String outputPath = "/home/abduqodir/Programming/ideaProjects/Other/functions.out";
    static int Len;
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter printer = new PrintWriter(new FileOutputStream(outputPath));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            printer.format("Case #%d: ", i + 1);
            int n = scanner.nextInt();
            int p[] = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }
            if (n == 2) {
                for (int j = 0; j < p[0]; j++) {
                    printer.print("AB ");
                }
                printer.println();
                printer.flush();
                continue;
            }
            for (int k = 1000; k > 1; k--) {
                for (int j = 0; j < n; j++) {
                    if (p[j] == k) {
                        printer.print((char) ('A' + j));
                        printer.print(' ');
                        p[j]--;
                    }
                }
            }
            for (int j = 2; j < n; j++) {
                printer.print((char) ('A' + j));
                printer.print(' ');
            }
            printer.print("AB ");
            printer.println();
            printer.flush();
        }
    }
}
