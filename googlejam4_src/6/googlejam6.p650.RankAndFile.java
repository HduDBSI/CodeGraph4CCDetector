package googlejam6.p650;
import java.lang.*;
import java.io.*;
import java.util.*;

public class RankAndFile {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/xiangyixie/Documents/eclipse_workspace/2016CodeJamRound1A/bin/B-large.in"));
            FileWriter writer = new FileWriter(new File("/Users/xiangyixie/Documents/eclipse_workspace/2016CodeJamRound1A/bin/B-large-output.out"));
 
            // Scanner scanner = new Scanner(new File("input.txt"));
            // FileWriter writer = new FileWriter(new File("output.txt"));

            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();

                int[] count = new int[3000];
                for (int j = 0; j < count.length; j++) {
                    count[j] = 0;
                }

                for (int j = 0; j < N * (2 * N - 1); j++) {
                    count[scanner.nextInt()]++;
                }

                int[] array = new int[N];
                int cur = 0;
                for (int j = 0; j<count.length; j++) {
                    if (count[j] % 2 != 0) {
                        System.out.println(j);
                        array[cur++] = j;
                    }
                }
                Arrays.sort(array, 0, N);
                writer.write("Case #" + (i+1) + ":");
                for (int j = 0; j < N; j++) {
                    writer.write(" " + array[j]);
                }
                writer.write("\n");
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
