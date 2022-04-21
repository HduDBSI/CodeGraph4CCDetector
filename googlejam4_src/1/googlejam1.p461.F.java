package googlejam1.p461;
import java.io.*;
import java.util.*;

class F
{
	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		int nData = in.nextInt();
		in.nextLine();
		
		for (int asdf = 0; asdf < nData; asdf++)
		{
			//solve the problem
			int size = in.nextInt();
			int[] items = new int[size];
			
			for (int i = 0; i < size; i++)
			{
				int num = in.nextInt();
				items[i] = num;
			}
			
			int prev = -1;
			int total1 = 0;
			
			//method one
			for (int i = 0; i < size; i++)
			{
				int num = items[i];
				int minEaten = prev - num;
				
				if ((prev != -1) && (minEaten > 0))
				{
					total1 += minEaten;
				}
				
				prev = num;
			}
			
			//method 2
			int rate = -1;
			int total2 = 0;
			
			//find the rate of eating
			for (int i = 1; i < size; i++)
			{
				int minEaten = items[i-1] - items[i];
				
				if ((rate == -1) || (minEaten > rate))
				{
					rate = minEaten;
				}
			}
			
			//find the amount eaten
			for (int i = 1; i < size; i++)
			{
				if (items[i-1] < rate)
				{
					total2 += items[i-1];
				}
				else
				{
					total2 += rate;
				}
			}
			
			System.out.println("Case #" + (asdf+1) + ": " + total1 + " " + total2);
		}
	}
}