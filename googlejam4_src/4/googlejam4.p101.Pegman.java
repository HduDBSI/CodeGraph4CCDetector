package googlejam4.p101;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Pegman {

  static int n;
  static int l;
  static int ans;

  static int r, c;

  public static void main(String[] args) throws FileNotFoundException {
    		Scanner cin = new Scanner(new File("A-small-attempt0.in"));
    		PrintStream cout = new PrintStream("A-small-attempt0.out");
    //		Scanner cin = new Scanner(new File("A-large-practice.in"));
    //		PrintStream cout = new PrintStream("A-large-practice.out");
//    Scanner cin = new Scanner(System.in);
//    PrintStream cout = System.out;

    int _case = 0;

    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };
    for (int T = cin.nextInt(); T > 0; T--) {
      _case++;
      r = cin.nextInt();
      c = cin.nextInt();
      char[][] a = new char[r][];
      for (int i = 0; i < r; i++)
        a[i] = cin.next().toCharArray();

      int ans = 0;
      for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++) {
          if (a[i][j] != '.') {
            boolean good = false;
            int dir = 0;
            if (a[i][j] == '>')
              dir = 0;
            else if (a[i][j] == '<')
              dir = 1;
            else if (a[i][j] == 'v')
              dir = 2;
            else
              dir = 3;

            for (int x = i + dx[dir], y = j + dy[dir]; x >= 0 && x < r && y >= 0 && y < c; x += dx[dir], y += dy[dir]) {
              if (a[x][y] != '.') {
                good = true;
                break;
              }
            }

            if (good)
              continue;
            else {
              boolean found = false;
              for (int k = 0; k < 4; k++) {
                for (int x = i + dx[k], y = j + dy[k]; x >= 0 && x < r && y >= 0 && y < c; x += dx[k], y += dy[k])
                  if (a[x][y] != '.') {
                    found = true;
                    break;
                  }
              }
              if (!found) {
                ans = Integer.MAX_VALUE;
              } else {
                ans++;
              }
            }
          }
        }

      if (ans == Integer.MAX_VALUE)
        cout.printf("Case #%d: IMPOSSIBLE%n", _case);
      else
        cout.printf("Case #%d: %d%n", _case, ans);

    }

    cin.close();
    cout.close();
  }
}
