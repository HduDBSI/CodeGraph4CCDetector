package googlejam10.p166;
import java.io.*;
import java.util.*;

public class A
{
	static char[] let={'P','R','S'};
	public static void main(String[] args)
	{
		String[][] table = new String[3][13];
		for (int i=0; i<3; i++)
			table[i][0]=""+let[i];
		for (int n=0; n<=11; n++)
			for (int i=0; i<3; i++)
			{
				String a=table[i][n], b=table[(i+1)%3][n];
				if (a.compareTo(b)<0)
					table[i][n+1]=a+b;
				else
					table[i][n+1]=b+a;
			}
		
		Scanner in=new Scanner(System.in);
		int numRuns=in.nextInt();
		int[] count=new int[3];
		for (int run=1; run<=numRuns; run++)
		{
			int n=in.nextInt();
			count[1]=in.nextInt();
			count[0]=in.nextInt();
			count[2]=in.nextInt();
			boolean match=false;
			for (int i=0; i<3; i++)
			{
				match=true;
				String game=table[i][n];
				for (int j=0; j<3; j++)
					if (game.length()-game.replace(""+let[j],"").length()!=count[j])
						match=false;
				if (match)
				{
					System.out.println("Case #"+run+": "+game);
					break;
				}
			}
			if (!match)
				System.out.println("Case #"+run+": IMPOSSIBLE");
		}
	}
}