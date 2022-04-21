package googlejam2.p289;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CounterCulture {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(
				"C:/Users/Ahmed/Desktop/Codejam_1/A-small-attempt1.in"));
		// Scanner scan = new Scanner(System.in);
		// PrintWriter print = new PrintWriter("a.out");

		int lines = scan.nextInt();
		for (int l = 0; l < lines; l++) {
			int n = scan.nextInt();

			Queue<Integer> queue = new LinkedList<Integer>();

			queue.add(1);
			queue.add(1);
			int max = (int) (Math.pow(10, 6) + 3);
			boolean[] visited = new boolean[max + 1];
			while (!queue.isEmpty()) {
				int o = queue.poll();
				int steps = queue.poll();
				if (o == n) {
					System.out.println("Case #" + (l + 1) + ": " + steps);
					break;
				}
				if (o + 1 < max && !visited[o + 1]) {
					visited[o + 1] = true;
					queue.add(o + 1);
					queue.add(steps + 1);
				}
				String s = o + "";
				String output = "";
				for (int i = 0; i < s.length(); i++) {
					output = s.charAt(i) + output;
				}
				int rev = Integer.parseInt(output);
				if (rev < max && !visited[rev]) {
					visited[rev] = true;
					queue.add(rev);
					queue.add(steps + 1);
				}
			}
//			System.out.println(l);
		}
	}
}
