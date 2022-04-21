package googlejam3.p385;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class A {
    private static final String inFile = "A-small-attempt0 (1).in";
    private static final String outFile = "A-out.txt";

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inFile));
        int T = scanner.nextInt();
        FileWriter fw = new FileWriter(outFile);

        for (int t = 1; t <= T; ++t) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int w = scanner.nextInt();
            fw.write(String.format("Case #%d: %s\n", t, solve(r, c, w)));
        }
        fw.close();
    }

    private static int solve(int r, int c, int w) {
        int res = ((c - 1) / w + 1) * (r - 1) + w + (c - 1) / w;
        return res;
    }
}
