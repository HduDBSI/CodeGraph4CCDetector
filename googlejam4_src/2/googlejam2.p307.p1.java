package googlejam2.p307;
import java.util.*;
import java.io.*;

public class p1 
{
  static int ans=0;
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("A-small-attempt0 (2).in"));
    PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
    //Scanner s=new Scanner (new File("in.txt"));  
    int cases=s.nextInt();
    
    long max=1000000;
    long best []=new long[(int)max+1];
    Arrays.fill (best,max+1);
    best[0]=0;
    for (int x=1;x<=max;x++)
    {
      long a = x;
		while (a%10==0)
		  a/=10;
		String b="";
		int temp1=(int)Math.log10(a);
		for (int x1=0;x1<=temp1;x1++)
		{
		  b+=a%10;
		  a/=10;
		}
	long temp=Long.parseLong(b);
      if(x%10!=0&&temp<=x)
        best[x]=Math.min(best[(int)temp]+1,best[x-1]+1);
      else
        best[x]=best[x-1]+1;
    }
    
    for (int tt=0;tt<cases;tt++)
    {
      long n=s.nextLong(); 
      out.println ("Case #"+(tt+1)+": "+(best[(int)n]));
      System.out.println ("Case #"+(tt+1)+": "+(best[(int)n]));
    }
    out.close();
    s.close();
  }
}