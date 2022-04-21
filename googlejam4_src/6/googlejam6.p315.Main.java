package googlejam6.p315;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int N = in.nextInt();

			Map<Integer, Boolean> temp = new HashMap<Integer, Boolean>();
			for (int j = 1; j <= (2 * N - 1); j++) {
				for (int k = 1; k <= N; k++) {
					int soldHeight = in.nextInt();
					if (temp.containsKey(soldHeight)) {
						temp.remove(soldHeight);
					} else {
						temp.put(soldHeight, true);
					}
				}
			}

			List<Integer> sortedKeys = new ArrayList<Integer>(temp.keySet());
			Collections.sort(sortedKeys);
			
			String missingRowOrCol = "";

			for (int k = 0; k < sortedKeys.size();k++) {
				missingRowOrCol += " " + sortedKeys.get(k);
			}

			System.out.println("Case #" + i + ":" + missingRowOrCol);
		}
	}
}