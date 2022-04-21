package googlejam1.p103;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class A {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(new File("A_large.in")));
        System.setOut(new PrintStream(new FileOutputStream(new File("A_large.out"))));
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t<=T;t++) {
            int N = in.nextInt();
            int[] m = new int[N];
            for (int i = 0; i < N; i++ ) {
                m[i] = in.nextInt();
            }

            int ans1 = 0;
            int largestDecrease = 0;
            for (int i = 0; i< N-1; i++ ) {
                int dec =Math.max(0, m[i]-m[i+1]);
                ans1 += dec;
                largestDecrease = Math.max(largestDecrease, dec);
            }

            int ans2 = 0;
            for (int i = 0; i < N-1; i++) {
                ans2 += Math.min(m[i], largestDecrease);
            }

            System.out.printf("Case #%d: %d %d", t, ans1, ans2);
            System.out.println();

        }
    }
}
