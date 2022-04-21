package googlejam6.p428;
import java.io.*;
import java.util.*;

public class RANK_AND_FILE {
  public static void main (String [] t) throws IOException {
    BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
    NavigableSet <Integer> set;
    int T = Integer.parseInt (in.readLine ()), N, X;
    
    for (int i = 1; i <= T; i++) {
      N = Integer.parseInt (in.readLine ());
      set = new TreeSet <Integer> ();
      
      for (int n = 0; n < 2 * N - 1; n++) {
        t = in.readLine ().split (" ");
        
        for (int x = 0; x < t.length; x++) {
          X = Integer.parseInt (t [x]);
          
          if (!set.add (X)) {
            set.remove (X);
          }
        }
      }
      
      System.out.print ("Case #" + i + ":");
      
      for (int y : set) {
        System.out.print (" " + y);
      }
      System.out.println ();
    }
  }
}