package googlejam8.p836;
import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    //in.useDelimiter("\n");
	    
	    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    //in.nextLine();
	    
	    String pts = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	    int N;
	    int[] P;
	    // loop each test case
		for (int t = 1; t <= T; ++t) 
		{
			System.out.print("Case #" + t + ":");
			N = in.nextInt(); // Number of parties
			P = new int[N];
			// loop each party total
			for (int n = 0; n < N; n++)
			{
				P[n] = in.nextInt();
			}
			Boolean done = false;
			
			while (!done)
			{
				// find largest party
				int max1 = -1;
				int max2 = -1;
				int ind = -1;
				int ind2 = -1;
				int sum = 0; 
				
				// find first largest
				for (int n = 0; n < N; n++)
				{
					if (P[n] > max1) {
						max1 = P[n];
						ind = n;
					}
					sum += P[n];
				}
				// find second largest
				for (int n = 0; n < N; n++)
				{
					if (n != ind && P[n] > max2) {
						max2 = P[n];
						ind2 = n;
					} 
				}
				
				if (sum == 0)
				{
					done = true;
					break;
				}
				else if ((sum % 2 != 0) || sum == 1)
				{
					P[ind]--;
					System.out.print(" " + pts.charAt(ind));
				}
				else if (max1 == max2)
				{
					// evac 2 parties
					P[ind]--;
					P[ind2]--;
					System.out.print(" " + pts.charAt(ind) + pts.charAt(ind2));
				}
				else
				{
					P[ind] = P[ind] - 2;
					System.out.print(" " + pts.charAt(ind) + pts.charAt(ind));
				}
				/*
				else if (sum )
				{					
					if (ind2 != -1 && P[ind] == P[ind2])
					{
						// evac 2 parties
						P[ind]--;
						P[ind2]--;
						System.out.print(" " + pts.charAt(ind) + pts.charAt(ind2));
					}

				}*/
				
				
			}
			System.out.print('\n');
		}
		in.close();
	}
}