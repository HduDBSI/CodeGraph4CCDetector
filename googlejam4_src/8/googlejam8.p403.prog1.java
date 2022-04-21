package googlejam8.p403;
import java.util.*;
import java.lang.*;
import java.io.*;

class prog1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw=new PrintWriter("output1.txt");
	    //StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(br.readLine());
		for(int q=1;q<=t;q++)
		{
			int n=Integer.parseInt(br.readLine());
			int p[]=new int[n];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(st.nextToken());
			}
			pw.print("Case #"+q+":");
			while(true)
			{
				int f=0;
				int first=-1,second=-1;
				int less=-1;
				int max=0;
				int more=-1;
				for(int i=0;i<n;i++)
				{
					if(p[i]>max)
					{
						max=p[i];
						first=i;
					}
				}
				for(int i=0;i<n;i++)
				{
					if(p[i]==max&&first!=i)
					{
						second=i;
						more++;
					}
				}
				if(first!=-1&&second!=-1&&more==0)
				{
					p[first]--;
					p[second]--;
					char ch=(char)(first+65);
					char ch1=(char)(second+65);
					pw.print(" "+ch+ch1);
				}
				else if(first!=-1)
				{
					p[first]--;
					char ch=(char)(first+65);
					pw.print(" "+ch);
				}
				else
				{
					break;
				}
			}
			pw.println();
		}
		pw.close();
	}
}
