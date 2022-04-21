package googlejam3.p062;
import java.io.*;
import java.util.*;

public class A
{
	public static void main(String[] args) throws IOException
	{
		Scanner in=new Scanner(System.in);
		int numRuns=in.nextInt();
		for (int run=1; run<=numRuns; run++)
		{
			int r=in.nextInt(), c=in.nextInt(), w=in.nextInt();
			int extrarows=(r-1)*(c/w);
			
			// Shoot c/w-1 times; 
			int ans=c/w-1;
			c-=w*ans;
			System.out.println("Case #"+run+": "+(ans+Math.min(w+1,c)+extrarows));
		}
	}
}