package googlejam8.p081;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by pallavi on 8/5/16.
 */
public class SenateEvacuation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("in.txt")));
        PrintWriter writer = new PrintWriter("out.txt");
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                char ch = 'A';
                ch += j;
                map.put(ch, scanner.nextInt());
            }
            writer.print("Case #" + i + ": ");
            if (map.size() == 0) continue;
            char mxc = 'A';
            int mx = 0;
            for (char ch: map.keySet()) {
                if (map.get(ch) > mx) {
                    mxc = ch;
                    mx = map.get(mxc);
                }
            }
            if (mx == 0) continue;
            map.remove(mxc);
            char mxc1 = 'A';
            int mx1 = 0;
            for (char ch: map.keySet()) {
                if (map.get(ch) > mx1) {
                    mxc1 = ch;
                    mx1 = map.get(mxc1);
                }
            }
            int diff = mx - mx1;
            while (diff > 0) {
                writer.print(mxc + " ");
                diff--;
                mx--;
            }
            map.remove(mxc1);
            for (char ch1: map.keySet()) {
                int k = map.get(ch1);
                while (k > 0) {
                    writer.print(ch1 + " ");
                    k--;
                }
            }
            while (mx != 0) {
                writer.print(mxc + "" + mxc1 + " ");
                mx--;
            }
            writer.println();
        }
        writer.close();
        scanner.close();
    }
}
