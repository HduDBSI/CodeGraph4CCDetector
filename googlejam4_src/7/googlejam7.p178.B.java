package googlejam7.p178;
// B.
//import java.awt.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
 
public class B {
  
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int numTests = sc.nextInt();
    for (int tc = 1; tc <= numTests; ++tc) {
      String cc = sc.next();
      String jj = sc.next();
      int limit = 0;
      if (cc.length() == 1) {
        limit = 9;
      } else {
        limit = cc.length() == 2 ? 99 : 999;
      }
      int cScore = 1000;
      int jScore = 1000;
      int absDiff = 1000;
      for (int i = 0; i <= limit; ++i) {
        for (int j = 0; j <= limit; ++j) {
          String ct = String.valueOf(i);
          String jt = String.valueOf(j);
          while (ct.length() < cc.length()) {
            ct = "0" + ct;
          }
          while (jt.length() < jj.length()) {
            jt = "0" + jt;
          }
          boolean okay = true;
          for (int k = 0; k < cc.length(); ++k) {
            if (cc.charAt(k) != '?' && cc.charAt(k) != ct.charAt(k)) {
              okay = false;
              break;
            }
            if (jj.charAt(k) != '?' && jj.charAt(k) != jt.charAt(k)) {
              okay = false;
              break;
            }
          }
          if (okay) {
            if (Math.abs(i - j) <= absDiff) {
              if (Math.abs(i - j) == absDiff) {
                if (i <= cScore) {
                  if (i == cScore) {
                    if (j < jScore) {
                      cScore = i;
                      jScore = j;
                    }
                  } else {
                    cScore = i;
                    jScore = j;
                  }
                }
              } else {
                cScore = i;
                jScore = j;
                absDiff = Math.abs(i - j);
              }
            }
          }
        }
      }
      String cAns = String.valueOf(cScore);
      String jAns = String.valueOf(jScore);
      while (cAns.length() < cc.length()) {
        cAns = "0" + cAns;
      }
      while (jAns.length() < jj.length()) {
        jAns = "0" + jAns;
      }
      System.out.println("Case #" + tc + ": " + cAns + " " + jAns);
    }
  }
}
