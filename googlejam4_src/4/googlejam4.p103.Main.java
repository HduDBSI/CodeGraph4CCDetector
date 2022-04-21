package googlejam4.p103;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int r = s.nextInt(), c = s.nextInt();
      s.nextLine();
      char[][] v = new char[r][c];
      for (int i = 0; i < r; i++) {
        String line = s.nextLine();
        for (int j = 0; j < c; j++) {
          v[i][j] = line.charAt(j);
        }
      }
      boolean[][][] f = new boolean[r][c][4];
      // up
      for (int j = 0; j < c; j++) {
        boolean flag = false;
        for (int i = 0; i < r; i++) {
          if (v[i][j] != '.') {
            f[i][j][0] = flag;
            flag = true;
          }
        }
      }
      // down
      for (int j = 0; j < c; j++) {
        boolean flag = false;
        for (int i = r - 1; i >= 0; i--) {
          if (v[i][j] != '.') {
            f[i][j][1] = flag;
            flag = true;
          }
        }
      }
      // left
      for (int i = 0; i < r; i++) {
        boolean flag = false;
        for (int j = 0; j < c; j++) {
          if (v[i][j] != '.') {
            f[i][j][2] = flag;
            flag = true;
          }
        }
      }
      // right
      for (int i = 0; i < r; i++) {
        boolean flag = false;
        for (int j = c - 1; j >= 0; j--) {
          if (v[i][j] != '.') {
            f[i][j][3] = flag;
            flag = true;
          }
        }
      }
      // check everyone
      int ans = 0;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (v[i][j] != '.') {
            boolean valid = true;
            switch (v[i][j]) {
              case '^':
                valid = f[i][j][0];
                break;
              case 'v':
                valid = f[i][j][1];
                break;
              case '<':
                valid = f[i][j][2];
                break;
              case '>':
                valid = f[i][j][3];
                break;
              default:
                System.out.println("ERROR");
                break;
              }
            if (!valid) {
              ans++;
              boolean fail = true;
              for (int k = 0; k < 4; k++) {
                if (f[i][j][k]) {
                  fail = false;
                  break;
                }
              }
              if (fail) {
                ans = -1;
                break;
              }
            }
          }
        }
        if (ans == -1) {
          break;
        }
      }
      if (ans == -1) {
        System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
      } else {
        System.out.println(String.format("Case #%d: %d", t, ans));
      }
    }
    s.close();
  }
}