package googlejam3.p186;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Darya Shauchenka on 5/10/2015.
 */
public class Round1CProblemA {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("A-large.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int w = sc.nextInt();
            int res = 0;
            res += (c / w) * (r - 1);
            res += (c / w - 1);
            res += w + (c % w == 0 ? 0 : 1);
            out.write("Case #" + (t + 1) + ": " + res);
            out.newLine();
        }
        out.close();
    }
}
