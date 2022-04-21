package googlejam6.p583;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] lists = new int[2 * n - 1][n];
            int[][] result = new int[n][n];

            Map<Integer, Integer> amounts = new HashMap<Integer, Integer>();
            for (int j = 0; j < 2 * n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    int v = in.nextInt();
                    lists[j][k] = v;
                    if (amounts.containsKey(v)) {
                        amounts.put(v, amounts.get(v) + 1);
                    } else {
                        amounts.put(v, 1);
                    }

                }
            }

            int j = 0;
            int[] missingRow = new int[n];
            for (Integer v : amounts.keySet()) {
                if (amounts.get(v) % 2 == 1) {
                    missingRow[j++] = v;
                }
            }
            Arrays.sort(missingRow);
            System.out.print("Case #" + i + ": ");
            for (j = 0; j < n; j++) {
                System.out.print(missingRow[j] + " ");
            }
            System.out.println();
        }
    }
}
