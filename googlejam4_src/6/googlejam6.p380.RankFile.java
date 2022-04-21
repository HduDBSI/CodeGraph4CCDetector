package googlejam6.p380;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RankFile {

  public static void main( String[] args ) {
    Scanner in = new Scanner( System.in );
    int t = in.nextInt();
    int max = 0;

    for ( int testCase = 1; testCase <= t; testCase++ ) {
      int n = in.nextInt();
      int[] heights = new int[2501];

      for ( int i = 0; i < 2 * n - 1; i++ ) {
        for ( int k = 0; k < n; k++ ) {
          int height = in.nextInt();
          heights[height] += 1;
          if ( height > max ) {
            max = height;
          }
        }
      }

      System.out.format( "Case #%d: ", testCase );
      for ( int j = 1; j <= max; j++ ) {
        if ( heights[j] % 2 != 0 ) {
          System.out.format( "%d ", j );
        }
      }
      System.out.format( "\n" );
    }
  }

}
