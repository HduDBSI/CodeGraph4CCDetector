package googlejam6.p294;
import java.util.*;
import java.io.*;
public class RankAndFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();    // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();            

            for (int j = 0; j < 2*n -1; j++) {
                for (int k = 0; k < n; k++) {
                    int m = in.nextInt();
                    if (seen.get(m) == null) {
                        seen.put(m, 1);
                    } else {
                        seen.put(m, seen.get(m) + 1);    
                    }
                }
            }

            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            
            Set<Integer> entrySet = seen.keySet();
            for (Integer key : entrySet) {
                if (seen.get(key) % 2 == 1) {
                    q.add(key);
                }
            }

            String res = "";
            while(q.size() > 0) {
                res += q.poll() + " ";
            }

            System.out.println("Case #" + i + ": " + res);
        }
    }
}