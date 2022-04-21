package googlejam2.p184;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by karlicos on 12.04.15.
 */
public class A {
  public static final String YES = "YES";
  public static final String NO = "NO";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int tests = in.nextInt();
	for (int test = 0; test < tests; test++) {
	  int n = in.nextInt();
	int[] dist = new int[n + 1];
	boolean[] used = new boolean[n + 1];
	Arrays.fill(dist, Integer.MAX_VALUE);
	
	Queue<Integer> queue = new ArrayDeque<Integer>();
	queue.add(1);
	dist[1] = 1;
	used[1] = true;
	while (!queue.isEmpty()) {
	  Integer top = queue.poll();
	  int td = dist[top];
	  int n1 = top + 1;
	int n3 = top;
	int res = 0;
	while (n3 != 0) {
	  res *= 10;
	  res += n3 % 10;
	  n3 /= 10;
	}
	  int n2 = res;
	  if (n1 > 0 && n1 <= n) {
	    dist[n1] = Math.min(dist[n1], td + 1);
	    if (!used[n1]) {
	      used[n1] = true;
	      queue.add(n1);
	    }
	  }
	  if (n2 > 0 && n2 <= n) {
	    dist[n2] = Math.min(dist[n2], td + 1);
	    if (!used[n2]) {
	      used[n2] = true;
	      queue.add(n2);
	    }
	  }
	}
	  int ans = dist[n];
	  out.println(String.format("Case #%d: %s", test + 1, ans));
	  out.flush();
	}
	
	in.close();
	out.close();
  }

}
