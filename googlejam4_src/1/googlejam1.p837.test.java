package googlejam1.p837;
import java.util.*;
import java.lang.*;
import java.io.*;

class mushroom
{
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		InputStream inputStream = new FileInputStream("D:\\test2.in");
		BufferedReader r = new BufferedReader (new InputStreamReader (inputStream));		
		int numtestcase=0;
		//while (!(s=r.readLine()).startsWith("42")) System.out.println(s);
		numtestcase=Integer.parseInt(r.readLine());
		for(int i=1;i<=numtestcase;i++)
		{
			String s=r.readLine();
			int n=Integer.parseInt(s);
			String[] s1=r.readLine().split(" ");
			int c1=0,c2=0,maxdiff=0;
			for(int j=0;j<n-1;j++)
			{
				int a=Integer.parseInt(s1[j]);
				int b=Integer.parseInt(s1[j+1]);
				if(b<a) c1+=a-b;
				if(a-b>maxdiff) maxdiff=a-b;
			}
			for(int j=0;j<n-1;j++)
			{
				int a=Integer.parseInt(s1[j]);
				int b=Integer.parseInt(s1[j+1]);
				if(a<=maxdiff) 
					{
						c2+=a;
					}
				else
				{
					c2+=maxdiff;
				}
			}			
			//if(c2>c3) c2=c3;
			System.out.println("Case #"+Integer.toString(i)+": "+Integer.toString(c1)+ " " + Integer.toString(c2));
			
		}
	}
}