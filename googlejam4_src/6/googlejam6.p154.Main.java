package googlejam6.p154;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		int maxHeight = 2500;
		for(int testNum = 1; testNum <= tests; testNum++)
		{
			int n = sc.nextInt();
			int[] heightCounts = new int[maxHeight + 1];
			for(int i = 0; i < 2*n - 1; i++)
			{
				for(int j = 0; j < n; j++)
				{
					int nextHeight = sc.nextInt();
					heightCounts[nextHeight]++;
				}
			}
			
			System.out.print("Case #" + testNum + ": ");
			for(int i = 0; i <= maxHeight; i++)
			{
				if(heightCounts[i] % 2 == 1)
				{
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
}
