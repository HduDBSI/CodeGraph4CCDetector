package googlejam1.p523;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Mushroom
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner (new File ("A-large.in"));
		PrintWriter out = new PrintWriter ("mushroomoutput");
		int T = in.nextInt();
		for (int test = 1; test<=T; test++)
		{
			int N = in.nextInt();
			int [] m = new int [N];
			for (int i=0; i<N; i++)
			{
				m[i]=in.nextInt();
			}
			
			long x=0;
			for (int i=0; i<=N-2; i++)
			{
				if (m[i]>m[i+1])
					x+=m[i]-m[i+1];
			}
			
			int maxIndex=0;
			for (int i=1; i<=N-2; i++)
			{
				if (m[i]-m[i+1]>m[maxIndex]-m[maxIndex+1])
					maxIndex=i;
			}
			int value = m[maxIndex]-m[maxIndex+1];
			long y=0;
			if (value<=0)
				y=0;
			else
			{
				for (int i=0; i<=N-2; i++)
				{
					if (m[i]>=value)
						y+=value;
					else
						y+=m[i];
				}
			}
			out.println("Case #"+test+": "+x+" "+y);
			
		}
		out.close();
		in.close();

	}

}
