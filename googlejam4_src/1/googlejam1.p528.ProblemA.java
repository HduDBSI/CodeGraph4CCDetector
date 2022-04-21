package googlejam1.p528;
import java.io.*;
import java.awt.*;
import java.util.*;
public class ProblemA
{
  public static void main (String [] args) throws Exception
  {
    Scanner in = new Scanner (new FileReader ("A-large.in"));
    PrintWriter out = new PrintWriter (new FileWriter ("out.txt"));
    int cases = in.nextInt ();
    in.nextLine();
    for (int x = 0; x < cases; x++)
    {
      int intervals = in.nextInt();
      int [] mushrooms = new int [intervals];
      for (int m = 0; m < intervals; m++)
      {
        mushrooms [m] = in.nextInt();
      }
      int minMush1 = 0;
      for (int m = 1; m < intervals; m++)
      {
        if (mushrooms [m] < mushrooms [m-1])
        {
          minMush1 += (mushrooms [m-1]- mushrooms [m]);
        }
      }
      int minMush2 = 0;
      int maxDiff = 0;
      for (int m = 1; m < intervals; m++)
      {
        if ((mushrooms [m-1] - mushrooms [m]) > maxDiff)
        {
          maxDiff = mushrooms [m-1] - mushrooms [m];
        }
      }
      for (int m = 0; m < intervals - 1; m++)
      {
        if (mushrooms [m] >= maxDiff)
          minMush2 += maxDiff;
        else
          minMush2 += mushrooms [m];
      }
      out.println ("Case #" + (x+1) + ": " + minMush1 + " " + minMush2);
    }
    out.close();
  }
}