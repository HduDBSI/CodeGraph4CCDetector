package googlejam6.p044;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RankAndFile {
	public static void main(String[] args) throws Exception {
		 Scanner input = new Scanner(new File("input/b_large.in"));
		 PrintWriter output = new PrintWriter(new File("output/b_large.out"));
//		Sjanner input = new Scanner(System.in);
//		PrintWriter output = new PrintWriter(System.out);

		int testCases = input.nextInt();
		input.nextLine();
		primary: for (int casen = 1; casen <= testCases; casen++) {
			output.printf("Case #%d:", casen);
			
			int n = input.nextInt();
			Set<Integer> heights = new TreeSet<Integer>();
			for (int i = 1; i < 2 * n; i++) {
				for (int j = 0; j < n; j++) {
					int cur = input.nextInt();
					if (!heights.remove(cur)) {
						heights.add(cur);
					}
				}
			}
			for (int x : heights) {
				output.print(" " + x);
			}
			output.println();
			output.flush();
		}
		output.close();
	}
}