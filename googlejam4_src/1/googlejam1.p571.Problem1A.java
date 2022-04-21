package googlejam1.p571;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * CodeJam 2015: Round1-A
 * Problem A.
 * User: Mitesh, 4/17/15 @ 5:59 PM
 */
public class Problem1A {
    private static final boolean DEBUG = false;

    public static void main(String[] args) throws FileNotFoundException {
        Problem1A prog = new Problem1A();

        Scanner in = new Scanner(new FileReader(args[0]));
        final int cntCases = in.nextInt();
        in.nextLine();

        for (int caseNum = 1; caseNum <= cntCases && in.hasNextLine(); caseNum++) {
            in.nextLine();
			String[] vals1 = in.nextLine().split("\\s+");
			int[] arr = new int[vals1.length];
			for (int i1 = 0; i1 < vals1.length; i1++) {
			    arr[i1] = Integer.valueOf(vals1[i1]);
			} //discard!
            final int[] vals = arr;
			int sum1 = 0;
			int prev1 = vals[0];
			for (int i1 = 1; i1 < vals.length; i1++) {
			    int cur1 = vals[i1];
			    if (cur1 < prev1) {
			        sum1 += (prev1 - cur1);
			    }
			    prev1 = cur1;
			}

            int ans1 = sum1;
			int maxDiff = 0;
			        int prev = vals[0];
			        for (int i = 1; i < vals.length; i++) {
			            int cur = vals[i];
			            if (cur < prev) {
			                maxDiff = Math.max(maxDiff, (prev-cur));
			            }
			            prev = cur;
			        }
			
			        int sum = 0;
			        prev = vals[0];
			        for (int i = 1; i < vals.length; i++) {
			            int cur = vals[i];
			//            int left = prev - maxDiff;
			            sum += Math.min(prev, maxDiff);
			            //assert that the #remaining <= current amount.
			            prev = cur;
			        }
            int ans2 = sum;
            System.out.println("Case #" + caseNum + ": " + ans1 + " " + ans2);
        }
    }
}
