package googlejam1.p795;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Mushrooms  {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(
        "A-large.in.txt"));
    File out = new File("large.out.txt");
    PrintWriter pw = new PrintWriter(out);

    int cases = Integer.parseInt(br.readLine());

    for (int tt = 0; tt < cases; tt++) {
      int n = Integer.parseInt(br.readLine());
      String[] s = br.readLine().split(" ");
      int[] q = new int[n];

      for (int i = 0; i < n; i++) {
        q[i] = Integer.parseInt(s[i]);
      }


      int m1 = 0;
      for (int i = 0; i < n - 1; i++) {
        int k = q[i + 1] - q[i];
        if (k < 0) m1 += -k;
      }

      int m2 = Integer.MAX_VALUE;
      for (int rate = 0; rate < 10001; rate++) {
        int count = 0;
        boolean good = true;
        int cons = rate;
        for (int i = 0; i < n - 1; i++) {
          //cons = rate * 10 > q[i] ? q[i] : rate * 10;
          if (q[i] - cons > q[i + 1]) {
            good = false;
            break;
          } else {
            count += q[i] - cons >= 0 ? cons : q[i];
          }
        }
        if (good) {
          m2 = count;
          break;
        }

      }

      pw.println("Case #" + (tt + 1) + ": " + m1 + " " + m2);
    }
    br.close();
    pw.close();
  }
}
