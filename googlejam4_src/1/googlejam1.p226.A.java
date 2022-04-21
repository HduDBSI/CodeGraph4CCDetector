package googlejam1.p226;
import java.util.*;

class Main {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tcc = sc.nextInt();
    for (int tc = 1; tc <= tcc; ++tc) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();
      int a = 0;
      for (int i = 1; i < n; ++i) a += Math.max(0, arr[i-1] - arr[i]);
      int br = 0;
      for (int i = 1; i < n; ++i) br = Math.max(br, arr[i-1] - arr[i]);
      int b = 0;
      for (int i = 0; i < n - 1; ++i) b += Math.min(br, arr[i]);
      System.out.printf("Case #%d: %d %d%n", tc, a, b);
    }
  }
}
