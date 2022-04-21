package googlejam6.p292;
import java.io.*;
import java.util.*;

public class RankAndFile {

    public static void main(String[] args) throws FileNotFoundException{
      Scanner in = new Scanner(new File(args[0]));
      int t = in.nextInt();
      
     for(int i = 0; i < t; i++) {
       int n = in.nextInt();
       
       int[][] lists = new int[2*n - 1][n];
       for(int j = 0 ; j < 2 * n - 1; j++) {
          for(int k = 0; k < n; k++) {
            lists[j][k] = in.nextInt();            
          }
       }
       
       int[] heightOccurences = new int[2501];
       for(int j = 0 ; j < 2 * n - 1; j++) {
          for(int k = 0; k < n; k++) {
            heightOccurences[lists[j][k]]  += 1;
          }
       }
       System.out.format("Case #%d:", i + 1);
       for(int j = 1; j < heightOccurences.length; j++) {
         if(heightOccurences[j] % 2 != 0) {
          System.out.format(" %d", j);
         }
       }
       System.out.format("%n");       
       
     }
    }

}