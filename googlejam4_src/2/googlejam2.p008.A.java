package googlejam2.p008;
import java.util.*;

public class A {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int T = sc.nextInt();
    for(int cs = 1; cs <= T; cs++) {
      int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
		  dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i < N; i++) {
		  dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
		int N1 = i;
		A r1 = new A();
		int r2 = 0;
		while(N1 > 0) {
		  r2 *= 10;
		  r2 += N1 % 10;
		  N1 /= 10;
		}
		  int r = r2;
		  if(r <= N) {
		    dp[r] = Math.min(dp[r], dp[i] + 1);
		  }
		}
	String res = "" + dp[N];
      System.out.println("Case #" + cs + ": " + res);
    }
    
    sc.close();
  }
  
}
