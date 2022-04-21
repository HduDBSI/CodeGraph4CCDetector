package googlejam6.p589;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        File f = new File(args[0] + ".in");
        try (Scanner in = new Scanner(new FileInputStream(f));
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(new File(args[0] + ".out")))) {
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                int rows = 2*N-1;               

                int[] vals = new int[rows*N];
                int idx = 0;
                int max = Integer.MIN_VALUE;
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < N; col++){
                        vals[idx] = in.nextInt();
                        if (vals[idx] > max)
                            max = vals[idx];
                        idx++;
                    }
                }
                
                int[] count = new int[max+1];
                for (int j : vals) 
                    count[j]++;
                
                int[] solution = new int[N];
                idx = 0;
                for (int j = 0; j < count.length; j++)
                    if (count[j] % 2 != 0)
                        solution[idx++] = j;
                
                Arrays.sort(solution);
                
                String str = "Case #" + (i + 1) + ":";
                for (int j : solution)
                    str += " " + j;
                out.write(str);
                out.newLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
