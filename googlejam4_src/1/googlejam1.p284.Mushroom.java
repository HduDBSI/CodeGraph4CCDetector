package googlejam1.p284;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Mushroom{

	
	public static void main(String[] args) throws IOException
	{
		Mushroom solution = new Mushroom();

		Scanner input = new Scanner( new File( "A-large.in"));
		//Scanner input = new Scanner( new File( "DijkstraInput.txt"));
		//Scanner input = new Scanner( new File( "MissedCases.txt"));
		PrintWriter writer = new PrintWriter( "MushroomOutput.txt");
		int numCases = Integer.parseInt( input.nextLine());
		for ( int x = 0; x < numCases; x++)
		{
			int numPlates = Integer.parseInt(input.nextLine());
			String tempLine = input.nextLine(); 
			
			ArrayList<Integer> nums = new ArrayList<Integer>();
			StringTokenizer io = new StringTokenizer(tempLine);
			while(io.hasMoreTokens())
			{
				nums.add(Integer.parseInt(io.nextToken()));
			}
			int firstAttempt = 0;
			int secondAttempt = 0;
			for ( int i = 0; i < nums.size()-1; i++)
			{
				int first = nums.get(i);
				int second = nums.get(i+1);
				
				if ( (first - second) >= 0)
				{
					firstAttempt = firstAttempt + (first- second);
				}
				
			}
			int maxDrop = 0;
			for ( int i = 0; i < nums.size() - 1; i++)
			{
				int first = nums.get(i);
				int second = nums.get(i+1);
				int tempDrop = first-second;
				if ( tempDrop > maxDrop)
				{
					maxDrop = tempDrop;
				}
			}
			double rate = maxDrop/10;
			for ( int i = 0; i < nums.size() - 1; i++)
			{
				int tempStack = nums.get(i);
				if ( tempStack >= maxDrop)
				{
					secondAttempt+= maxDrop;
				}
				else
				{
					secondAttempt += tempStack;
				}
			}
			writer.println("Case #" + (x+1) + ": " + firstAttempt + " " + secondAttempt);
		
		}
		writer.close();

	}

	

	
	

	
}