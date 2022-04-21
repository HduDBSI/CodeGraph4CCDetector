package googlejam2.p108;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a {
	static int MAX = 1000000;
	static int[] best = new int[MAX + 1];
	static {
		Queue<Integer> q = new LinkedList<>();
		best[1] = 1;
		q.add(1);
		while (!q.isEmpty()) {
			int n = q.poll();
			int x = best[n] + 1;
			if (n < MAX && (best[n + 1] == 0 || best[n + 1] > x)) {
				best[n + 1] = x;
				q.add(n + 1);
			}
			int k = 0;
			int m = n;
			while (m != 0) {
				k = k * 10 + (m % 10);
				m = m / 10;
			}
			if (k < MAX && (best[k] == 0 || best[k] > x)) {
				best[k] = x;
				q.add(k);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int caseNum = 1; caseNum <= t; caseNum++) {
			int n = sc.nextInt();
			System.out.println("Case #" + caseNum + ": " + best[n]);
		}
	}
}
