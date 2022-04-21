package googlejam3.p432;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class A {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("data/a/A-small-attempt1.in"));
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/a/out")));
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      int w = sc.nextInt();
      int q = w;
      if (c / w * w == c) {
        q -= 1;
      }
      int s = r * ((c / w) + q);
      System.out.println("Case #" + i + ": " + s);
      bw.write("Case #" + i + ": " + s + "\n");
    }
    sc.close();
    bw.close();
  }
}
