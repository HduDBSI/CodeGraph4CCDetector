package googlejam6.p389;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class main_22_2 {
	public static void main(String[] args) {
		main_22_2 m = new main_22_2();
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
			Set<Integer> set = new HashSet<Integer>();
			for(int i3 = 0; i3 < input.length; i3++){
				if(!set.contains(input[i3])){
					set.add(input[i3]);
				} else {
					set.remove(input[i3]);
				}
			}
			
			int[] ans1 = new int[set.size()];
			int index = 0;
			for(int i1 : set){
				ans1[index++] = i1;
			}
			
			Arrays.sort(ans1);
			StringBuffer sb = new StringBuffer();
			for(int i2 = 0; i2 < ans1.length; ++i2){
				sb.append(ans1[i2]).append(" ");
			}

			String ans = sb.substring(0, sb.length() - 1);
			System.out.print("Case #" + i + ": " + ans);
			System.out.println();
		}
	}
	
	
}
