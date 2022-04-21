package googlejam11.p043;
import java.io.*;
import java.util.*;
import java.math.*;

public class B_large {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/B-large.in"))));

		String output = "";
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			double[] p = new double[n];
			for (int j = 0; j < n; j++)
				p[j] = sc.nextDouble();
			Arrays.sort(p);
			
			double max = 0;
			for (int j = 0; j <= k; j++) {
				double[][] dp = new double[k+1][k+1];
				dp[0][0] = 1;
				for (int a = 0; a < j; a++) {
					dp[a+1][0] += dp[a][0]*(1-p[a]);
					dp[a+1][a+1] += dp[a][a]*p[a];
					for (int b = 1; b <= a; b++) {
						dp[a+1][b] += dp[a][b]*(1-p[a]);
						dp[a+1][b] += dp[a][b-1]*p[a];
					}
				}
				for (int a = j; a < k; a++) {
					dp[a+1][0] += dp[a][0]*(1-p[n-(a-j)-1]);
					dp[a+1][a+1] += dp[a][a]*p[n-(a-j)-1];
					for (int b = 1; b <= a; b++) {
						dp[a+1][b] += dp[a][b]*(1-p[n-(a-j)-1]);
						dp[a+1][b] += dp[a][b-1]*p[n-(a-j)-1];
					}
				}
				if (dp[k][k/2] > max)
					max = dp[k][k/2];
			}
			
			output += "Case #" + i + ": " + max + "\n";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/B-large.out"), "utf-8"));
		bw.write(output);
		bw.close();
	}
}