package googlejam6.p537;
import java.util.*;

public class template2
{
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		/*
		fakemain(0);//*/
		
		
		int TC = in.nextInt();
		for(int tc = 1; tc <= TC; tc++)
		{
			int N = in.nextInt();
			
			int[][] list = new int[2*N - 1][N];
			
			int[] count = new int[2501];
			for(int l = 0; l < list.length; l++)
			{
				for(int n = 0; n < N; n++)
				{
					list[l][n] = in.nextInt();
					count[list[l][n]]++;
				}
			}
			
			// look for odd numbers
			PriorityQueue<Integer> odds = new PriorityQueue<Integer>();
			for(int ZSOI = 0; ZSOI < 2501; ZSOI++)
			{
				if((count[ZSOI] & 1) == 1)
				{
					odds.offer(ZSOI);
				}
			}
			
			System.out.print("Case #"+tc+":");
			while(!odds.isEmpty())
			{
				System.out.print(" "+odds.poll());
			}
			System.out.println();
		}//*/
		
		/*
		for(int TC = in.nextInt(); TC != 0; TC = in.nextInt())
		{
			fakemain(TC);
		}//*/
	}
}
