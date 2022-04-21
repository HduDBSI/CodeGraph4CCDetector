package googlejam8.p041;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Senate {

	public static void main(String[] args) throws Exception {
		Senate object = new Senate();
		String className = object.getClass().getSimpleName();

		FileReader fileReader = new FileReader(new File(className.toLowerCase() + ".in"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));

		FileWriter wr = new FileWriter(className.toLowerCase() + ".out");

		st.nextToken();
		int testCases = (int) st.nval;

		for (int tc = 1; tc <= testCases; tc++) {

			System.out.println("At test " + tc + "/" + testCases);

			st.nextToken();
			int N = (int) st.nval;

			int[] P = new int[N];

			for (int i = 0; i < N; i++) {
				st.nextToken();
				P[i] = (int) st.nval;
			}
			List<String> output = new ArrayList<>();
			
			Map<Character, Integer> count = new HashMap<>();
			
			for (int i = 0; i < P.length; i++) {
				count.put((char) ('A' + i), P[i]);
			}
			
			while (count.size() > 0) {
			
				int maxOccurs = 0;
				List<Character> occurs = new ArrayList<>();
			
				for (Character ch : count.keySet())
					maxOccurs = Math.max(maxOccurs, count.get(ch));
			
				for (Character ch : count.keySet())
					if (count.get(ch) == maxOccurs)
						occurs.add(ch);
			
				if ((occurs.size() % 2) == 1) {
					// choose one
					char ch = occurs.get(0);
			
					count.put(ch, maxOccurs - 1);
			
					if (maxOccurs - 1 == 0) {
						count.remove(ch);
					}
			
					output.add("" + ch);
				} else {
					// remove two
					char ch1 = occurs.get(0);
					char ch2 = occurs.get(1);
			
					count.put(ch1, maxOccurs - 1);
					count.put(ch2, maxOccurs - 1);
			
					if (maxOccurs - 1 == 0) {
						count.remove(ch1);
						count.remove(ch2);
					}
			
					output.add("" + ch1 + "" + ch2);
				}
			
			}

			List<String> result = output;

			StringBuilder sb = new StringBuilder();
			for (String str : result) {
				sb.append(str + " ");
			}

			wr.write("Case #" + tc + ": " + sb.toString().trim() + "\r\n");
		}

		wr.close();
	}
}
