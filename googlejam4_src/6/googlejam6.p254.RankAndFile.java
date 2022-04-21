package googlejam6.p254;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by wagner on 04/16/16.
 */
public class RankAndFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        long nCases = scanner.nextLong();
        scanner.nextLine();
        for (int i = 1; i <= nCases; i++) {
            long n = scanner.nextLong();
            scanner.nextLine();
            Map<Integer, Integer> counter = new HashMap<>();
            for(int j = 0; j < 2 * n - 1; j++) {
                for(int k = 0; k < n; k++) {
                    int value = scanner.nextInt();
                    Integer count = counter.get(value);
                    if(count == null) {
                        counter.put(value, 1);
                    } else {
                        counter.put(value, count + 1);
                    }
                }
            }
            SortedSet<Integer> out = new TreeSet<>();
            for(Integer key : counter.keySet()) {
                if(counter.get(key) % 2 == 1) {
                    out.add(key);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(":");
            out.stream().forEach(v -> sb.append(" ").append(v));
            System.out.println(sb.toString());
        }
    }
}
