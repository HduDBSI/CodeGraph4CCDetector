package googlejam3.p149;
import java.io.BufferedInputStream;
import java.util.Scanner;


public class TaskA {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int w = sc.nextInt();
            int res = c / w;
            if (c % w == 0) {
                res = res * r + w -1;
            }
            else {
                res = res * r + w;
            }
            System.out.println("Case #" + i + ": " + (long) res);
        }
        sc.close();
        System.err.println(System.currentTimeMillis() - time);
    }

}
