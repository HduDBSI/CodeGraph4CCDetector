package googlejam1.p721;
import java.io.*;
import java.util.*;
/**
 *   G Page solution
 *   Standing Mushroom Monster - Round 1A, 2015
 */
public class Mushroom
{
    public static void main(String[] args)  throws IOException
    {
        Mushroom x = new Mushroom();
        //Scanner f = new Scanner(new File("A-sample.in"));
		//Scanner f = new Scanner(new File("A-small.in"));
		Scanner f = new Scanner(new File("A-large.in"));
		int[] samples;
		int numCases = f.nextInt();
		for(int i=0; i<numCases; i++)
		{
		    int ans1 = 0;
		    int ans2 = 0;
		    int numSamples = f.nextInt();
		    samples = new int[numSamples];
		    for(int j=0; j<numSamples; j++)
		    {
		        samples[j] = f.nextInt();
		    }
		    
		    // method 1
		    // find decrease between time samples & accumulate
		    for(int a1=0; a1<numSamples-1; a1++)
		    {
		        int temp = samples[a1] - samples[a1+1];
		        ans1 += (temp < 0 ? 0 : temp);
		    }
		    
		    // method 2
		    // find max delta between sample amounts
		    int max = 0;
		    for(int a2=0; a2<numSamples-1; a2++)
		    {
		        int temp = samples[a2] - samples[a2+1];
		        max = Integer.max(temp, max);
		    }
		    // accumulate smaller of max delta and current num on plate
		    for(int a2=0; a2<numSamples-1; a2++)
		    {
		        int amtThisTime = Integer.min(samples[a2], max);
		        ans2 += amtThisTime;
		    }
		    
		    System.out.printf("Case #%d: %d %d\n", i+1, ans1, ans2);
		}
    }

    public Mushroom()
    {
    }
}
