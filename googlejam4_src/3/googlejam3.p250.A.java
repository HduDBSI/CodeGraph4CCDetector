package googlejam3.p250;
import java.io.*;
import java.util.*;

public class A{
  public static void main (String[] args) throws Exception{
    Scanner in = new Scanner (new FileReader("A-large.in"));
    PrintWriter out = new PrintWriter ("A.out");
    int cases = in.nextInt();
    for (int casenum = 1; casenum <= cases; casenum++){
      
      int r = in.nextInt();
      int c = in.nextInt();
      int w = in.nextInt();
      int score = c/w*(r - 1);
      score += (int)Math.ceil((double)c/(double)w);
      score += w - 1;
      
      out.println ("Case #" + casenum + ": " + score);
    }
    out.close();
    in.close();
  }
}