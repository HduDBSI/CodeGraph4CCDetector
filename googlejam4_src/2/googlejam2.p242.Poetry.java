package googlejam2.p242;
import java.io.*;
import java.util.*;

public class Poetry {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      int t = Integer.parseInt(br.readLine());
      for (int i = 1; i <= t; i++) {
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];
        for (int j = 1; j <= n; j++) {
          nums[j] = n-j+1;
        }
        nums[n] = 1;
        for (int j = n-1; j >= 1; j--) {
          int j1 = j;
			int r = 0;
			while (j1 > 0) {
			  r *= 10;
			  r += j1 % 10;
			  j1 /= 10;
			}
		int reverse_j = r;
          if (reverse_j <= n) {
            nums[j] = 1 + Math.min(nums[reverse_j],nums[j+1]);
          } else {
            nums[j] = 1 + nums[j+1];
          }
        }

        bw.write("Case #" + i + ": " + nums[1]);
        bw.newLine();
      }

      bw.flush();
      bw.close();
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
