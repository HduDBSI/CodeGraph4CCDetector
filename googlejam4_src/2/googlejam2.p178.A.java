package googlejam2.p178;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("A-small-attempt0.in"));
    PrintWriter out = new PrintWriter(new File("A-small-attempt0.out"));

    int T = in.nextInt();
    for (int t = 1; t <= T; t++) {
      
      int n = in.nextInt();
      int dp[] = new int[n+1];
      dp[1] = 1;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(1);
      
      while(!q.isEmpty()) {
        int at = q.poll();
        int moves = dp[at];
        if (at == n) break;
        
        int next = at + 1;
        if (next <= n && dp[next] == 0) {
          dp[next] = moves + 1;
          q.add(next);
        } 
        int tmp = at;
        next = 0;
        while (tmp > 0) {
          next = next*10 + tmp % 10;
          tmp /= 10;
        }
        if (next <= n && dp[next] == 0) {
          dp[next] = moves + 1;
          q.add(next);
        } 
      }
      
      out.println("Case #" + t + ": " + dp[n]);
    }

    out.close();
  }

}
