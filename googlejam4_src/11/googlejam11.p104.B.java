package googlejam11.p104;
import java.util.*;

class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tcc = sc.nextInt();
    for (int tc = 1; tc <= tcc; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      double[] p = new double[n];
      double[] pc = new double[k];
      for (int i = 0; i < n; ++i) p[i] = sc.nextDouble();

      double ans = 0;
      for (int bm = 0; bm < (1 << n); ++bm) {
        int bs = 0;
        for (int i = 0; i < n; ++i) if ((bm & (1 << i)) > 0) ++bs;
        if (bs != k) continue;
        bs = 0;
        for (int i = 0; i < n; ++i) if ((bm & (1 << i)) > 0) pc[bs++] = p[i];
        double[][] comp = new double[k + 1][];
        comp[0] = new double[] { 1 };
        for (int i = 1; i <= k; ++i) {
          comp[i] = new double[i + 1];
          double cp = pc[i - 1];
          for (int j = 0; j <= i; ++j) {
            if (j != 0) comp[i][j] += cp * comp[i-1][j-1];
            if (j != i) comp[i][j] += (1 - cp) * comp[i-1][j];
          }
        }
        ans = Math.max(ans, comp[k][k / 2]);
      }

      System.out.printf("Case #%d: %.6f%n", tc, ans);
    }
  }
}
