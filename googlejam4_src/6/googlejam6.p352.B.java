package googlejam6.p352;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        PrintWriter writer = new PrintWriter("outputB.txt", "UTF-8");
       
        for (int k = 1; k <= T; k++) {   
            int[] heights = new int[2501];
             int N = scan.nextInt();
            for (int i = 0; i < 2 * N - 1; i++) {
                for (int j = 0; j < N; j++) {
                    int currNum = scan.nextInt();
                    heights[currNum]++;
                }
            }
            int c = 0;
            int[] missed = new int[N];
            for (int i = 1; i < 2501; i++) {
                if (heights[i] % 2 == 1) {
                    missed[c] = i;
                    c++;
                }
            }
            Arrays.sort(missed);
            writer.print("Case #" + k + ": ");
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    writer.print(missed[i]);
                } else {
                    writer.print(missed[i] + " ");
                }
            }
            writer.println();
        }
        writer.close();
    }
}