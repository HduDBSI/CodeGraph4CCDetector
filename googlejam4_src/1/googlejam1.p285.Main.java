package googlejam1.p285;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        int T = Integer.parseInt(line);
        
        for (int t = 1; t <= T; t++) {
            line = stdin.readLine();
            int n = Integer.parseInt(line);
            
            line = stdin.readLine();
            String[] prms = line.split(" ");
            
            int ans1 = 0;
            int mx = 0;
            int[] m = new int[n];
            m[0] = Integer.parseInt(prms[0]);
            for (int i = 1; i < n; i++) {
                m[i] = Integer.parseInt(prms[i]);
                int d = m[i-1]-m[i];
                mx = Math.max(mx, d);
                if (d > 0) ans1 += d;
            }
            
            int ans2 = 0;
            for(int i = 0; i < n-1; i++) {
                ans2 += Math.min(mx, m[i]);
            }
            
            System.out.printf("Case #%d: %d %d\n", t, ans1, ans2);
        }
    }
}
