package googlejam9.p027;
import org.psjava.util.FromTo;
import org.psjava.util.ZeroTo;

import java.io.*;
import java.util.Scanner;

public class B implements Runnable {

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        for (int casei : ZeroTo.get(in.nextInt())) {
            int n = in.nextInt();
            long m = in.nextLong();
            long max = 1L << (long) (n - 2);
//            System.out.println(max);

            System.out.print("Case #" + (casei + 1) + ": ");
            if (m <= max) {
                System.out.println("POSSIBLE");
                for (int i : ZeroTo.get(n)) {
                    boolean[] row = new boolean[n];
                    if (i < n - 1) {
                        row[i + 1] = true;
                        long coverEnd = 1L << (long) (n - i - 2);
                        long coverStart = Math.max(1, coverEnd / 2);
//                        System.out.println(i + " " + coverStart + " " + coverEnd);
                        if (coverStart < m && m < coverEnd) {
                            long remain = m - coverStart;
                            long factor = coverStart / 2;
//                            System.out.println("factor " + factor);
                            for (int j : FromTo.get(i + 2, n)) {
                                if (remain >= factor) {
                                    row[j] = true;
                                    remain -= factor;
                                }
                                factor = Math.max(1, factor / 2);
                            }
                        } else if (m >= coverEnd) {
                            for (int j : FromTo.get(i + 2, n))
                                row[j] = true;
                        }
                    }
                    for (boolean v : row)
                        System.out.print(v ? 1 : 0);
                    System.out.println();
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream("/Users/imyoyo/Desktop/B-large.in")));
        System.setOut(new PrintStream(new OutputStream() {
		    @Override
		    public void write(int b) throws IOException {
		        System.out.write(b);
		        new PrintStream("/Users/imyoyo/kb/mavens/solutions/src/main/java/output.txt").write(b);
		    }
		}));
        new B().run();
    }

}
