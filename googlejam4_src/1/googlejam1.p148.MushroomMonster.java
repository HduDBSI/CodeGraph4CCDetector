package googlejam1.p148;
import java.util.*;

public class MushroomMonster {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] nums = new int[1000];
    for (int i = 1; i <= t; i++) {
      int n = sc.nextInt();
      int maxGap = 0;
      int sum1 = 0;
      int sum2 = 0;
      for (int j = 0; j < n; j++) {
        nums[j] = sc.nextInt();
        if (j > 0) {
          maxGap = Math.max(maxGap, nums[j - 1] - nums[j]);
          sum1 += Math.max(0, nums[j - 1] - nums[j]);
        }
      }
      for (int j = 0; j < n - 1; j++) {
        sum2 += Math.min(maxGap, nums[j]);
      }
      System.out.printf("Case #%d: %d %d\n", i, sum1, sum2);
    }
  }
}
