package googlejam1.p279;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class A {

    private static final String BASE = "C:\\cygwin\\home\\jsmith\\codejam\\2015\\Round1A\\A\\";
    //    private static final String PROBLEM = "deceitful_test";
    private static final String PROBLEM = "A-large";

    public static void main(String[] args) {
        String input = BASE + PROBLEM + ".in";
        String output = BASE + PROBLEM + ".out";

        try {
            Scanner sc = new Scanner(new FileReader(input));
            PrintWriter pw = new PrintWriter(output);

            int mumCases = sc.nextInt();
            sc.nextLine();
            for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
                System.out.println("Test case " + (caseNumber + 1) + "...");
                pw.print("Case #" + (caseNumber + 1) + ": ");
                final int N = sc.nextInt();
				int[] mushrooms = new int[N];
				
				for (int i = 0; i < N; i++) {
				    mushrooms[i] = sc.nextInt();
				}
				int prev1 = mushrooms[0];
				int result1 = 0;
				for (int i1 = 1; i1 < mushrooms.length; i1++) {
				    if (mushrooms[i1] < prev1) {
				        result1 += prev1 - mushrooms[i1];
				    }
				    prev1 = mushrooms[i1];
				}
				
				int method1 = result1;
				// find the largest difference between successive values.  This must be the min rate.
				int prev = mushrooms[0];
				int maxDiff = 0;
				for (int i = 1; i < mushrooms.length; i++) {
				    if (mushrooms[i] < prev) {
				        int diff = prev - mushrooms[i];
				        if (diff > maxDiff) {
				            maxDiff = diff;
				        }
				    }
				    prev = mushrooms[i];
				}
				
				// starting at the beginning, eat min(maxdiff, mushrooms) at each interval.
				int result = Math.min(maxDiff, mushrooms[0]);
				for (int i = 1; i < mushrooms.length-1; i++) {
				    result += Math.min(maxDiff, mushrooms[i]);
				}
				int method2 = result;
				
				pw.print(method1 + " " + method2);
                pw.println();
            }
            pw.println();
            pw.flush();
            pw.close();
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
