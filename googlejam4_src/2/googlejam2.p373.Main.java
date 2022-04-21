package googlejam2.p373;
import java.io.*;
import java.util.*;

class Main
{
	static int dp[]=new int[1000002];


	public static void main(String args[]) throws Exception
	{
		// BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter pw = new PrintWriter(System.out);

		BufferedReader br = new BufferedReader(new 	FileReader("in.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("try.out"));

		int T = Integer.parseInt(br.readLine());
		int TT = T;
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[1]=1;

		for (int i = 1;i<dp.length-1;i++)
		{
			dp[i+1]=Math.min(dp[i]+1,dp[i+1]);
			dp[reverse(i)]=Math.min(dp[i]+1,dp[reverse(i)]);
		}


		while (T-- > 0)
		{
			int goal = Integer.parseInt(br.readLine());
			



			pw.println("Case #"+(TT-T)+": "+dp[goal]);
			// System.out.println("FOOBAR"); 	
		}

		pw.close();
	}


	static int reverse(int str)
	{
		StringBuilder sb = new StringBuilder(Integer.toString(str));
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}

}