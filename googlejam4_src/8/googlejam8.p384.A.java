package googlejam8.p384;
// A.
//import java.awt.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
 
public class A {
  
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int numTests = sc.nextInt();
    for (int tc = 1; tc <= numTests; ++tc) {
      int n = sc.nextInt();
      int[] ascii = new int[256];
      int total = 0;
      int parties = n;
      for (int i = 'A'; i < 'A' + n; ++i) {
        ascii[i] = sc.nextInt();
        total += ascii[i];
      }
      System.out.print("Case #" + tc + ": ");
      while (total > 0) {
        if (parties == 2) {
          for (int i = 'A'; i < 'A' + n; ++i) {
            if (ascii[i] > 0) {
              --ascii[i];
              --total;
              System.out.print((char) i);
            }
          }          
        } else {
          int maxValue = 0;
          int maxIndex = -1;
          for (int i = 'A'; i < 'A' + n; ++i) {
            if (ascii[i] > maxValue) {
              maxValue = ascii[i];
              maxIndex = i;
            }
          }
          --ascii[maxIndex];
          --total;
          if (ascii[maxIndex] == 0) {
            --parties;
          }
          System.out.print((char) maxIndex);
        }
        System.out.print(' ');
      }
      System.out.println();
    }
  }
}
