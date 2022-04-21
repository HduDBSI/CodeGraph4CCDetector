package googlejam1.p645;


import java.io.File;
import java.util.Scanner;

public class A
{

	//public static String fileName = "res/r1a-A-sample.in";
	//public static String fileName = "res/r1a-A-small-attempt0.in";
	//public static String fileName = "res/r1a-A-small-attempt1.in";
	public static String fileName = "res/r1a-A-large.in";
			
	
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(new File(fileName));
		
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++)
		{
			int N = scanner.nextInt();
			int[] in = new int[N];
			for (int j = 0; j < N; j++)
			{
				in[j] = scanner.nextInt();
			}
			long out = 0;
			int start = 0;		
			for (int i1 = 0; i1 < in.length; i1++)
			{
				if (in[i1] > start)
				{
					start = in[i1];
				}
				else
				{
					out += (start - in[i1]);
					start = in[i1];
				}
			}
			
			long y = out;
			// max difference is at least 1 rate
			int maxDiff = 0;
			long out1 = 0;
			for (int i2 = 0; i2 < in.length - 1; i2++)
			{
				if ( (in[i2] - in[i2+1] > maxDiff))
				{
					maxDiff = (in[i2] - in[i2+1]);
				}
			}
			
			long rate = maxDiff;
			for (int i1 = 0; i1 < in.length - 1; i1 ++)
			{
				out1 += Math.min(rate, in[i1]);
			}
			long z = out1;
			
			System.out.println("Case #" + (i+1) + ": " + y + " " + z);
		}
		
		scanner.close();
	}

}
