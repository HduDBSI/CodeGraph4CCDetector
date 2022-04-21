package googlejam3.p402;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class Brattleship {
  static final String inputFileName = "in.txt";
  static final String outputFileName = "out.txt";
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      File file = new File(inputFileName);
      Scanner in = new Scanner(file);
      file = new File(outputFileName);
      PrintWriter out = new PrintWriter(file);
      
      
      int num = in.nextInt();
      
      for(int n=1; n<=num; n++) {
        int nRows = in.nextInt();
        int nCols = in.nextInt();
        int w = in.nextInt();
        
        int g = nCols/w;
        
        int e = 1 + nCols%w;
        int a;
        if(e==1) {
          a = 0;
        } else {
          a = 1;
        }
        
        
        int N = nRows * g + (w-1) + a;
          
        String str = "Case #"+n+": "+N;
        
        System.out.println(str);
        out.println(str);
      }
      
      in.close();
      out.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Brattleship.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
