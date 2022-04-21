package googlejam3.p421;
import java.util.*;
import java.io.*;

public class p1 
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("A-small-attempt1.in"));
    //Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
    //Scanner s=new Scanner (new File("in.txt"));
    int ans=0;
    int cases=s.nextInt();
    for (int tt=0;tt<cases;tt++)
    {
      ans=0;
      int r=s.nextInt();
      int c=s.nextInt();
      int w=s.nextInt();
      ans=c/w-1;
      int extra=c%w;
      ans+=(w);
      if (extra!=0)
        ans+=1;
      ans*=r;
      
      out.println ("Case #"+(tt+1)+": "+ans);
      System.out.println ("Case: #"+(tt+1)+": "+ans);
    }
    out.close();
  }
}