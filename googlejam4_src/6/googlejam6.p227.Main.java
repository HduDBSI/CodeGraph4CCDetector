package googlejam6.p227;
import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Case #%d: %s\n";

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("output"));
        Scanner in = new Scanner(new FileInputStream("B-large.in"));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int col = in.nextInt();

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < 2 * col - 1; j++) {
                for (int k = 0; k < col; k++) {
                    int num = in.nextInt();
                    if (!map.containsKey(num)) {
                        map.put(num, 1);
                    } else {
                        int count = map.get(num);
                        map.put(num, count + 1);
                    }
                }
            }
            TreeSet<Integer> missing = new TreeSet<>();
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    missing.add(entry.getKey());
                }
            }
            StringBuilder output = new StringBuilder();
            for (int num: missing) {
                output.append(num).append(" ");
            }
            writer.printf(FORMAT, i, output.toString());
        }
        writer.flush();
        writer.close();
    }
}