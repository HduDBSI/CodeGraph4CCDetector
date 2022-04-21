package googlejam6.p564;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class RankAndFile {
	public final static int MAX = 2500;
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);

		int testCases = Integer.parseInt(rd.readLine());
		int testCase = 1;
		
		while (testCases-- > 0) {
			wr.print("Case #" + testCase++ + ": ");
			int n = Integer.parseInt(rd.readLine());
			
			int[] array = new int[MAX + 1];
			
			for (int i = 0; i < 2 * n - 1; i++) {
				String[] tokens = rd.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					array[Integer.parseInt(tokens[j])]++;
				}
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for (int i = 1; i <= MAX; i++) {
				if (array[i] % 2 != 0) { 
					list.add(i);
				}
			}
			
			Collections.sort(list);
			
			for (int i : list) {
				wr.print(i + " ");
			}
			wr.println();
		}

		wr.close();
	}
}

