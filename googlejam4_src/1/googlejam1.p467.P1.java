package googlejam1.p467;
import java.io.*;
import java.util.*;

public class P1
{
  public static void main (String[] args) throws Exception
  {
    Scanner in = new Scanner(new File("A-large.in"));
    //Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
    int n = in.nextInt();
    for(int t =0; t<n; t++)
    {
      int num = in.nextInt();
      int[] intervals = new int[num];
      for (int x =0; x< num; x++)
        intervals[x] = in.nextInt();
      int last = intervals[0];
      int ans1 = 0;
      for (int x =1; x< num; x++)
      {
        if (intervals[x] < last) ans1+= (last-intervals[x]);
        last = intervals[x];
      }
      
      int largest = 0;
      last = intervals[0];
      for (int x =1; x< num; x++)
      {
        if (intervals[x] < last) largest = Math.max(last-intervals[x],largest);
        last = intervals[x];
      }
      System.out.println(largest);
      last = intervals[0];
      int ans2 = 0;
      for (int x =1; x<num;x++)
      {
        if (intervals[x]>=0) ans2+=Math.min(largest,last);
        last = intervals[x];
      }
      
      // second part. constant eating speed
      
      String ans = ""+ans1+" " + ans2;
      out.println("Case #" + (t+1) + ": " + ans);
      System.out.println("Case #" + (t+1) + ": " + ans);
    }
    in.close();
    out.close();
  }
}