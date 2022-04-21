package googlejam1.p314;
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cases; i++)
		{
			System.out.print("Case #" + (i+1) + ": ");
			
			int periods = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] mushrooms = new int[periods];
			for(int j = 0; j < periods; j++)
			{
				mushrooms[j] = Integer.parseInt(st.nextToken());
			}
			
			int eaten = 0;
			int prev = mushrooms[0];
			for(int i1 = 1; i1 < mushrooms.length; i1++)
			{
				if(mushrooms[i1] < prev)
				{
					eaten += prev - mushrooms[i1];
				}
				prev = mushrooms[i1];
			}
			
			System.out.print("" + eaten);
			int maxInPeriod = 0;
			int prev1 = mushrooms[0];
			for(int i2 = 1; i2 < mushrooms.length; i2++)
			{
				if((prev1 - mushrooms[i2]) > maxInPeriod)
				{
					maxInPeriod = prev1 - mushrooms[i2];
				}
				prev1 = mushrooms[i2];
			}
			
			int eaten1 = 0;
			prev1 = mushrooms[0];
			for(int i1 = 1; i1 < mushrooms.length; i1++)
			{
				int potentiallyEaten = mushrooms[i1] - prev1;
				if(prev1 < maxInPeriod)
				{
					eaten1 += prev1;
				}
				else
				{
					eaten1 += maxInPeriod;
				}
				
				prev1 = mushrooms[i1];
			}
			
			int answer = maxInPeriod * (mushrooms.length-1);
			System.out.println(" " + eaten1);
		}
	}

}	
