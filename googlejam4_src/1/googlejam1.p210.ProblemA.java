package googlejam1.p210;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Mushroom Monster
 */
public class ProblemA {

    private static final String ID = "gcj2015round1A/A-large";

    private static Scanner input;
    private static PrintWriter output;

    public static void main(String[] args) {
        try {
            input = new Scanner(new File("data/" + ID + ".in"));
            output = new PrintWriter(new FileWriter("data/" + ID + ".out"));
            long time = System.currentTimeMillis();
			int T = input.nextInt();
			for (int t = 1; t <= T; t++) {
			    int min1 = 0, min2 = 0, largestDiff = 0;
			
			    int N = input.nextInt();
			    int[] m = new int[N];
			    for (int i = 0; i < N; i++) {
			        m[i] = input.nextInt();
			        if (i > 0) {
			            int diff = m[i - 1] - m[i];
			            if (diff > 0) {
			                min1 += diff;
			                if (diff > largestDiff) {
			                    largestDiff = diff;
			                }
			            }
			        }
			    }
			
			    for (int i = 0; i < N - 1; i++) {
			        if (m[i] >= largestDiff) {
			            min2 += largestDiff;
			        } else {
			            min2 += m[i];
			        }
			    }
			
			    output.printf("Case #%d: %d %d\n", t, min1, min2);
			}
			output.flush();
			output.close();
			input.close();
			time = System.currentTimeMillis() - time;
			System.out.printf("[%s] finished in %d ms\n", ID, time);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

}
