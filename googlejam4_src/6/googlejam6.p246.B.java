package googlejam6.p246;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = null;
		B b = new B();
		try {
			in = new Scanner(System.in);
			int count = in.nextInt();
			for (int test = 1; test <= count; test++) {
				int N = in.nextInt();
				int[][] lists = new int[2 * N - 1][N];
				for (int j = 0; j < 2 * N - 1; j++) {
					for (int k = 0; k < N; k++) {
						lists[j][k] = in.nextInt();
					}
				}
				HashMap<Integer, Integer> map = new HashMap<>();
				int[] result1 = new int[N];
				StringBuilder res = new StringBuilder();
				int pivot = 0;
				for (int j = 0; j < lists.length; j++) {
					for (int k = 0; k < N; k++) {
						if (map.containsKey(lists[j][k])) {
							int count1 = map.get(lists[j][k]);
							map.put(lists[j][k], count1 + 1);
						} else {
							map.put(lists[j][k], 1);
						}
					}
				}
				for (Integer key : map.keySet()) {
					int count2 = map.get(key);
					if (count2 % 2 != 0) {
						result1[pivot] = key;
						pivot++;
					}
				}
				Arrays.sort(result1);
				for (int i = 0; i < N; i++) {
					res.append(" " + result1[i]);
				}
				String result = res.toString();
				System.out.println("Case #" + test + ":" + result);
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
