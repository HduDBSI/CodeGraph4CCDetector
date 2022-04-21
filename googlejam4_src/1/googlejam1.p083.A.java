package googlejam1.p083;
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
				
				int []nn = new int[n];
				for (int i1 = 0; i1 < n; i1++) {
				    nn[i1] = scanner.nextInt();
				}
				
				int maxDiff = 0;
				int result1 = 0;
				for (int i2 = 1; i2 < n; i2++) {
				    if (nn[i2] < nn[i2-1]) {
				        int diff = nn[i2-1] - nn[i2];
				        if (diff > maxDiff) {
				            maxDiff = diff;
				        }
				        result1 += diff;
				    }
				}
				
				int result2 = 0;
				for (int i3 = 0; i3 < n - 1; i3++) {
				    if (nn[i3] >= maxDiff) {
				        result2 += maxDiff;
				    } else {
				        result2 += nn[i3];
				    }
				}
				
				wr.println("Case #" + caseNumber + ": " + result1 + " " + result2);
				System.out.println("Case #" + caseNumber + ": " + result1 + " " + result2);
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