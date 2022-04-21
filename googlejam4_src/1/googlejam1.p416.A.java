package googlejam1.p416;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

// Using the Google Guava library.
public class A {

	public static void main(String [] args) throws IOException {
		String inputFile = "src/A-large-0.in";
		Scanner in = new Scanner(new File(inputFile));
		PrintStream out = new PrintStream(inputFile.substring(0, inputFile.length()-2)+"out");
		int cases = in.nextInt();
		for (int cs = 1; cs <= cases; cs++) {
			int n = in.nextInt();
			int [] m = new int[n];
			for (int i = 0; i<n; i++) {
			    m[i] = in.nextInt();
			}
			long y = 0, z = 0, maxDiff = 0;
			for (int i = 1; i<n; i++) {
			    int diff = Math.max(m[i-1] - m[i], 0);
                y += diff;
                maxDiff = Math.max(maxDiff, diff);
			}
            for (int i = 0; i<n-1; i++) {
                z += Math.min(maxDiff, m[i]);
            }
			String ans = "Case #"+cs+": "+y+" "+z;
			out.println(ans);
			System.out.println(ans);
		}
		out.close();
		in.close();
	}
}
