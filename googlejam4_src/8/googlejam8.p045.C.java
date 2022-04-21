package googlejam8.p045;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by slycer on 4/1/16.
 */
public class C {

    public static void main ( String [] args ) throws FileNotFoundException {
        System.setOut( new PrintStream( "C.out" ));
        Scanner s = new Scanner( System.in ) ;
        int tests = s.nextInt();
        for ( int  test=1; test<=tests; test++ ){
            String answer = "";
            int n = s.nextInt();
            int [] data = new int[n];
            int sum=0;
            for ( int i=0; i<n; i++ ){
                data[i] = s.nextInt();
                sum += data[i];
            }

            int [] current = new int[n];

            for ( int i=0; i<sum; i++ ){
                int pos = -1;
				int min = Integer.MAX_VALUE;
				for ( int i1=0; i1<data.length; i1++ ){
				    if ( current[i1]<min && current[i1] < data[i1] ){
				        min = current[i1];
				        pos = i1;
				    }
				}
				int c = pos;
                current[c]++;
                if ( i>0 && i%2==0 ){
                    answer = " " + answer;
                }
                answer = (char)('A'+c ) + answer;
            }
            System.err.println("Case #"+test + ": " + answer );
            System.out.println("Case #"+test + ": " + answer );
        }
    }
}
