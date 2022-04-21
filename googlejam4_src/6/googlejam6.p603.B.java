package googlejam6.p603;
import java.util.*;
import java.io.*;
import java.math.*;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			Map<Integer, Integer> map = new HashMap<>();
			Set<Integer> set = new HashSet<>();
			int n = in.nextInt();
			for (int j = 0; j < n * 2 - 1; j++) {
				for (int k = 0; k < n; k++) {
					int e = in.nextInt();
					set.add(e);
					if (map.containsKey(e)) map.put(e, map.get(e) + 1);
					else map.put(e, 1);
				}
			}
			int[] numbers = new int[set.size()];
			int[] res = new int[n];
			int start = 0;
			for (Integer p : set) {
				numbers[start++] = p;
			}
			Arrays.sort(numbers);
			start = 0;
			for (int j = 0; j < numbers.length; j++) {
				if (map.get(numbers[j]) % 2 != 0)  res[start++] = numbers[j];
			}
			System.out.print("Case #" + i + ": ");
			for (int j = 0; j < res.length; j++) {
				if (j == res.length - 1) System.out.println(res[j]);
				else System.out.print(res[j] + " ");
			}
		}
	}
}
