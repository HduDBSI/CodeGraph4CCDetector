package googlejam6.p574;
import java.io.*;
import java.util.*;

public class probB 
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("B-large.in"));
		PrintWriter out = new PrintWriter(new File("fileBoutput.txt"));
		int times = Integer.parseInt(in.nextLine());
		for(int i = 0; i<times; i++)
		{
			int size = in.nextInt();
			in.nextLine();
			
			Set<Integer> odds = new TreeSet<>();
			
			for (int j = 0; j < size*2-1; j++) 
			{
				for (int k = 0; k < size; k++) 
				{
					int h = in.nextInt();
					
					if (odds.contains(h))
						odds.remove(h);
					else
						odds.add(h);
				}
			}
			Iterator<Integer> remain = odds.iterator();
			String result = "";
			while(remain.hasNext()) 
				result += (remain.next() + " ");
			System.out.println("Case #" + (i+1) + ": " + result);
			out.println("Case #" + (i+1) + ": " + result);
		}
		in.close();
		out.close();
	}	
}
