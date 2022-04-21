package googlejam6.p113;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by russinko on 4/15/16.
 */
public class RankAndFile {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("B-large.in"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int caseCount = sc.nextInt();
        for(int i = 0; i < caseCount; i++) {
           int N = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < N*2 - 1; j++) {
                for(int k = 0; k < N; k++) {
                    int val = sc.nextInt();
                    int count = map.getOrDefault(val, 0);
                    map.put(val, count + 1);
                }
            }
            pw.printf("Case #%d:", i + 1);
            List<Integer> list = new ArrayList<Integer>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if((entry.getValue() % 2) == 1) list.add(entry.getKey());
            }

            Collections.sort(list);
            for(int l : list) {
                pw.printf(" %d", l);
            }
            pw.append("\n");

        }
        pw.close();
    }



}
