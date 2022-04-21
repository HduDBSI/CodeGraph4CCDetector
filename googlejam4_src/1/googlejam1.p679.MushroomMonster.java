package googlejam1.p679;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MushroomMonster 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner (new File("MushroomMonster.in"));
		BufferedWriter fw = new BufferedWriter(new FileWriter(new File("MushroomMonster.out")));
		int T = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 1; caseNum <= T; caseNum++)
		{
			int x = sc.nextInt();
			ArrayList<Integer> timeIntervals = new ArrayList<Integer>();
			for(int i = 0; i<x; i++)
				timeIntervals.add(sc.nextInt());
			int finalCase1Amount = 0;
			int previous = timeIntervals.get(0);
			int next = 0;
			int maximumDifference = 0;
			int difference = 0;
			for (int i=1; i<timeIntervals.size(); i++)
			{
				next = timeIntervals.get(i);
				
				difference = previous-next;
				if (difference>0)
				{
					finalCase1Amount+=difference;
					if (difference>maximumDifference)
						maximumDifference = difference;
				}
				
				previous = timeIntervals.get(i);
			}
				
			int finalCase2Amount = 0;
			int total = 0;
			
			for (int i=0; i<timeIntervals.size()-1; i++)
			{
				total = timeIntervals.get(i);					
				if (total-maximumDifference<=0)
				{
					finalCase2Amount+=total;
					total = 0;
				}
				else
				{
					finalCase2Amount+=maximumDifference;
					total -= maximumDifference;
				}
			}

			fw.write("Case #"+caseNum+": "+finalCase1Amount+" "+finalCase2Amount+"\n");
		}
		fw.flush();
		fw.close();
		sc.close();
	}
}
