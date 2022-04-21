package googlejam1.p647;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Result {
  /**
   * @param args
   */
  public static void main( String[] args ) {
    try {
      FileInputStream fstream = new FileInputStream( "/home/milan/codeJam2015/r1a/A/A-large.in" );
      DataInputStream in = new DataInputStream( fstream );
      BufferedReader br = new BufferedReader( new InputStreamReader( in ) );
      int T = Integer.valueOf( br.readLine() );
      int i = 1;
      int plates = 0;
      while( i <= T ) {
        plates = Integer.valueOf( br.readLine() );
        String[] strArray = new String[plates];
        strArray = br.readLine().split( " " );
        int[] mushrooms = new int[plates];
        for( int j = 0; j < strArray.length; j++ ) {
          mushrooms[j] = Integer.parseInt( strArray[j] );
        }
        int s1 = 0;
        int max = 0;
        int diff;
        for( int k = plates - 1; 0 < k; k-- ) {
          diff = mushrooms[k - 1] - mushrooms[k];
          if( 0 < diff ) {
            s1 += diff;
            if( max < diff )
              max = diff;
          }
        }
        int s2 = 0;
        for( int j = 0; j < plates - 1; j++ ) {
          if( mushrooms[j] < max )
            s2 += mushrooms[j];
          else
            s2 += max;
        }
        //System.out.println( "Case #" + i + ": s1 " + s1 + " " + s2 );
        try {
		  BufferedWriter bw = new BufferedWriter( new FileWriter( new File( "/home/milan/codeJam2015/r1a/A/A-large.out" ), true ) );
		  bw.write( "Case #" + i + ": " + s1 + " " + s2 );
		  bw.newLine();
		  bw.close();
		}
		catch( Exception e ) {
		  System.err.println( "Error: " + e.getMessage() );
		}
        i++;
      }
      br.close();
    }
    catch( Exception e ) {//Catch exception if any
      System.err.println( "Error: " + e.getMessage() );
    }
  }
}
