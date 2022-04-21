package googlejam9.p118;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fleeon on 5/8/16.
 */
public class B {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("B.in"));
        PrintWriter writer = new PrintWriter("B.out");
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int B = scanner.nextInt();
            long M = scanner.nextLong();
            long bi[] = new long[B + 1];
            long now = 1, sum = now;
            bi[1] = now;
            for (int b = 2; b < B; b++) {
                now = Math.min(now, M - sum);
                if (now == 0) break;
                bi[b] = now;
                sum += now;
                now *= 2;
            }
            bi[B] = sum;
//            writer.println(Arrays.toString(bi));

            writer.printf("Case #%d: ", t + 1);
            if (bi[B] < M) {
                writer.println("IMPOSSIBLE");
            } else {
                writer.println("POSSIBLE");
                int res[][] = new int[B + 1][B + 1];
                for (int i = 1; i <= B; i++) {
                    sum = bi[i];
                    for (int j = i - 1; j >= 1 && sum > 0; j--) {
                        if (bi[j] == 0 || sum - bi[j] < 0) continue;
                        sum -= bi[j];
                        res[j][i] = 1;
                    }
                }
                for (int i = 1; i <= B; i++) {
                    for (int j = 1; j <= B; j++) {
                        writer.print(res[i][j]);
                    }
                    writer.println();
                }
            }
        }
        writer.close();
    }
}
