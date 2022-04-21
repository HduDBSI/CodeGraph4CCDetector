package googlejam8.p453;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        in = new Scanner(new FileInputStream("A-large.in"));
        out = System.out;
        out = new PrintStream(new FileOutputStream("A-large.out"));

        final char[] chr = new char[100];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            chr[ch - 'A'] = ch;
        }

        int T = in.nextInt();

        int[] max1and2 = new int[2];

        for (int t = 1; t <= T; t++) {
            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            int N = in.nextInt();
            int[] P = new int[N];
            int total = 0;
            for (int n = 0; n < N; n++) {
                P[n] = in.nextInt();
                total += P[n];
            }

            while (total > 0) {
                int vMax = -1;
				int iMax = -1;
				int vMax21 = -1;
				int iMax21 = -1;
				
				for (int i = 0; i < P.length; i++) {
				    int v = P[i];
				    if (v > vMax) {
				        vMax21 = vMax;
				        iMax21 = iMax;
				
				        vMax = v;
				        iMax = i;
				    } else if (v > vMax21) {
				        vMax21 = v;
				        iMax21 = i;
				    }
				}
				
				max1and2[0] = iMax;
				max1and2[1] = iMax21;
                int iMax1 = max1and2[0];
                int iMax2 = max1and2[1];
                int vMax1 = P[iMax1];
                int vMax2 = iMax2 > -1 ? P[iMax2] : 0;

                if (vMax1 == vMax2) {
                    out.print(chr[iMax1]);
                    P[iMax1]--;
                    total--;

                    if (total > 2 || total == 1) {
                        out.print(chr[iMax2]);
                        P[iMax2]--;
                        total--;
                    }
                } else {
                    out.print(chr[iMax1]);
                    P[iMax1]--;
                    total--;

                    if (total > 2 || total == 1) {
                        out.print(chr[iMax1]);
                        P[iMax1]--;
                        total--;
                    }
                }

                if (total > 0) {
                    out.print(' ');
                }
            }

            out.println();
        }
        out.flush();
    }

}
