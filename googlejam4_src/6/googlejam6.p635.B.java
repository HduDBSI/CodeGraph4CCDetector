package googlejam6.p635;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final PrintStream ps = new PrintStream(System.out);
		final StringBuilder solution = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			solution.append("Case #" + t + ":");
			final int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> numAppearances = new HashMap<Integer, Integer>();
			for (int i = 0; i < (2 * N) - 1; i++) {
				final String input = br.readLine();
				final String[] inputArray = input.split(" ");
				// Each number is seen twice
				for (String s : inputArray) {
					int sInt = Integer.parseInt(s);
					if (!numAppearances.containsKey(sInt)) {
						numAppearances.put(sInt, 1);
					} else {
						numAppearances.put(sInt, numAppearances.get(sInt) + 1);
					}
				}
			}
				
			ArrayList<Integer> solutionList = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : numAppearances.entrySet()) {
				int key = entry.getKey();
				int value = entry.getValue();
				if (value % 2 == 1) {
					solutionList.add(key);
				}
			}
			
			Collections.sort(solutionList);
			for (int i : solutionList) {
				solution.append(" " + i);
			}
			solution.append("\n");
		}
		ps.print(solution);
	}
}
