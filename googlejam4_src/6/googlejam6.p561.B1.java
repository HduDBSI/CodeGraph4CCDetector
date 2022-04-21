package googlejam6.p561;
import java.util.*;

class Main {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		// System.out.println("here");
		StringBuilder out = new StringBuilder();
		for (int h = 1; h <= numCases; h++) {
			int [] heights = new int[2501];
			int n = sc.nextInt();
			for (int i = 0; i < (2*n)-1; i++) {
				for (int k = 0; k < n; k++) {
					int val = sc.nextInt();
					heights[val]++;
				}
			}
			// System.out.println("Heights: " + Arrays.toString(heights));
			
			out.append(String.format("Case #%d:", h));
			for (int i = 0; i < heights.length; i++) {
				if (heights[i] % 2 == 1) {
					out.append(" " + i);
				}
			}
			out.append("\n");
		}
		System.out.print(out+"");
	}
}