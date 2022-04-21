package googlejam6.p526;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Mvsmark on 4/16/2016.
 */
public class B_1A_RankAndFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            HashMap<Integer, Integer> hmap = new HashMap<>();
            for (int j = 0; j < n * (2 * n - 1); j++) {
                int x = in.nextInt();
                Integer value = hmap.get(x);
                if (value != null) {
                    hmap.put(x, ++value);
                } else {
                    hmap.put(x, 1);
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    result.add(entry.getKey());
                }
            }
            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (Integer a : result)
            {
                sb.append(" ");
                sb.append(a);
            }
            System.out.println("Case #" + i + ":" + sb.toString());
        }
    }
}
