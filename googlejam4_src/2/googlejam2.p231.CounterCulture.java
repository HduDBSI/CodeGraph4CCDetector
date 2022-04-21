package googlejam2.p231;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CounterCulture {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		// for (int _ = 1; _ <= t; _++) {
		// long n = in.nextLong();
		// int r = 1;
		// while (n > 1) {
		// long temp = Long.parseLong(new StringBuffer("" + n).reverse()
		// .toString());
		// r++;
		// if (temp < n && n % 10 != 0)
		// n = temp;
		// else
		// n--;
		// }
		// System.out.println("Case #" + _ + ": " + r);
		// }
		int MAX = 1000001;
		LinkedList<Integer>[] E = new LinkedList[MAX];
		for (int i = 1; i < MAX; i++) {
			E[i] = new LinkedList<Integer>();
			E[i].add(i + 1);
			int temp = Integer.parseInt(new StringBuffer("" + i).reverse()
					.toString());
			if (i % 10 != 0)
				E[i].add(temp);
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		int[] r = new int[MAX];
		boolean[] visited = new boolean[MAX];
		Q.add(1);
		visited[1] = true;
		r[1] = 1;
		while (!Q.isEmpty()) {
			int temp = Q.poll();
			for (int x : E[temp])
				if (x < MAX && !visited[x]) {
					visited[x] = true;
					r[x] = r[temp] + 1;
					Q.add(x);
				}
		}
		int t = in.nextInt();
		for (int _ = 1; _ <= t; _++) {
			int n = in.nextInt();
			System.out.println("Case #" + _ + ": " + r[n]);
		}
	}
}
