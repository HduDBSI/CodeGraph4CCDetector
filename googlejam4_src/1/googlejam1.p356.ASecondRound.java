package googlejam1.p356;
import java.io.*;
import java.util.*;
import java.math.*;
public class ASecondRound {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int cases = 1; cases <= T; cases++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) 
				nums[i] = Integer.parseInt(st.nextToken());
			int ans1 = 0, ans2 = 0;
			for (int i = 1; i < nums.length; i++) 
				if(nums[i] < nums[i-1]) ans1 += nums[i-1] - nums[i];
			double rate = 0;
			for (int i = nums.length-1; i > 0; i--) 
				rate = Math.max(rate, nums[i-1] - nums[i]);
			
			for (int i = 0; i < nums.length-1; i++) {
				if(nums[i] > rate) ans2 += rate;
				else ans2 += nums[i];
			}
			
			System.out.println("Case #" + cases + ": " + ans1 + " " + ans2);
		}
	}
}
