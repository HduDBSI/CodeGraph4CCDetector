package googlejam3.p492;
import java.io.*;
import java.util.*;

public class P1
{
  public static void main (String[] args) throws Exception
  {
    Scanner in = new Scanner(new File("A-small-attempt0.in"));
    //Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
    int n = in.nextInt();
    
    for(int t =0; t<n; t++)
    {
      int r =  in.nextInt();
      int c = in.nextInt();
      int w = in.nextInt();
      int answer = (int)(Math.ceil(c*1.0/w*1.0))-1+w;
      answer *=r;
      String ans = ""+answer;
      out.println("Case #" + (t+1) + ": " + ans);
      System.out.println("Case #" + (t+1) + ": " + ans);
    }

    in.close();
    out.close();
  }
}