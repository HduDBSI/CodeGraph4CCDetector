package googlejam6.p211;
import java.util.*;

public class C {
	public static void main(String[] unused) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; i++) {
			int N = scanner.nextInt();
			Map<Integer, Integer> m = new HashMap<Integer,Integer>();
			for (int j = 0; j < (2 * N - 1) * N; j++) {
				int x = scanner.nextInt();
				Integer v = m.get(x);
				if (v == null) {
					m.put(x, 1);
				} else {
					m.put(x,  v + 1);
				}
			}
			List<Integer> l = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
				int v = entry.getValue();
				if (v % 2 == 1) {
					l.add(entry.getKey());
				}
			}
			Collections.sort(l);
			System.out.printf("Case #%d:", i);
			for (int j = 0; j < N; j++){
				System.out.printf(" %s",l.get(j));
			}
			System.out.println();
		}
		scanner.close();
	}

}
