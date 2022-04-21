package googlejam1.p401;
import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("in.txt"));
		PrintWriter w = new PrintWriter("out.txt");

		int cases = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < cases; i++) {
			int ans1 = 0;
			int ans2 = 0;

			int n = scan.nextInt();
			int[] nums = new int[n];

			int largestDrop = 0;

			int last = nums[0] = scan.nextInt();

			for (int j = 1; j < n; j++) {
				nums[j] = scan.nextInt();
				if (nums[j] < last) {
					int drop = last - nums[j];
					largestDrop = Math.max(drop, largestDrop);
					ans1 += drop;
				}
				last = nums[j];
			}

			if (largestDrop > 0) {
				for (int j = 0; j < n-1; j++) {
					ans2 += Math.min(largestDrop, nums[j]);
				}
			}



			w.print("Case #");
			w.print(i+1);
			w.print(": ");
			w.print(ans1);
			w.print(" ");
			w.print(ans2);
			w.println();
		}

		scan.close();
		w.close();
	}

}
