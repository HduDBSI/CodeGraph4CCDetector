package googlejam9.p035;

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int testNum = 1; testNum <= tests; testNum++)
		{
			System.out.print("Case #" + testNum + ": ");
			int buildings = sc.nextInt();
			long ways = sc.nextLong();
			
			if(ways > Math.pow(2, buildings - 2))
				System.out.println("IMPOSSIBLE");
			else if(buildings == 2)
			{
				//Special case for n = 2
				System.out.println("POSSIBLE");
				if(ways == 0)
					System.out.println("00\n00");
				else if(ways == 1)
					System.out.println("01\n00");
			}
			else if(ways == Math.pow(2, buildings - 2))
			{
				System.out.println("POSSIBLE");
				for(int i = 0; i < buildings; i++)
				{
					for(int j = 0; j < buildings; j++)
					{
						if(i < j)
							System.out.print("1");
						else
							System.out.print("0");
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println("POSSIBLE");
				
				int[][] edges = new int[buildings][buildings];
				//Create 2^(i - 1) ways to reach building i
				for(int i = 0; i < buildings - 1; i++)
				{
					for(int j = i + 1; j < buildings - 1; j++)
						edges[i][j] = 1;
				}
				
				//Find binary representation to add edges to last building
				for(int i = 0; i < buildings - 1; i++)
				{
					if((1L << i & ways) > 0)
						edges[i + 1][buildings - 1] = 1;
				}
				
				for(int i = 0; i < buildings; i++)
				{
					for(int j = 0; j < buildings; j++)
					{
						System.out.print(edges[i][j]);
					}
					System.out.println();
				}
				
				//countWays(edges);
			}
		}
	}
}
