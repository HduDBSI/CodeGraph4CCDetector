package googlejam6.p636;
import java.util.*;
import java.io.*;

public class RankAndFile {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] data = new int[2*N - 1][N];
            int[] map = new int[2501];
            for (int j = 0; j < 2*N-1; j++)
                for (int j2 = 0; j2 < N; j2++) {
                    data[j][j2] = in.nextInt();
                    map[data[j][j2]]++;
                }
            int[] finalArr = new int[N];
            int idx = 0;
            for (int j = 0; j < 2501; j++) {
                if((map[j]&1) == 1)
                    finalArr[idx++] = j;
            }
            Arrays.sort(finalArr);
            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < finalArr.length; j++) {
                System.out.print(finalArr[j] + " ");
            }
            System.out.println();
         }
     }
}