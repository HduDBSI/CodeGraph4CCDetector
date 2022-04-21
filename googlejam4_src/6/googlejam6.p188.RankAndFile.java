package googlejam6.p188;
import java.util.*;

public class RankAndFile {
  public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    final int T = in.nextInt();
    for (int i = 1; i <= T; i++) {
      final int N = in.nextInt();
      int []h = new int[2501];
      for (int j = 0; j < (2 * N - 1) * N; j++)
        h[in.nextInt()]++;
      System.out.print("Case #" + i + ":");
      for (int j = 0; j < h.length; j++)
        if (h[j] % 2 == 1)
          System.out.print(" " + j);
      System.out.println();
    }
  }
}