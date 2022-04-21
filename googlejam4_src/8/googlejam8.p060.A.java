package googlejam8.p060;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 *
 */
public class A {
    public static void main(String[] args) {
         try {

             Scanner scanner = (new Scanner(new File("c:/users/rafal/ideaprojects/src/Ain.txt")));


             FileOutputStream out = new FileOutputStream("c:/users/rafal/ideaprojects/src/Aout.txt");

             int numberOfCases;
             numberOfCases = scanner.nextInt();
             scanner.nextLine();

             PrintWriter wr = new PrintWriter(out);
             for (int i = 0; i < numberOfCases; i++) {
                 int caseNumber = i + 1;
				int n = scanner.nextInt();
				
				int largestIdx = 0;
				int []p = new int[n];
				int sum = 0;
				for (int i1 = 0; i1 < n ; i1++) {
				    p[i1] = scanner.nextInt();
				    if (p[i1] > p[largestIdx]) {
				        largestIdx = i1;
				    }
				    sum += p[i1];
				}
				
				StringBuffer result = new StringBuffer();
				int largest = p[largestIdx];
				
				int idx = 0;
				while (sum > 2 * largest) {
				    // remove one
				    if (idx == largestIdx) {
				        idx++;
				    }
				    if (p[idx] > 0) {
				        p[idx]--;
				        sum--;
				        result.append(" " + (char)('A' + idx));
				    } else {
				        idx++;
				    }
				}
				
				while (sum > 0) {
				    // remove one
				    if (idx == largestIdx) {
				        idx++;
				    }
				    if (p[idx] > 0) {
				        p[idx]--;
				        sum -= 2;
				        result.append(" " + (char)('A' + idx));
				        result.append((char)('A' + largestIdx));
				    } else {
				        idx++;
				    }
				}
				
				
				wr.println("Case #" + caseNumber + ": " + result);
				System.out.println("Case #" + caseNumber + ": " + result);
				// ...
                 if (i < numberOfCases - 1)
                    scanner.nextLine();
             }
             wr.close();
             out.close();

         } catch (IOException e) {
             System.out.println("Error: " + e);
         }
     }


}