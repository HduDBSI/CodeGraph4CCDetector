package googlejam3.p480;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class a {
  public static void main(String[] args)  throws FileNotFoundException {

    Scanner sc;
    try {
      sc = new Scanner(new FileReader("/Users/patcharin/project/google/src/test.txt"));
    } catch (FileNotFoundException e) {
      return;
    }
    int n = sc.nextInt();
    String tmp = sc.nextLine();
    String res = "";
    for (int i=1; i<=n; i++) {
      int row = sc.nextInt();
      int col = sc.nextInt();
      int w = sc.nextInt();
      int min = 0;

      for (int j=0; j<row; j++) {
        for (int k=0; k<col; k+=w) {
           min++;
        }
      }

      if (i != 1) res += "\n";
      res += "Case #" + i + ": " + (min+w-1);
    }
    System.out.println(res);
  }
}
