package googlejam9.p108;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final String inputPath = "/home/abduqodir/Programming/ideaProjects/Other/functions.in";
    private static final String outputPath = "/home/abduqodir/Programming/ideaProjects/Other/functions.out";

    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter printer = new PrintWriter(new FileOutputStream(outputPath));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            printer.format("Case #%d: ", i + 1);
            int b = scanner.nextInt();
            long m = scanner.nextLong();
            int[][] map = new int[b][b];
            for (int j = 1; j < b; j++) {
                for (int k = j + 1; k < b; k++) {
                    map[j][k] = 1;
                }
            }
            map[0][b - 1] = 1;
            m--;
            long bin = 1;
            for (int j = 2; j < b - 1; j++) {
                bin *= 2;
            }
            for (int j = 1; j < b - 1; j++) {
                if (m >= bin) {
                    map[0][j] = 1;
                    m -= bin;
                }
                bin /= 2;
            }
            if (m == 0) {
                printer.println("POSSIBLE");
                for (int j = 0; j < b; j++) {
                    for (int k = 0; k < b; k++) {
                        printer.print(map[j][k]);
                    }
                    printer.println();
                }
            } else {
                printer.print("IMPOSSIBLE");
                printer.println();
            }
            printer.flush();
        }
    }
}
