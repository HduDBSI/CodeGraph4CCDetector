package googlejam6.p256;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ProbB
{


	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer myTokens = new StringTokenizer(in.readLine());
		
		int T = Integer.parseInt(myTokens.nextToken());
		
		for (int i=0; i<T; i++)
		{
			myTokens = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(myTokens.nextToken());
						
			int[] heights = new int[2501];
			
			for (int j=0; j<2*N-1; j++)
			{
				myTokens = new StringTokenizer(in.readLine());
				
				
				for (int k=0; k<N; k++)
				{
					heights[Integer.parseInt(myTokens.nextToken())]++;
				}
				
				
				
			}
			
			
			System.out.print("Case #" + (i+1) + ":");
			
			for (int q=0; q<2501; q++)
			{
				if (heights[q]%2 == 1)
				{
					System.out.print(" " + q);
				}
			}
			
			System.out.println("");
			
			
		}
		

	}
	

}
