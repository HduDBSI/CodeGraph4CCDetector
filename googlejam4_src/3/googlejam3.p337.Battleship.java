package googlejam3.p337;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Battleship {

    static int T;
;
    
    public static void main(String[] args) {
        Scanner scan;

        int R,C,W;
        int[] dp;
        int[] misses;
        try {
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            scan = new Scanner(new File("input.txt"));
            
            T = scan.nextInt();
            
            for (int t=0; t<T; t++) {
                
                R = scan.nextInt();
                C = scan.nextInt();
                W = scan.nextInt();
                dp = new int[C+1];
                misses = new int[C+1];
                for (int i=0; i<W; i++) {
                    dp[i] = Integer.MIN_VALUE;
                    misses[i] = 0;
                }
                
                dp[W] = W;
                misses[W] = 1;
                for (int i=W+1; i<=C; i++){
                    misses[i] = (i/W);
                    int min = Integer.MAX_VALUE;
                    for (int j=1; j<=i; j++){
                        int temp = Math.max(misses[j-1]+ dp[i-j], misses[i-j] + dp[j-1]);
                        if (temp != Integer.MIN_VALUE) {
                            min = Math.min(min, temp+1);
                        }
                        

                    }
                    int hit = W+1;
                    if (W == 1) hit = 1;
                    dp[i] = Math.max(min, hit);
                }
                
                int result = dp[C] + (R-1)*(C/W);
                out.write("Case #" + (t+1) + ": " + result + "\n");
                out.flush();
            }
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
