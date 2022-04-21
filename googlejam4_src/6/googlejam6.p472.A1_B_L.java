package googlejam6.p472;
import java.util.*;

/**
 * Author: Destiner
 * Date: 16.04.2016
 */
public class A1_B_L {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int k = 0; k < T; k++) {
            Map<Integer, Integer> mentionsMap = new HashMap<>();
            int n = scanner.nextInt();
            for (int i = 0; i < 2*n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    int x = scanner.nextInt();
                    if (!mentionsMap.containsKey(x)) {
                        mentionsMap.put(x, 0);
                    }
                    // Increase mentions number
                    mentionsMap.put(x, mentionsMap.get(x) + 1);
                }
            }
            System.out.print("Case #");
            System.out.print(k + 1);
            System.out.print(": ");
            List<Integer> weirdoList = new ArrayList<>();
            for (int i = 1; i <= 2500; i++) {
                if (!mentionsMap.containsKey(i)) {
                    continue;
                }
                if (mentionsMap.get(i) % 2 != 0) {
                    weirdoList.add(i);
                }
            }
            for (Integer weirdo : weirdoList) {
			    System.out.print(weirdo);
			    System.out.print(' ');
			}
            System.out.println();
        }
    }
}
