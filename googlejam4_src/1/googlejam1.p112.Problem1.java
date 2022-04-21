package googlejam1.p112;
import java.io.*;
import java.util.Scanner;

/**
 * Created by ankurgupta on 4/11/15.
 */
public class Problem1 {
    
    public static void main(String[] argv) throws IOException {
        Scanner in = new Scanner(new FileReader("/Users/ankurgupta/Desktop/codeJam/A-large.in"));
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/ankurgupta/Desktop/codeJam/A-large.out"), "utf-8"));
        int T = in.nextInt();
        int cases = 0;
        while (T-- > 0) {
            int N = in.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            long ans1 = 0;
            long maxDiff = Long.MIN_VALUE;
            for (int i = 0; i < N - 1; i++) {
                long temp = Math.max(0, arr[i] - arr[i + 1]);
                ans1 += temp;
                maxDiff = Math.max(maxDiff, temp);
            }
            long ans2 = 0;
            long cur = 0;
            for (int i = 0; i < N - 1; i++) {
                cur = Math.max(0, arr[i] - maxDiff);
                ans2 += Math.max(0, arr[i] - cur);
            }
            writer.write("Case #" + ++cases + ": " + ans1 + " " + ans2 + "\n");
        }
        writer.close();
    }

}
