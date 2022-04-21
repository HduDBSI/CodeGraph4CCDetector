package googlejam6.p329;
import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      int n = in.nextInt();
      // 2*n - 1
      for(int j = 0; j < 2*n-1; j++) {
          // n
          for(int k = 0; k < n; k++) {
              int current = in.nextInt();
              if(!map.containsKey(current)) {
                  map.put(current, 1);
              }else{
                  int temp = map.get(current);
                  map.put(current, temp+1);
              }
          }
      }
      // traver map
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
          int val = entry.getValue();
          int key = entry.getKey();
          if(val%2 != 0)
              list.add(key);
      }
      Collections.sort(list);

      System.out.print("Case #" + i + ": ");
      for(int z = 0; z < list.size(); z++){
          if(z != list.size()-1)
              System.out.print(list.get(z) + " ");
          else
              System.out.print(list.get(z)+ "\n");
      }
    }
  }
}
