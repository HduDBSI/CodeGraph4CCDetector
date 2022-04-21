package googlejam6.p143;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MakeLoveNotWar {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("B-large (1).in"));
    PrintWriter out = new PrintWriter(new File("hippieOutL.txt"));
    long numTests = in.nextLong();

    for (long test = 0; test < numTests; test++) {
      in.nextLine();
      long testSize = in.nextLong();
      ArrayList<Integer> heights = new ArrayList<Integer>();
      for(long linenum = 0; linenum < 2*testSize-1; linenum++){

        in.nextLine();
        for(int col = 0; col < testSize; col++){
          Integer h = in.nextInt();
          if(heights.contains(h)){
            heights.remove(h);
          }
          else{
            heights.add(h);
          }
        }

      }
      Collections.sort(heights);
      out.print("Case #" + (test+1) + ": ");
      if(heights.size() > 0){
        out.print(heights.get(0));
        for(int i = 1; i < heights.size(); i++){
          out.print(" " + heights.get(i));
        }
      }
      out.println();
    }
    out.close();
    in.close();
  }

}
