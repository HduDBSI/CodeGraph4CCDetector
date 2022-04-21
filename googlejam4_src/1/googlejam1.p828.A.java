package googlejam1.p828;
import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.io.*;

public class A {
    
    static Scanner in = new Scanner(System.in);
    
    static PrintStream out = System.out;
    
    public static void main(String[] args) {
        int T = in.nextInt();
        
        for (int test = 1; test <= T; test++){
            int N = in.nextInt();
            
            int[] m = new int[N];
            
            for (int i = 0; i < N; i++){
                m[i] = in.nextInt();
            }
            
            int R1 = 0;
            
            for (int i = 1; i < N; i++){
                if (m[i] - m[i - 1] < 0){
                    R1 += Math.abs(m[i] - m[i - 1]);
                }
            }
            
            int maxDiff = 0;
            
            for (int i = 0; i < N - 1; i++){
                maxDiff = Math.max(maxDiff, m[i] - m[i + 1]);
            }
            
            int R2 = 0;
            
            //out.println(maxDiff);
            
            for (int i = 0; i < N - 1; i++){
                R2 += Math.min(m[i], maxDiff);
            }
            
            out.println(String.format("Case #%d: %d %d", test, R1, R2));
        }
    }
}
