package googlejam1.p441;

import java.util.Scanner;

/**
 * Created by misanand on 4/18/15.
 */
public class MushroomMonster {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int tt =1; tt <=T;tt++) {
            int N = scanner.nextInt();
            int [] a  = new int[N];
            for (int i=0;i<N;i++) a[i] = scanner.nextInt();
            int f = 0;
            int s = 0;
            int max = 0;
            for (int i=1;i<N;i++) {
                int v = a[i -1] - a[i];
                if (v > 0) f+=v;
                max = Math.max(max,v);
            }
            for (int i=0;i<N-1;i++) {
                int min = Math.min(a[i],max);
                s +=min;
            }
            System.out.println("Case #"+tt+": "+f+" "+s);
        }

    }
}
