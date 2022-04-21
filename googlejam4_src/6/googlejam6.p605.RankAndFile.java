package googlejam6.p605;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class RankAndFile {

	public static void main(String[] args) throws IOException {
		String s1 = "B", s2 = "large";
		String fileName = s1 + "-" + s2 + ".in", outputFileName = s1 + "-" + s2 + ".out";
		//String fileName = s1 + "-" + s2 + "-attempt0.in", outputFileName = s1 + "-" + s2 + "-attempt0.out";
		//String fileName = "sample.in", outputFileName = "sample.out";
		RankAndFile obj = new RankAndFile();
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		int numberOfCases = Integer.parseInt(scanner.nextLine());
		Object[] result = new Object[numberOfCases];
		for (int i = 0; i < numberOfCases; i++) {
			int n = Integer.parseInt(scanner.nextLine());
			ArrayList<int[]> rows = new ArrayList<>();
			int lines = n * 2 - 1;
			for (int j = 0; j < lines; j++) {
				String[] heights = scanner.nextLine().split(" ");
				int[] height = new int[n];
				for (int k = 0; k < n; k++) {
					height[k] = Integer.parseInt(heights[k]);
				}
				rows.add(height);
			}
			ArrayList<int[]> rows1 = new ArrayList<>();
			for (int[] a : rows) {
				int[] b = Arrays.copyOf(a, a.length);
				rows1.add(b);
			}
			int target = 0, row = 0, min = 0;
			for (int i1 = 0; i1 < rows1.get(0).length; i1++) {
				min = 2500;
				boolean find = false;
				for (int j = 0; j < rows1.size(); j++) {
					int cur = rows1.get(j)[i1];
					if (cur < min) {
						min = cur;
						row = j;
					}
				}
				int count = 0, first = 0, second = 0;
				for (int j = 0; j < rows1.size(); j++) {
					int cur = rows1.get(j)[i1];
					if (cur == min) {
						count++;
						if (count == 2) {
							second = j;
							find = true;
							break;
						} else 
							first = j;
					}
				}
				if (!find) {
					target = i1;
					break;
				} else {
					rows1.remove(second);
					rows1.remove(first);
				}
			}
			ArrayList<Integer> set = new ArrayList<>();
			for (int[] a : rows) {
				set.add(a[target]);
			}
			for (int a : rows1.get(row)) {
				if (a == min) continue;
				for (int i2 = 0; i2 < set.size(); i2++) {
					if (set.get(i2) == a) {
						set.remove(i2);
						break;
					}
				}
			}
			Collections.sort(set);
			StringBuilder result1 = new StringBuilder(set.size());
			for (int a : set) {
				result1.append(a + " ");
			}
			result[i] = result1;
			System.out.println(i);
		}
		PrintWriter out = new PrintWriter(outputFileName);
		for (int i = 0; i < result.length; i++) {
			String s = "Case #" + (i + 1) + ": " + result[i];
			out.println(s);
		}
		out.close();
		scanner.close();
	}

}
