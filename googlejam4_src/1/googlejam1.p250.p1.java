package googlejam1.p250;
import java.util.*;
import java.io.*;

public class p1 
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("A-large (1).in"));
    PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
    //Scanner s=new Scanner (new File("in.txt"));
    
    int cases=s.nextInt();
    for (int n=0;n<cases;n++)
    {
      int min1=0;
      int min2=0;
      int dif=0;
      int k=s.nextInt();
      int []plate=new int[k];
      for (int x=0;x<k;x++)
      {
        plate[x]=s.nextInt();
      }
      for (int x=1;x<k;x++)
      {
        if (plate[x-1]>plate[x])
        {
          int temp=plate[x-1]-plate[x];
          min1+=temp;
          if (temp>dif)
            dif=temp;
        }
      }
      for (int x=0;x<k-1;x++)
      {
        min2+=Math.min(dif,plate[x]);
      }
      
      
      out.println ("Case #"+(n+1)+": "+min1+" "+min2);
      //System.out.println ("Case: #"+(n+1)+": "+min1+" "+min2);
    }
    out.close();
  }
}