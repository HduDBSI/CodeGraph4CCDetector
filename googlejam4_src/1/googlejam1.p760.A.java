package googlejam1.p760;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
    String line = br.readLine();
    int testCase = 1;
    while ((line = br.readLine()) != null) {
      if (line.length() == 0 || (line = br.readLine()) == null) {
        break;
      }
      String[] mushroomStrings = line.split(" ");
      int method1 = 0, method2 = 0;
      int lastNumber = Integer.parseInt(mushroomStrings[0]);
      int maxDiff = 0;
      for (int i = 1; i < mushroomStrings.length; i++) {
        int mushroomNumber = Integer.parseInt(mushroomStrings[i]);
        if (mushroomNumber < lastNumber) {
          method1 += lastNumber - mushroomNumber;
          maxDiff = Math.max(maxDiff, lastNumber - mushroomNumber);
        }
        lastNumber = mushroomNumber;
      }
      for (int i = 1; i < mushroomStrings.length; i++) {
        int mushroomNumber = Integer.parseInt(mushroomStrings[i - 1]);
        method2 += Math.min(mushroomNumber, maxDiff);
      }
      bw.write("Case #" + testCase++ + ": " + method1 + " "
          + method2 + "\n");
    }
    br.close();
    bw.close();

  }
}
