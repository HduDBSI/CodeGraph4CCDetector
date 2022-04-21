package googlejam6.p629;
import java.util.*;
import java.io.*;

public class Rank {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int testCase = 1; testCase <= t; ++testCase) {
			int n = in.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < 2 * n - 1; i++) {
				for (int j = 0; j < n; j++) {
					int a = in.nextInt();
					if (!map.containsKey(a)) {
						map.put(a, 1);
					} else {
						int count = map.get(a);
						map.put(a, ++count);
					}
				}
			}
			Iterator it = map.entrySet().iterator();
			int result[] = new int[n];
			int i = 0;
			while(it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				int key = (int) pair.getKey();
				int value = (int) pair.getValue();
				if (value % 2 != 0) {
					result[i] = key;
					i++;
				}
				it.remove();
			}
			Arrays.sort(result);
			System.out.print("Case #" + testCase + ":");
			for (int j = 0; j < n; j++) {
				System.out.print(" " + result[j]);
			}
			System.out.println();
		}
		in.close();
	}
	
}
