package googlejam1.p631;
import java.io.*;
import java.util.*;


public class mushrooms {
	
	public static void main (String args[]) throws IOException
	{
		BufferedReader cin  = new BufferedReader(new FileReader("c:\\input.txt"));
		//BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter cout = new PrintWriter("c:\\users\\johng_000\\desktop\\output.txt");
		StringTokenizer st = new StringTokenizer(cin.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int count = 0; count < T; count++)
		{
			st = new StringTokenizer (cin.readLine());
			int N = Integer.parseInt(st.nextToken());
			int [] mu = new int [N];
			st = new StringTokenizer (cin.readLine());
			for (int i = 0; i < N; i++)
			{
				mu[i] = Integer.parseInt(st.nextToken());
			}
			long firstMethod = 0;
			long secondMethod = 0;
			long max = mu[0] - mu[1];
			for (int i = 2; i < N; i++)
			{
				if (mu[i-1] - mu[i] > max)
					max = mu[i-1] - mu[i];
			}
			for (int i = 1; i < N; i++)
			{
				if (mu[i-1] > mu[i])
					firstMethod += mu[i-1] - mu[i];		
			}
			for (int i = 0; i < N-1; i++)
			{
				if (mu[i] > max)
					secondMethod += max;
				else
				{
					secondMethod += mu[i];
				}
			}
			cout.println("Case #" + (count + 1) +": " + firstMethod + " " + secondMethod);
		}
		cout.close();
	}
}
