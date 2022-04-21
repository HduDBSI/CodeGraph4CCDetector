package googlejam6.p438;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RankAndFile {

	public static void main(String s[]) {
		RankAndFile solution = new RankAndFile();
		Scanner scanner = null;
		StringBuilder builder = new StringBuilder();
		try {
			scanner = new Scanner(new File("B-large.in"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				int N = scanner.nextInt();
				int repeat = 2 * N - 1;
				int[][] lists = new int[repeat][N];
				for (int j = 0; j < repeat; j++) {
					for (int k = 0; k < N; k++) {
						lists[j][k] = scanner.nextInt();
					}
				}
				builder.setLength(0);
				Map<Integer, Integer> countMap = new HashMap<>();
				
				for (int j = 0; j < 2 * N - 1; j++) {
					for (int k = 0; k < N; k++) {
						if (countMap.containsKey(lists[j][k])) {
							int count = countMap.get(lists[j][k]);
							count++;
							countMap.put(lists[j][k], count);
				
						} else {
							countMap.put(lists[j][k], 1);
						}
					}
				}
				Iterator<Entry<Integer, Integer>> iterator = countMap.entrySet().iterator();
				List<Integer> missingElements = new ArrayList<Integer>();
				
				while (iterator.hasNext()) {
					Entry<Integer, Integer> entry = iterator.next();
					if (entry.getValue() % 2 == 1) {
						missingElements.add(entry.getKey());
					}
				}
				Collections.sort(missingElements);
				List<Integer> missingList = missingElements;
				for (int num : missingList) {
					builder.append(num + " ");
				}
				System.out.println(String.format("Case #%d: %s", i + 1, builder.toString()));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
