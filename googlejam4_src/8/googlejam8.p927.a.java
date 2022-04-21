package googlejam8.p927;
import java.util.*;

public class a {
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		int n;
		int parties[] = new int[0];
		
		for (int i = 0; i < cases; i++)
		{
			n = in.nextInt();			
			parties = new int[n];
			System.out.println();
			System.out.print("Case #"+(i+1)+": ");
			
			for (int j = 0; j < n; j++)
			{				
				parties[j] = in.nextInt();
			}
			
			// evacuate the suckers if 2 party system
			if (n == 2)
			{
				for (int k = 0; k < parties[0]; k++)
				{
					System.out.print("AB ");
				}					
			}
			// else evacuate the fools
			else
			{
				int winner = 0;
				int runnerup = 0;
				int loser = 0; 
				int windex = 0;
				int rindex = 0;
				int lindex = 0;
				
				
				// figure out whos in charge
				for (int l = 0; l < n; l++)
				{
					if (parties[l] > winner)
					{
						loser = runnerup;
						lindex = rindex;
						runnerup = winner;
						rindex = windex;
						winner = parties[l];
						windex = l;						
					}
					else if (parties[l] > runnerup)
					{
						loser = runnerup;
						lindex = rindex;
						runnerup = parties[l];
						rindex = l;
					}
					else
					{
						loser = parties[l];
						lindex = l;
					}
				}
				
				// get the majority out first
				while (parties[windex] > parties[rindex])
				{
					char win = (char) ('A' + windex);
					System.out.print(win+" ");
					parties[windex] -= 1;
				}
				// then clear out the losers
				while (parties[lindex] > 0)
				{
					char los = (char) ('A' + lindex);
					System.out.print(los+" ");
					parties[lindex] -= 1;
				}
				// then march the rest out holding hands
				while (parties[windex] > 0)
				{
					char win = (char) ('A' + windex);
					char rin = (char) ('A' + rindex);
					System.out.print(win+""+ rin+" ");
					parties[windex] -= 1;
					parties[rindex] -= 1;
				}
				
			}
		}
		
		in.close();
	}
}
