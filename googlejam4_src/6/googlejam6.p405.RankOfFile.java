package googlejam6.p405;


import javafx.beans.binding.StringBinding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class RankOfFile {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("B-large.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        RankOfFile test = new RankOfFile();

        int n = in.nextInt();

        for (int i = 0; i < n ;i++) {
            int k = in.nextInt();
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>() {
            };
            for (int j = 0; j < (2*k-1)*k; j++) {
                String s = in.next();
                int num = Integer.parseInt(s);
                if (map.containsKey(num)) {
                    map.put(Integer.parseInt(s),map.get(num)+1);
                } else {
                    map.put(Integer.parseInt(s), 1);
                }
            }
            String[] sb = new String[k];
            int kk = 0;
            Set set2 = map.entrySet();
            Iterator iterator2 = set2.iterator();
            while(iterator2.hasNext()) {
                Map.Entry me2 = (Map.Entry)iterator2.next();
                if ((int)me2.getValue() % 2 != 0) {
                    sb[kk] = String.valueOf(me2.getKey());
                    kk++;
                }

            }


            pw.print("Case #" + (i + 1) + ": ");
            pw.println(String.join(" ", sb));
        }
        pw.flush();
        pw.close();
        in.close();

    }
}
