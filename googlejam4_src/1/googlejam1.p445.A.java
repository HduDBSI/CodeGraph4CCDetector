package googlejam1.p445;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter(new FileOutputStream("A.out"));
        Scanner scanner = new Scanner(new FileInputStream("A.in"));
        //PrintWriter writer = new PrintWriter(System.out);
        //Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[] m = new int[N];
            for (int i = 0; i < N; i++) {
                m[i] = scanner.nextInt();
            }
            int s1 = 0;
            int maxDiff = 0;
            for (int i = 1; i < N; i++) {
                if (m[i-1] > m[i]) {
                    int diff = m[i-1] - m[i];
                    s1 += diff;
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                }
            }
            int s2 = 0;
            for (int i = 0; i < N-1; i++) {
                if (m[i] < maxDiff) {
                    s2 += m[i];
                } else {
                    s2 += maxDiff;
                }
            }
            writer.println(String.format("Case #%d: %d %s", t, s1, s2));
        }
        scanner.close();
        writer.close();
    }
}
