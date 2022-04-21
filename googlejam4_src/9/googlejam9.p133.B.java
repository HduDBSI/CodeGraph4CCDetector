package googlejam9.p133;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class B {
  public static void main(String[] args) throws Exception {
    BufferedWriter bw = new BufferedWriter(new FileWriter(
        "B-large.out"));
    BufferedReader br = new BufferedReader(new FileReader(
        "B-large.in"));
    br.readLine();
    String line;
    int testCase = 1;
    while ((line = br.readLine()) != null) {
      if (line.length() == 0) {
        break;
      }
      bw.write("Case #" + testCase++ + ": ");
      String[] parts = line.split(" ");
      long b = Long.parseLong(parts[0]);
      long m = Long.parseLong(parts[1]);
      if (b == 2) {
        if (m != 1) {
          bw.write("IMPOSSIBLE\n");
        } else {
          bw.write("POSSIBLE\n01\n00\n");
        }
      } else {
        long max = (1L << (b - 2));
        if (m > max) {
          bw.write("IMPOSSIBLE\n");
        } else {
          bw.write("POSSIBLE\n0");
          bw.write(String.format("%" + (b - 2) + "s",
              Long.toBinaryString(m - 1))
              .replace(' ', '0'));
          bw.write("1\n");
          for (int j = 1; j < b; j++) {
            for (int k = 0; k < b; k++) {
              bw.write(k <= j ? "0" : "1");
            }
            bw.write("\n");
          }
        }
      }
    }
    br.close();
    bw.close();
  }
}
