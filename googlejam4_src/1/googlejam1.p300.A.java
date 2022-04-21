package googlejam1.p300;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int caseNum = 1;  caseNum <= t; caseNum++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int sum1 = 0;
			int sum2 = 0;
			int maxDiff = 0;

			for (int i = 0; i < n - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					int diff = nums[i] - nums[i + 1];
					if (diff > maxDiff) { 
						maxDiff = diff;
					}
					sum1 += diff;
				}
			}

			for (int i = 0; i < n - 1; i++) {
				if (nums[i] < maxDiff) {
					sum2 += nums[i];
				}
				else {
					sum2 += maxDiff;
				}
			}

			System.out.printf("Case #%d: %d %d\n", caseNum, sum1, sum2);

		}
	}
}
