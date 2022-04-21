package googlejam6.p721;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		DataInputStream in = new DataInputStream(System.in);
		int t,h;
		t= Integer.parseInt(in.readLine());
		int heights[]= new int[2502];
		for(int k=0;k<2501;k++)
			heights[k]=0;
		for(int i=1;i<=t;i++)
		{
			int n;
			n= Integer.parseInt(in.readLine());
			for(int j=1;j<2*n;j++)
			{
				String line=in.readLine();
				StringTokenizer st= new StringTokenizer(line);
				for(int x=0;x<n;x++)
				{
					h=Integer.parseInt(st.nextToken());
					System.out.print(h+" ");
					heights[h]=heights[h]+1;
				}
					System.out.println("");
			}
			String s="";
			for(int k=0;k<2502;k++)
			{
				if(heights[k]%2!=0)
					s=s+k+" ";
				heights[k]=0;
			}
			s=s.trim();
			System.out.println("Case #"+i+": "+s);
		}
	}
}