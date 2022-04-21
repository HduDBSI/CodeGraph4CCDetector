package googlejam1.p082;
import java.util.Scanner;

public class A {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int Q = 1; Q <= T; Q++)
		{
			int N = scan.nextInt();
			
			int[] pieces = new int[N];
			int anytime = 0;
			int maxDiff = -1;
			
			for (int i = 0; i < N; i++)
			{
				pieces[i] = scan.nextInt();
				
				if (i > 0)
				{
					int diff = pieces[i - 1] - pieces[i];
					
					if (diff > 0)
					{
						anytime += diff;
					}
					
					if (diff > maxDiff)
					{
						maxDiff = diff;
					}
				}
			}
			
			int constant = 0;
			
			if (maxDiff > 0)
			{
				for (int i = 0; i < N - 1; i++)
				{
					if (pieces[i] > maxDiff)
					{
						constant += maxDiff;
					}
					else
					{
						constant += pieces[i];
					}
				}
			}
			
			System.out.printf("Case #%d: %d %d\n", Q, anytime, constant);
		}
		
		scan.close();
	}
}
