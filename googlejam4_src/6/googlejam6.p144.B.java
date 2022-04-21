package googlejam6.p144;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt();
    for (int t = 1; t <= T; t++) {

      int N = scanner.nextInt();
      HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

      for (int row = 0; row < N * 2 - 1; row ++) {
        for (int col = 0; col < N; col ++) {
          int height = scanner.nextInt();
          if (count.containsKey(height)) {
            count.put(height, count.get(height) + 1);
          }
          else {
            count.put(height, 1);
          }
        }
      }

      ArrayList<Integer> miss = new ArrayList<Integer>(N);
      for (Integer key: count.keySet()) {
        if (count.get(key) % 2 == 1) {
          miss.add(key);
        }
      }

      Collections.sort(miss);

      System.out.printf("Case #%d:", t);
      for (Integer height: miss) {
        System.out.print(" " + height);
      }
      System.out.print("\n");
    }
  }
}