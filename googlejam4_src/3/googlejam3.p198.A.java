package googlejam3.p198;
import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        final int noTests = in.nextInt();
        in.nextLine();
        
        for(int test=1; test<=noTests; test++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int W = in.nextInt();
            
            int hits = (R * (C/W)) + W - 1;
            
            if(C % W != 0)
                hits++;
            
            System.out.printf("Case #%d: %d%n", test, hits);
        }
    }
}
