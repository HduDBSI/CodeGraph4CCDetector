package googlejam8.p245;
import java.io.*;
import java.util.Scanner;


public class Problem1
{
	private static PrintWriter writer;
	private static File file;
	private static Scanner scan;
	private static int testCases=0;

	public static void main(String[] args)
	{
		try
		{
			file = new File("codejaminput.in");
			scan = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
		    System.out.println("File 1 not found");
		}
		try
		{
			writer = new PrintWriter("output.in");
		}
		catch (FileNotFoundException e)
		{
		    System.out.println("File 2 not found");
		}
		testCases=scan.nextInt();
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		for (int j = 1; j<=testCases; j++)
		{
			String output="";
			int N = scan.nextInt();
			int[] senators = new int[N];
			for (int i =0; i < N; i++)
			{
				senators[i]=scan.nextInt();
			}
			boolean done = true;
			for (int i =0; i < N; i++)
			{
				if (senators[i]!=0)
					done=false;
			}
			while (!done)
			{
				int highest = 0;
				int highestIndex=-1;
				for (int i =0; i < N; i++)
				{
					if (senators[i]>highest)
					{
						highest=senators[i];
						highestIndex=i;
					}
				}
				boolean uneven = false;
				for (int i =0; i < N; i++)
				{
					if (senators[i]<highest&&senators[i]!=0)
					{
						uneven = true;
					}
				}
				if (uneven)
					{
						output+=alphabet[highestIndex]+" ";
						senators[highestIndex]-=1;
					}
				else
				{
					int count = 0;
					int indexOne = -1;
					int indexTwo = -1;
					for (int i =0; i < N; i++)
					{
						if (senators[i]!=0)
						{
							count++;
							if (indexOne==-1)
								indexOne=i;
							else
								indexTwo=i;
						}
					}
					if (count%2==0)
					{
						output+=alphabet[indexOne]+alphabet[indexTwo]+" ";
						senators[indexOne]-=1;
						senators[indexTwo]-=1;
					}
					else
					{
						output+=alphabet[indexOne]+" ";
						senators[indexOne]-=1;
					}
				}
				done = true;
				for (int i =0; i < N; i++)
				{
					if (senators[i]!=0)
						done=false;
				}
			}
			writer.println("Case #" + j + ": " + output);
		}
		writer.close();
		scan.close();
	}

}

