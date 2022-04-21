package googlejam6.p530;
import java.io.BufferedInputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int nCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nCases; i++) {
            int n = sc.nextInt();
            int totalN = n * (2 * n - 1);
            System.out.print("Case #" + String.valueOf(i + 1) + ":");
            HashMap<Integer, Integer> counter = new HashMap<>();
            for (int j = 0; j < totalN; j++) {
                int curr = sc.nextInt();
                if (counter.containsKey(curr) && counter.get(curr) == 1) {
                    counter.put(curr, 0);
                } else {
                    counter.put(curr, 1);
                }
            }
            LinkedList<Integer> list = new LinkedList<>();
            counter.forEach((h, fl) -> { if (fl > 0) list.add(h); });
            list.sort(Integer::compareTo);
            list.forEach(h -> System.out.print(" " + String.valueOf(h)));
            System.out.println();
        }
    }
}
