package googlejam1.p501;
/**
 * Google Code Jam
 *
 * ***** Competition ********
 * ***** Problem ********
 */

import java.io.*;
import java.util.*;


public class AQ1
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] parms)
    {
        int numProbs;
		
		numProbs = sc.nextInt();
		
		for (int i=1; i<=numProbs; i++)
		{
		    System.out.format("Case #%d: ", i);
			int numTrials = sc.nextInt();
			
			int[] t = new int[numTrials];
			for (int i3=0; i3<numTrials; i3++)
			{
			    t[i3]=sc.nextInt();
			}
			
			//method 1
			int total = 0;
			for (int i4=0; i4<(numTrials-1); i4++)
			{
			    if (t[i4] > t[i4+1]) total += t[i4]-t[i4+1];
			}
			
			System.out.print(total + " ");
			
			//method 2
			int diff = 0;
			int nextDiff = 0;
			for (int i2=0; i2<(numTrials-1); i2++)
			{
			    nextDiff = t[i2] - t[i2+1];
			    if (nextDiff > diff) diff = nextDiff;
			}
			
			
			total = 0;
			for (int i1=0; i1<(numTrials-1); i1++)
			{
			    if (t[i1] < diff) total += t[i1];
			    else total += diff;
			}
			
			System.out.print(total);
		    System.out.println();
		}
        
    }
}





















