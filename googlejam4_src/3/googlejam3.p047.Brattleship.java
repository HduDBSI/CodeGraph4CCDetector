package googlejam3.p047;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Brattleship {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("brattleship.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int[] dp = new int[c+1];
				dp[w] = w + r - 1;
				for(int j = w + 1; j <= 2*w - 1; j++)
				{
					if(j > c)
						break;
					dp[j] = w+1 + r-1;
				}
				for(int j = 2*w; j <= c; j++)
				{
					dp[j] = Math.max(dp[j-w] + r, w + 1);
				}
				System.out.println("Case #" + i + ": " + dp[c]);
				fout.write("Case #" + i + ": " + dp[c] + "\n");
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}


	}

}
