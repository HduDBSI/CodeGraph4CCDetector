package googlejam9.p071;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by pallavi on 8/5/16.
 */
public class Slides {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("in.txt")));
        PrintWriter writer = new PrintWriter("out.txt");
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int b = scanner.nextInt();
            long m = scanner.nextLong();
            writer.print("Case #" + i + ": ");
            if (m > Math.pow(2, b-2)) {
                writer.println("IMPOSSIBLE");
                continue;
            }
            writer.println("POSSIBLE");
            int[][] s = new int[b][b];
            for (int j = 1; j < b; j++) {
                for (int k = j+1; k < b; k++) {
                    s[j][k] = 1;
                }
            }
            if (m == Math.pow(2, b-2)) {
                s[0][b-1] = 1;
                m--;
            }
            for (int j = 1; j < b-1; j++) {
                if ((m&(long)Math.pow(2, b-2-j)) != 0) {
                    s[0][j] = 1;
                }
            }
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < b; k++) {
                    writer.print(s[j][k]);
                }
                writer.println();
            }
        }
        writer.close();
        scanner.close();
    }
}
