package googlejam1.p513;
import java.util.*;

public class MushroomMonster {
  public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    final int T = in.nextInt();
    for (int i = 1; i <= T; i++) {
      final int N = in.nextInt();
      int []m = new int[N];
      int prev = m[0] = in.nextInt();
      int accDec = 0;
      int maxDec = 0;
      for (int j = 1; j < N; j++) {
        int cur = m[j] = in.nextInt();
        if (cur < prev) {
          accDec += (prev - cur);
          maxDec = Math.max(maxDec, prev - cur);
        }
        prev = cur;
      }
      int acc2Dec = 0;
      for (int j = 0; j < N - 1; j++) {
        acc2Dec += Math.min(maxDec, m[j]);
      }
      System.out.println("Case #" + i + ": " + accDec + " " + acc2Dec);
    }
    in.close();
  }
}