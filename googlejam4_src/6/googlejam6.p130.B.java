package googlejam6.p130;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class B {
    
    private static String fn = "B-large";
    private static boolean isSubmit = true;
    
    public static void main(String[] args) throws FileNotFoundException {
        if (isSubmit) {
            System.setIn(new FileInputStream("test/" + fn + ".in"));
            System.setOut(new PrintStream("test/" + fn + ".out"));
        }
        
        Scanner in = new Scanner(System.in);
        int t0 = in.nextInt();
        for (int i0 = 1; i0 <= t0; i0++) {
            int n = in.nextInt();
            int[] a = new int[2510];
            for (int i = 0; i < n * (2 * n - 1); i++) {
                a[in.nextInt()]++;
            }
            
            System.out.print("Case #" + i0 + ":");
            for (int i = 1; i <= 2500; i++) {
                if (a[i] % 2 != 0) {
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
        
        in.close();
    }
}
