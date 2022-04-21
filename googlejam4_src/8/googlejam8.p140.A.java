package googlejam8.p140;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class A {
  private static char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
      'V', 'W', 'X', 'Y', 'Z' };
  public static void main(String[] args) throws Exception {
    BufferedWriter bw = new BufferedWriter(new FileWriter(
        "A-large.out"));
    BufferedReader br = new BufferedReader(new FileReader(
        "A-large.in"));
    br.readLine();
    String line;
    int testCase = 1;
    while ((line = br.readLine()) != null) {
      if (line.length() == 0) {
        break;
      }
      if ((line = br.readLine()) == null || line.length() == 0) {
        break;
      }
      bw.write("Case #" + (testCase++) + ":");
      String[] start = line.split(" ");
      int[] senators = new int[start.length];
      int senatorsLeft = 0;
      int partiesLeft = 0;
      for (int i = 0; i < start.length; i++) {
        senators[i] = Integer.parseInt(start[i]);
        senatorsLeft += senators[i];
        partiesLeft++;
      }
      while (senatorsLeft > 0) {
        if (partiesLeft > 2) {
          int maxVal = 0, maxInd = 0;
          for (int i = 0; i < senators.length; i++) {
            if (senators[i] > maxVal) {
              maxInd = i;
              maxVal = senators[i];
            }
          }
          bw.write(" " + chars[maxInd]);
          senators[maxInd]--;
          if (senators[maxInd] == 0) {
            partiesLeft--;
          }
        } else {
          int firstInd = -1, secondInd = -1;
          for (int i = 0; i < senators.length; i++) {
            if (senators[i] > 0) {
              if (firstInd == -1) {
                firstInd = i;
              } else {
                secondInd = i;
                break;
              }
            }
          }
          if (senatorsLeft % 2 > 0) {
            if (senators[firstInd] == senators[secondInd]) {
              for (int j = senators[firstInd]; j > 0; j--) {
                bw.write(" " + chars[firstInd]
                    + chars[secondInd]);
              }
            } else if (senators[firstInd] > senators[secondInd]) {
              bw.write(" ");
              for (int j = senators[firstInd] - senators[secondInd];
                  j > 0; j--) {
                bw.write(chars[firstInd]);
              }
            } else {
              bw.write(" ");
              for (int j = senators[firstInd] - senators[secondInd];
                  j > 0; j--) {
                bw.write(chars[secondInd]);
              }
            }
          } else {
            for (int j = senators[firstInd]; j > 0; j--) {
              bw.write(" " + chars[firstInd] + chars[secondInd]);
            }
          }
          senatorsLeft = 0;
          partiesLeft = 0;
        }
      }
      bw.write("\n");
    }
    br.close();
    bw.close();
  }
}
