package googlejam1.p378;
import java.util.*;
import java.io.*;
import java.math.*;

public class shrooms
{
	public static void main(String [] args) throws Exception
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter the filename");
		String filename = inScan.nextLine();
		BufferedReader b = new BufferedReader(new FileReader(filename));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));

		int numExamples = Integer.parseInt(b.readLine());
		for(int i = 0; i < numExamples; i++)
		{
			int numIntervals = Integer.parseInt(b.readLine());
			int [] mushrooms = new int [numIntervals];
			String [] stuff = b.readLine().split(" ");
			for(int j = 0; j < numIntervals; j++)
			{
				mushrooms[j] = Integer.parseInt(stuff[j]);
			}
			//First method
			BigInteger sumOne = new BigInteger("0");;
			int bigIndex = -1;
			int bigDiff = -1;
			for(int j = 0; j < numIntervals-1; j++)
			{
				if(mushrooms[j] > mushrooms[j+1])
				{
					int diff = mushrooms[j] - mushrooms[j+1];
					sumOne = sumOne.add(new BigInteger(Integer.toString(diff)));
					if(diff > bigDiff)
					{
						bigDiff = diff;
						bigIndex = j;
					}
					
				}
				
			}
			BigInteger sumTwo = new BigInteger("0");
			if(bigDiff > -1)
			{
				for(int j = 0; j < numIntervals-1;j++)
				{
					if(mushrooms[j] >= bigDiff)
						sumTwo = sumTwo.add(new BigInteger(Integer.toString(bigDiff)));
					else
						sumTwo = sumTwo.add(new BigInteger(Integer.toString(mushrooms[j])));				}
			}
			//Code goes here********
			out.print("Case #" + (i+1) + ": " +  sumOne.toString() + " " + sumTwo.toString());
			if(i != numExamples-1)
				out.println();
			out.flush();
		}
		
		out.close();
	}
	
	
}