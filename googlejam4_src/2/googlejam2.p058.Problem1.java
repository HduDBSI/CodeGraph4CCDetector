package googlejam2.p058;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1 {
	public static void main(String args[]) throws IOException
	{
		long t = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		Arrays.fill(dp, Long.MAX_VALUE/10);
		dp[0] = 0;
		for(int i=1; i<1000001; i++)
		{
			dp[i] = Math.min(1 + dp[i-1], dp[i]);
			if(i % 10 != 0) dp[i] = Math.min(dp[i], 1 + dp[rev(i)]);
		}
		for(int ii = 1; ii <= T; ii++)
		{		
			int N = Integer.parseInt(br.readLine());
			System.out.println("Case #"+ii+": "+dp[N]);
		}
		System.out.println(System.currentTimeMillis()-t);
	}
	public static int rev(int N)
	{
		String s = N+"";
		s = new StringBuffer(s).reverse().toString();
		return Integer.parseInt(s);
	}
}