package googlejam6.p439;
import java.util.*;
import java.io.*;
import java.lang.StringBuffer;
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      Hashtable<Integer,Integer> counts = new Hashtable<Integer,Integer>();
      int length = 2 * n * n - n;
      for (int j = 1; j <= length; j++) {
        int cur = in.nextInt();
        if (counts.containsKey(cur)) {
          int c = counts.get(cur);
          c++;
          counts.put(cur, c);
        }else{
          counts.put(cur, 1);
        }
      }
      int[] list = new int[n];
      int k = 0;
      Set<Integer> keys = counts.keySet();
      for (int key : keys) {
        if (counts.get(key) % 2 != 0) {
          list[k] = key;
          k++;
        }
      }
      Arrays.sort(list);
      System.out.print("Case #" + i + ": ");
      for (int j = 0; j < n; j++) {
        System.out.print(list[j] + " ");

      }
      System.out.println();
    }
  }
}
