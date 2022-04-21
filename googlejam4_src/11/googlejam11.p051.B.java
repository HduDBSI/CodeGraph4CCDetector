package googlejam11.p051;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by vitalii on 30.04.2016.
 */
public class B {
    PrintWriter out;
    Scanner in;

    public static void main(String[] args) throws IOException {
        B r = new B();
		r.in = new Scanner(new File("B.in"));
		        r.out = new PrintWriter("B.out");
		        int t = r.in.nextInt();
		        for (int i = 1; i <= t; i++) {
		            System.err.println(i);
		            r.out.print("Case #" + i + ": ");
		            int n = r.in.nextInt(), k = r.in.nextInt();
					double[] a = new double[n];
					for (int i1 = 0; i1 < n; i1++) {
					    a[i1] = Double.parseDouble(r.in.next());
					}
					Arrays.sort(a);
					double[][] perF = new double[n+1][2*n+1];
					double[][] perB = new double[n+1][2*n+1];
					perF[0][n] = 1;
					perB[0][n] = 1;
					
					for (int i2 = 1; i2 <= n; i2++) {
					    for (int j = 0; j < 2  *n + 1; j++) {
					        if (j > 0) {
					            perF[i2][j] += perF[i2-1][j-1]*a[i2-1];
					            perB[i2][j] += perB[i2-1][j-1]*a[n-i2];
					        }
					        if (j < 2*n) {
					            perF[i2][j] += perF[i2-1][j+1]*(1- a[i2-1]);
					            perB[i2][j] += perB[i2-1][j+1]*(1-a[n-i2]);
					        }
					    }
					}
					
					double ans = 0;
					for (int t1 = 0; t1 <=k; t1++) {
					    double cand = 0;
					    for (int bal = -t1; bal <= t1; bal++) {
					        int i11 = n + bal;
					        int i2 = n - bal;
					        if (i2 >= 0 && i2 <= 2*n) {
					            cand += perF[t1][i11] * perB[k - t1][i2];
					        }
					    }
					    ans = Math.max(ans, cand);
					}
					Locale.setDefault(Locale.US);
					r.out.printf("%.9f",ans);
		//            out.print(" ");
		//            solveStupid();
		            r.out.println();
		        }
		        r.in.close();
		        r.out.close();
    }
}
