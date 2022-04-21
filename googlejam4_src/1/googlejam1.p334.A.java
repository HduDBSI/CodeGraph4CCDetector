package googlejam1.p334;
import java.io.*;
import java.util.*;

public class A{
  public static void main (String[] args) throws Exception{
    Scanner in = new Scanner (new FileReader("A-large.in"));
    PrintWriter out = new PrintWriter ("A.out");
    int cases = in.nextInt();
    for (int casenum = 1; casenum <= cases; casenum++){
      int n = in.nextInt();
      int[] mushrooms = new int[n];
      for (int i = 0; i < n; i++){
        mushrooms[i] = in.nextInt();
      }
      int maxDiff = 0;
      int total = 0;
      for (int i = 1; i < n; i++){
        int diff = mushrooms[i-1] - mushrooms[i];
        maxDiff = Math.max (maxDiff, diff);
        total += Math.max(diff, 0);       
      }
      int constTotal = 0;
      for (int i = 0; i < n-1; i++){
        constTotal += Math.min(maxDiff,mushrooms[i]);
      }
      
      out.println ("Case #" + casenum + ": " + total + " " + constTotal);
    }
    out.close();
    in.close();
  }
}