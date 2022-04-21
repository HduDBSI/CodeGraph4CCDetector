package googlejam7.p301;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CloseMatch 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("C:\\Users\\Adam\\Documents\\codejam\\B-small-attempt0.in"));

		int cases = s.nextInt();
		s.nextLine();
		
		for (int i = 1; i <= cases; i++)
		{
			String line = s.nextLine();
			String scores[] = line.split(" ");
			String scorec = scores[0];
			String scorej = scores[1];
			
			ArrayList<String> cperms = new ArrayList<String>();
			cperms.add(scorec);
			boolean done = false;
			while (!done)
			{
				done = true;
				int j = 0;
				while (j < cperms.size())
				{
					String word = cperms.get(j);
					if (word.contains("?"))
					{
						
						done = false;
						String firstHalf = word.substring(0, word.indexOf("?"));
						String secondHalf = word.substring(word.indexOf("?") + 1);
						for (int k = 0; k < 10; k++)
						{
							cperms.add(firstHalf + k + secondHalf);
						}
						cperms.remove(word);
					}
					else
					{
						j++;
					}
				}
			}
			
			ArrayList<String> jperms = new ArrayList<String>();
			jperms.add(scorej);
			done = false;
			while (!done)
			{
				done = true;
				int j = 0;
				while (j < jperms.size())
				{
					String word = jperms.get(j);
					if (word.contains("?"))
					{
						
						done = false;
						String firstHalf = word.substring(0, word.indexOf("?"));
						String secondHalf = word.substring(word.indexOf("?") + 1);
						for (int k = 0; k < 10; k++)
						{
							jperms.add(firstHalf + k + secondHalf);
						}
						jperms.remove(word);
					}
					else
					{
						j++;
					}
				}
			}
			
			ArrayList<Integer> poss = new ArrayList<Integer>();
			
			for (String s1 : cperms)
			{
				for (String s2 : jperms)
				{
					int diff = Math.abs(Integer.valueOf(s1) - Integer.valueOf(s2));
					
					if (!poss.contains(diff))
						poss.add(diff);
				}
			}
			
			Collections.sort(poss);
			
			if (i == 1)
			{
				//for (String strin : cperms)
				//	System.out.println("C: " + strin);
				
				//for (String strin : jperms)
				//	System.out.println("J: " + strin);
			}
			
			done = false;
			int a = 0;
			while (!done && a < cperms.size())
			{
				int b = 0;
				
				while (!done && b < jperms.size())
				{
//System.out.println("C is " + cperms.get(a) + ", J is " + jperms.get(b));
					int diff = Math.abs(Integer.valueOf(cperms.get(a)) - Integer.valueOf(jperms.get(b)));
//System.out.println("case " + i + " diff is " + diff);
					if (diff == poss.get(0))
					{
						done = true;
						System.out.println("Case #" + i + ": " + cperms.get(a) + " " + jperms.get(b));
					}
					else
					{
						b++;
					}
				}
				
				a++;
			}
		}
		

	}
}
