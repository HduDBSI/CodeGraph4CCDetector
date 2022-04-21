package googlejam2.p116;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class countSmall {
	public static void main(String[] args) {
		int inf = 20000000;
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		int cn = 0;
		
		while (cn++ < cases) {
			int n =in.nextInt();
			
			int[] cost = new int[n+1];
			Arrays.fill(cost, inf);
			cost[0] = 0;
			ArrayDeque<Integer> bfs = new ArrayDeque<Integer>(n);
			bfs.add(0);
			
			while (bfs.size() > 0) {
				int here = bfs.poll();
				
				if (here != n) {
					if (cost[here+1] == inf) {
						cost[here+1] = cost[here]+1;
						bfs.add(here+1);
					}
					StringBuilder s = new StringBuilder();
					s.append(here);
					s.reverse();
					
					int rev = Integer.parseInt(s.toString());
					if (rev <= n && cost[rev] == inf) {
						cost[rev] = cost[here]+1;
						bfs.add(rev);
					}
					
				}
			}
			
			System.out.printf("Case #%d: %d\n", cn, cost[n]);
			
		}
	}
}
