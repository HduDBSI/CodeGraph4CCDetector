package googlejam6.p108;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by slycer on 4/1/16.
 */
public class RankandFile {

    public static void main ( String [] args ) throws FileNotFoundException {
        System.setOut( new PrintStream( "RankandFile.out" ));
        Scanner s = new Scanner( System.in ) ;
        int tests = s.nextInt();
        for ( int  test=1; test<=tests; test++ ){

            int n = s.nextInt();
            int [] count = new int[3000];
            for ( int i=0; i<n*2-1; i++ ){

                for ( int j=0; j<n; j++ ){
                   count[ s.nextInt() ]++;
                }
            }
            ArrayList<Integer> answer = new ArrayList<>();
            for ( int i=0; i<count.length; i++ ){
                if ( count[i]%2==1 ){
                    answer.add( i );
                }
            }
            Collections.sort(answer );
            String k = "";
            for ( int i=0; i<answer.size(); i++ ){
                k = k + answer.get(i)+" ";
            }
            System.err.println("Case #"+test + ": " +  k );
            System.out.println("Case #"+test + ": " + k  );
        }
    }

    //public static void go ( int [][] data )

}
