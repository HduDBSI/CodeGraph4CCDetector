package googlejam6.p170;
import java.util.*;
import java.io.*;
import java.math.*;

public class B {
  
  public static void main(String cmdArgs[]) throws Exception {
    long time = System.currentTimeMillis();

    String filename = cmdArgs[0];

    BufferedWriter writer =
      new BufferedWriter(new PrintWriter(filename + "-output.txt", "UTF-8"));
    BufferedReader reader = new BufferedReader(new FileReader(filename));

    String nextLine;
    nextLine = reader.readLine(); // ignore count
    int caseNum = 1;
    while ((nextLine = reader.readLine()) != null) {
      int rows = Integer.valueOf(nextLine);

      TreeSet<Integer> soldiers = new TreeSet<Integer>();
      for (int i = 0; i < 2 * rows - 1 ; i++) {
        nextLine = reader.readLine();
        String[] row = nextLine.split(" ");
        for (String soldier : row) {
          int height = Integer.valueOf(soldier);
          if (soldiers.contains(height)) {
            soldiers.remove(height);
          } else {
            soldiers.add(height);
          }
        }
      }
      if (soldiers.size() != rows) {
        System.out.println("BUG");
      }
      writer.write("Case #" + caseNum + ":");
      for (Integer soldier : soldiers) {
        writer.write(" " + soldier);
      }
      caseNum++;
      writer.newLine();
    }
    writer.close();
    long elapsed = System.currentTimeMillis() - time;
    System.out.println("millis elapsed: " + elapsed);
  }
}
