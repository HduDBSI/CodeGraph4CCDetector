package googlejam6.p258;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Poirot
 *
 */
public class RankandFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			HashSet<Integer>  set = new HashSet<>();
			for (int j = 0; j < N * 2 - 1; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					int num = in.nextInt();
					if (set.contains(num)) {
						set.remove(num);
					}  else {
						set.add(num);
					}
				}
			}
			int[] nums = new int[N];
			int k = 0;
			for (int key : set) {
				nums[k++] = key;
			}
			Arrays.sort(nums);
			System.out.print("Case #" + i + ": ");
			for (int j = 0; j < nums.length - 1; j++) {
				System.out.print(nums[j] + " ");
			}
			System.out.println(nums[nums.length -1]);
		}
	}

}
