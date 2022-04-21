package googlejam3.p177;
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		int cases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cases; i++)
		{
			System.out.print("Case #" + (i+1) + ": ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//System.out.println( "" + r + " " + t + " " + w );
			int answer = -1;
			
			int movesForFirstHit = 0;
			int hitPosition = w;
			for(int i1 = w; i1 <= t; i1 += w )
			{
				movesForFirstHit++;
				hitPosition = i1;
			}
			
			
			int movesToEliminateRows = movesForFirstHit * (r-1);
			
			
			
			if(hitPosition == t)
			{
				//System.out.println("LAST");
				answer = movesForFirstHit + movesToEliminateRows + (w-1);
			}
			else
			{
				answer = movesForFirstHit + movesToEliminateRows + w;
			}
			
			//System.out.println(hitPosition);
			//System.out.println(movesForFirstHit);
			System.out.println("" + answer);
		}
	}
}
	