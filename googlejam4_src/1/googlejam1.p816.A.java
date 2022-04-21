package googlejam1.p816;
/// A. Mushroom Monster
//import java.awt.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class A
{
  final double inf = Double.POSITIVE_INFINITY, eps = 1e-9;
  final int eof = StreamTokenizer.TT_EOF, max = 10000;
  int cases, nt, n, maxVal;
  int[] mushroom, ans;
  
  public static void main (String[] args)
  {
    A r = (new A());
	Scanner sc = new Scanner(System.in);
	
	r.cases = 1;
	r.nt = sc.nextInt();
	while (--r.nt >= 0)
	{
	  System.out.print("Case #" + r.cases + ": ");
	  r.n = sc.nextInt();
	  r.ans = new int[2];
	  r.mushroom = new int[r.n];
	  for (int i = 0; i < r.n; ++i)
	  {
	    r.mushroom[i] = sc.nextInt();
	  }
	  r.ans[0] = 0;
	  for (int i = 1; i < r.n; ++i)
	  {
	    if (r.mushroom[i] <= r.mushroom[i - 1])
	    {
	      r.ans[0] += r.mushroom[i - 1] - r.mushroom[i];
	    }
	  }
	  r.maxVal = 0;
	  for (int i = 1; i < r.n; ++i)
	  {
	    if (r.mushroom[i] < r.mushroom[i - 1])
	    {
	      r.maxVal = Math.max(r.maxVal, r.mushroom[i - 1] - r.mushroom[i ]);
	    }
	  }
	  r.ans[1] = 0;
	  for (int i = 1; i < r.n; ++i)
	  {
	    r.ans[1] += Math.min(r.mushroom[i - 1], r.maxVal);
	  }
	  System.out.println(r.ans[0] + " " + r.ans[1]);
	  ++r.cases;
	}
  }
}