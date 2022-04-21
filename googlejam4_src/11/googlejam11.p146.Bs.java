package googlejam11.p146;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Bs {

    private static Scanner in;
    private static PrintWriter out;

    public static void main( String[] args ) {
        Locale.setDefault(Locale.US);
        in = new Scanner( System.in );
        out = new PrintWriter( System.out );
        int tn = in.nextInt();
		        for ( int test = 1; test <= tn; test ++ ) {
		            int n = in.nextInt();
		            int k = in.nextInt();
		            double[] q = new double[n];
		            for ( int i = 0; i < n; i ++ ) {
		                q[i] = in.nextDouble();
		            }
		            double r = 0.0;
		            for ( int m = 0; m < ( 1 << n ); m ++ ) {
		                if ( Integer.bitCount( m ) != k ) continue;
		                double[][] p = new double[2][k + 1];
		                p[0][0] = 1.0;
		                int cnt = 0;
		                for ( int i = 0; i < n; i ++ ) {
		                    if ( ( m & ( 1 << i ) ) == 0 ) continue;
		                    Arrays.fill( p[( cnt & 1 ) ^ 1], 0.0 );
		                    for ( int j = 0; j < k; j ++ ) {
		                        p[( cnt & 1 ) ^ 1][j] += ( 1.0 - q[i] ) * p[cnt & 1][j];
		                        p[( cnt & 1 ) ^ 1][j + 1] += q[i] * p[cnt & 1][j];
		                    }
		                    cnt ++;
		                }
		//                System.out.println( m + " " + p[cnt & 1][k / 2] );
		                r = Math.max( r, p[cnt & 1][k / 2] );
		            }
		            out.println( "Case #" + test + ": " + r );
		        }
        out.close();
    }
}
