package googlejam3.p205;
import java.util.Scanner;

public class Brattleship {
    
    public static void main(String[] args) {  
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = s.nextInt();
            int c = s.nextInt();
            int w = s.nextInt();
            int result = 0;
            if (r > 1) {
                result = (r - 1) * (c / w);
            }
            result += (c - w) / w;
            if ((c - w) % w != 0) {
                result++;                
            }
            result += w;
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
}
