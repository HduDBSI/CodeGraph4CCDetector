package googlejam1.p187;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] m = new int[n];
      for (int i = 0; i < n; i++) {
        m[i] = Integer.parseInt(st.nextToken());
      }
      long y = 0, z = 0, max = 0;
      for (int i = 0; i < n - 1; i++) {
        if (m[i] > m[i + 1]) {
          int d = m[i] - m[i + 1];
          y += d;
          if (d > max) {
            max = d;
          }
        }
      }
      for (int i = 0; i < n - 1; i++) {
        z += Math.min(m[i], max);
      }
      System.out.println(String.format("Case #%d: %d %d", t, y, z));
    }
  }
}