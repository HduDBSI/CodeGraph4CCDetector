package googlejam6.p195;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Driver {
	private static BufferedReader br;
	private static BufferedWriter bw;

	/*
	 * Apache Commons Lang Availble @
	 * https://commons.apache.org/proper/commons-lang/
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader(new File("input.txt")));
			bw = new BufferedWriter(new FileWriter(new File("output.txt")));

			final long numCases = Long.parseLong(br.readLine());
			for (long i = 1; i <= numCases; i++) {
				// read the inputs
				final int n = Integer.parseInt(br.readLine());

				// do stuff
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

				for (int j = 0; j < (n * 2) - 1; j++) {
					String s = br.readLine();
					StringTokenizer st = new StringTokenizer(s, " ");
					while (st.hasMoreTokens()) {
						Integer key = Integer.parseInt(st.nextToken());
						if (map.containsKey(key)) {
							map.put(key, map.get(key) + 1);
						} else {
							map.put(key, 1);
						}
					}
				}

				List<Integer> results = new ArrayList<Integer>();
				for (Integer key : map.keySet()) {
					if (map.get(key) % 2 == 0) {
						continue;
					}
					results.add(key);
				}

				results.sort(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				});

				String result = "";
				for (Integer height : results) {
					result += height + " ";
				}
				// write the results
				String caseString = String.format("Case #%s: %s\r\n", i, result);
				System.out.print(caseString);
				bw.write(caseString);
			}
			bw.flush();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
