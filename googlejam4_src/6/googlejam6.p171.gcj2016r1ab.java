package googlejam6.p171;
import java.util.*;
import java.io.*;

public class gcj2016r1ab {
	
	private static Scanner sc;
	private static PrintStream ps;
	
	public static void main(String[] args) throws IOException {
		sc = new Scanner(new File("infile.txt"));
		ps = new PrintStream(new FileOutputStream(new File("outfile.txt")));
		//
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ps.format("Case #%d:", t);
			//
			int n = sc.nextInt();
			int n2 = (2 * n - 1) * n;
			//int[][] grid = new int[n][n];
			Map<Integer, Integer> count = new TreeMap<>();
			for (int i = 0; i < n2; i++) {
				int j = sc.nextInt();
				if (!count.containsKey(j))
					count.put(j, 0);
				count.put(j, count.get(j) + 1);
			}
			//
			List<Integer> ans = new ArrayList<>();
			for (Integer i : count.keySet()) {
				if (count.get(i) % 2 == 1)
					ans.add(i);
			}
			for (Integer i : ans)
				ps.print(" " + i);
			ps.println();
		}
	}

}
