package googlejam3.p023;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * User: hamilkar
 * Date: 10.05.15
 * Time: 12:19
 */
public class A {
    private static Scanner scanner;
    private static PrintWriter writer;

    static {
        try {
            scanner = new Scanner(new File("input.txt"));
            writer = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int w = scanner.nextInt();

            int res = c / w * (r - 1);

            res += c / w;
            if (c % w == 0) {
                res += w - 1;
            } else {
                res += w;
            }

            writer.println("Case #" + t + ": " + res);
        }

        writer.close();
    }
}
