package googlejam6.p147;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < N * (2 * N - 1); j++) {
				int n = sc.nextInt();
				if (map.containsKey(n)) {
					map.put(n, map.get(n) + 1);
				} else {
					map.put(n, 1);
				}
			}
			ArrayList<Integer> list = new ArrayList<>();
			for (int k : map.keySet()) {
				if (map.get(k) % 2 == 1) {
					list.add(k);
				}
			}
			Collections.sort(list);
			System.out.print("Case #" + i + ":");
			for (int k : list) {
				System.out.print(" " + k);
			}
			System.out.println();
		}
		sc.close();
	}
}