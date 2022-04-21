package googlejam3.p549;
import java.util.*;
import java.io.*;
import java.math.*;

public class A
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
			String[] line = b.readLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			int numPerRow = (int)Math.ceil((double)c/(double)w);
			int total = numPerRow*r;
			total = total + w-1;
			
			out.print("Case #" + (i+1) + ": " + total);
			if(i != numExamples-1)
				out.println();
			out.flush();
		}
		
		out.close();
	}
	
	
}