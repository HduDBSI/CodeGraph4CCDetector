package googlejam11.p119;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BSmall {

  static final String FILENAME = "B-small-attempt1";
  static final String IN = FILENAME + ".in";
  static final String OUT = FILENAME + ".out";
  Scanner sc;
  BufferedWriter out;
  
  public static void main(String args[]) throws Exception {
    BSmall r = new BSmall();
	r.sc = new Scanner(new File(BSmall.IN));
	r.out = new BufferedWriter(new FileWriter(BSmall.OUT));
	int t = r.sc.nextInt();
	for (int i = 1; i <= t; i++) {
	  r.out.write("Case #" + i + ": ");
	  int n = r.sc.nextInt();
	int k = r.sc.nextInt();
	double[] p = new double[n];
	for(int i2 = 0; i2 < n; i2++) {
	  p[i2] = r.sc.nextDouble();
	}
	double ans = -1;
	for(int msk = 0; msk < (1 << n); msk++) {
	  if(Integer.bitCount(msk) != k) {
	    continue;
	  }
	  int[] idx = new int[k + 1];
	  int c = 0;
	  int l = 0;
	  while(c < n) {
	    if((msk & (1 << c)) > 0) {
	      idx[l] = c;
	      l++;
	    }
	    c++;
	  }
	  double[][] dp = new double[k + 1][k + 1];
	  for(int i1 = 1; i1 <= k; i1++) {
	    for(int j = 0; j <= k/2; j++) {
	      if(j == 0) {
	        dp[i1][j] = 1;
	        for(int x = 0; x < i1; x++) {
	          dp[i1][j] *= 1 - p[idx[x]];
	        }
	      } else if(i1 < j) {
	        dp[i1][j] = 0;
	      } else if(i1 == j) {
	        dp[i1][j] = 1;
	        for(int x = 0; x < i1; x++) {
	          dp[i1][j] *= p[idx[x]];
	        }
	      } else {
	        dp[i1][j] = dp[i1 - 1][j - 1] * p[idx[i1 - 1]] + dp[i1 - 1][j] * (1 - p[idx[i1 - 1]]);
	      }
	    }
	  }
	  ans = Math.max(ans, dp[k][k/2]);
	}
	r.out.write(Double.toString(ans));
	r.out.newLine();
	}
	r.sc.close();
	r.out.close();
  }
}
