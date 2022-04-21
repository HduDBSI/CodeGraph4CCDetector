package googlejam1.p363;
import java.util.Scanner;
class t {
  public static void main(String[] args) {
    int t, c;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    for (c = 1; c <= t; c++) {
      int n = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < n; i++) {
        s[i] = sc.nextInt();
      }
      int total = 0, total1 = 0, maxDiff = 0;
      for (int i = 1; i < n; i++) {
        if (s[i-1] > s[i]) {
          int diff = s[i-1] - s[i];
          total += diff;
          maxDiff = Math.max(diff, maxDiff);
        }
      }
      for (int i = 0; i < n-1; i++) {
        total1 += Math.min(maxDiff, s[i]);
      }
      System.out.printf("Case #%d: %d %d\n", c, total, total1);
    }
  }
}
