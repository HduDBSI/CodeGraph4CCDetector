package googlejam6.p409;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main6 {
	public static void main(String[] args) {
		Main6 m = new Main6();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int times = in.nextInt();
			int total = 2*times*times-times;
			int[] input = new int[total];
			for (int j = 0; j < total; j++) {
				input[j] = in.nextInt();
			}
			System.out.print("Case #" + i + ": ");
			int[] ans = new int[times];
			Set<Integer> set = new HashSet<Integer>();
			for (int i1 = 0; i1 < input.length; i1++) {
				if(set.contains(input[i1])){
					set.remove(input[i1]);
				}else{
					set.add(input[i1]);
				}
			}
			int t1 = 0;
			for(int s : set){
				ans[t1] = s;
				t1++;
			}
			Arrays.sort(ans);
			for (int i2 = 0; i2 < ans.length; i2++) {
				System.out.print(ans[i2]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}