package googlejam9.p039;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by slycer on 4/1/16.
 */
public class B {

    public static void main ( String [] args ) throws FileNotFoundException {
        System.setOut( new PrintStream( "B.out" ));
        Scanner s = new Scanner( System.in ) ;
        int tests = s.nextInt();
        for ( int  test=1; test<=tests; test++ ){
            String answer = "";
            int b = s.nextInt();
            BigInteger m = s.nextBigInteger();

            long max = (1l<<(b-2));

            if ( m.compareTo(BigInteger.valueOf(max))> 0 ){
                answer = "IMPOSSIBLE";
            } else {
                m = m.subtract( BigInteger.ONE );

                answer = "POSSIBLE\n";
                for ( int i=0; i<b; i++ ){
                    for ( int j=0; j<b; j++ ){
                        if ( i>0 && i<j && j == b - 1 ){
                            if ( (m.longValue() & ( 1l<<(i-1))) >0){
                                answer += "1";
                            } else {
                                answer += "0";
                            }
                        } else {
                            if ( i<j){
                                answer = answer + "1";
                            } else {
                                answer = answer + "0";
                            }
                        }
                    }
                    if ( i<b-1) {
                        answer += "\n";
                    }
                }
            }

            System.err.println("Case #"+test + ": " + b + " " + (m.add( BigInteger.ONE )));
            System.err.println("Case #"+test + ": " + answer );
            System.out.println("Case #"+test + ": " + answer );
        }
    }

}
