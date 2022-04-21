package googlejam6.p086;
import java.util.*;
import java.io.*;

public class B {

  public static void main(String[] args) throws Exception {
    //Scanner in = new Scanner(System.in);
    Scanner in = new Scanner(new File("B-large.in"));
    PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
    int tests = in.nextInt();
    for (int t = 1; t <= tests; t++) {
      int n = in.nextInt();
      int[] count = new int[2501];
      for (int i = 0; i < 2*n-1; i++) {
        for (int j = 0; j < n; j++) {
          count[in.nextInt()]++;
        }
      }
      out.print("Case #" + t + ":");
      for (int i = 1; i <= 2500; i++) {
        if (count[i] % 2 != 0) out.print(" " + i);
      }
      out.println();
    }
    in.close();
    out.close();
  }
}