package googlejam6.p533;
import java.util.*;

public class GCJ2016B1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    int a = sc.nextInt();
                    if (set.contains(a)) {
                        set.remove(a);
                    } else {
                        set.add(a);
                    }
                }
            }
            System.out.print("Case #" + k + ":");
            for (int a : set) {
                System.out.print(" " + a);
            }
            System.out.println();
        }
    }

}
