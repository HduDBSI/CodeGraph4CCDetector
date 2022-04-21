package googlejam6.p172;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\B-large.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Blarge.txt")));
        int cases = Integer.parseInt(br.readLine());
        for(int t = 1; t <= cases; t++) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int i = 0; i < 2*n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if(hs.contains(tmp)) {
                        hs.remove(tmp);
                    }
                    else hs.add(tmp);
                }
            }
            int[] rc = new int[n];
            int index = 0;
            for(int num : hs) {
                rc[index] = num;
                index++;
            }
            Arrays.sort(rc);
            pw.print("Case #" + t + ":");
            for(int i = 0; i < n; i++) {
                pw.print(" " + rc[i]);
            }
            pw.println();
        }
        pw.close();
    }
}
