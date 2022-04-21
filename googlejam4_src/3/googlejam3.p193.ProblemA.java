package googlejam3.p193;


import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Brenton
 */
public class ProblemA {

    public static void main(String[] args) {

        String INPUT = args[0];
        int caseNumber = 1;
        int cases;

        try {
            Scanner readIn = new Scanner(new File(INPUT));
            // Read in the number of cases
            cases = readIn.nextInt();
            readIn.nextLine();

            while (caseNumber <= cases) {

                // Read in the variables
                int R = readIn.nextInt();
                int C = readIn.nextInt();
                int W = readIn.nextInt();

                readIn.nextLine();
				// For every row that isn't the answer, we must call
				// every wth square in order to
				// hit the ship at least once
				//
				int result1 = 0;
				
				result1 = (R - 1) * (C / W);
				
				// Once all the other rows have been searched,
				// we must find it in the last row.
				
				//
				result1 += C / W + W - 1;
				
				if (C % W != 0) {
				    result1 += 1;
				}

                // Solve the problem
                int result = result1;

                //print result
                System.out.println("Case #" + caseNumber + ": " + result);
                caseNumber++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
