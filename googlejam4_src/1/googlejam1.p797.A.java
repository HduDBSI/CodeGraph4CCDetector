package googlejam1.p797;
import java.util.*;

public class A {
    public static void main(String[] args) {
        int testCases;

        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();

        for (int j = 1; j <= testCases; j++) {
            int n;
            n = sc.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int q = 0, p = 0, mx = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] < 0) {
                    q += (a[i - 1] - a[i]);
                }

                mx = Math.max(mx, a[i - 1] - a[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                if (a[i] >= mx) p += mx;
                else p += a[i];
            }
            System.out.println("Case #" + j + ": " + q + " " + p);
        }
    }
}
