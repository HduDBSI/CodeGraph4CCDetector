package googlejam1.p781;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class mushroommonster {

    static String file = "A-large";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter("/home/dare/Downloads/" + file + ".out", "UTF-8")) {
            Scanner s = new Scanner(new File("/home/dare/Downloads/" + file + ".in"));
            int T = s.nextInt();

            for (int i = 0; i < T; i++) {
                int N = s.nextInt();
                int m[] = new int[N];

                int rate = 0;
                for (int j = 0; j < N; ++j) {
                    m[j] = s.nextInt();

                    if (j > 0) {
                        rate = Math.max(rate, m[j - 1] - m[j]);
                    }
                }

                int y = 0;
                int z = 0;

                for (int j = 1; j < m.length; ++j) {
                    if (m[j - 1] == rate) {
                        z += rate;
                    } else if (m[j - 1] > rate) {
                        z += rate;
                    } else {
                        z += m[j - 1];
                    }
                    
                    if (m[j] < m[j - 1]) {
                        y += m[j - 1] - m[j];
                    }
                }
                writer.println("Case #" + (i + 1) + ": " + y + " " + z);
            }
            writer.close();
        }
    }
}
