package googlejam1.p240;
import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Alexander Gulko
 */
public class A {
    @SuppressWarnings("FieldCanBeLocal")
    private static int caseNumber;
    private static Scanner scan;

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        String file = "a";

        System.setOut(new PrintStream(file + ".out"));

        String inFile = file + ".in";
        scan = new Scanner(new File(inFile));

        int cases = scan.nextInt();
        for (caseNumber = 1; caseNumber <= cases; ++caseNumber) {
            System.out.printf("Case #%s: ", caseNumber);
			A r = new A();
            int n = A.scan.nextInt();
			int[] m = new int[n];
			for (int i = 0; i < n; ++i) {
			    m[i] = A.scan.nextInt();
			}
			
			int res1 = 0;
			for (int i = 1; i < n; ++i) {
			    res1 += Math.max(m[i - 1] - m[i], 0);
			}
			
			int res2 = 0;
			int max = 0;
			for (int i = 1; i < n; ++i) {
			    int diff = Math.max(m[i - 1] - m[i], 0);
			    max = Math.max(max, diff);
			}
			for (int i = 0; i < n - 1; ++i) {
			    res2 += Math.min(m[i], max);
			}
			
			System.out.printf("%d %d\n", res1, res2);
            System.out.flush();
        }

        scan.close();
    }
}
