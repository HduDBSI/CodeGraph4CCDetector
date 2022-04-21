package googlejam6.p391;

/**
 * https://code.google.com/codejam/contest/dashboard?c=32003#s=p0
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RankAndFile {
	static String inputFile = "";
	static String outputFile = "";
	static Scanner in;

	static {
		outputFile = "B.out";
	}

	public static void main(String[] args) throws IOException {
		in = new Scanner(new BufferedReader((new FileReader("/Users/sandz/Downloads/B-large.in"))));
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
		int testCases = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i <= testCases; i++) {
			int n = in.nextInt();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i1 = 0; i1 < 2 * n - 1; i1++) {
				for (int j = 0; j < n; j++) {
					int row = in.nextInt();
					Integer count = map.get(row);
					if (count == null) {
						count = 0;
					}
					map.put(row, ++count);
				}
			}
			List<Integer> x = new LinkedList<Integer>();
			for (Integer key : map.keySet()) {
				int count = map.get(key);
				if (count % 2 == 1) {
					x.add(key);
				}
			}
			Collections.sort(x);
			
			StringBuffer buffer = new StringBuffer();
			for (Integer integer : x) {
				buffer.append(integer + " ");
			}
			String ans = buffer.toString();
			stringBuilder.append("CASE #" + (i) + ": " + ans + "\n");
		}
		System.out.println(stringBuilder.toString());
		out.write(stringBuilder.toString());
		out.flush();
		in.close();
		out.close();
	}

}