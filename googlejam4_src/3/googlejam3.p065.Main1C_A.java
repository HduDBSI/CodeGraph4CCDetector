package googlejam3.p065;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Main1C_A {
	
	private static final String IN_NAME = "A-large";

	public static void main(String[] args) throws Exception {
		// Open input and output files. (stdin and stdout are not used because
		// of the lack of support for using a file as stdin in Eclipse.)
		InputStream inStream = new FileInputStream(
			String.format("input/%s.in", IN_NAME));
		OutputStream outStream = new FileOutputStream(
			String.format("output/%s-out.txt", IN_NAME));
		
		Scanner in = new Scanner(new BufferedInputStream(inStream));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(outStream));
		
		int numCases = in.nextInt();
		for (int caseIdx = 1; caseIdx <= numCases; caseIdx++) {
			
			// Read the test case.
			int height = in.nextInt();
			int width = in.nextInt();
			int boatWidth = in.nextInt();
			int result1 = 0;
					
					int toRemoveRow = width / boatWidth;
					
					// Narrow down possibilities to a single row.
					result1 += (height - 1) * toRemoveRow;
					
					// Narrow down possibilities to the right 2 * boatWidth positions.
					// TODO: Probably could do this without having to loop.
					int remaining = width;
					while (remaining >= 2 * boatWidth) {
						remaining -= boatWidth;
						result1++;
					}
			//		int remaining = width;
			//		if (width >= 2 * boatWidth) {
			//			int numHits = (int) Math.ceil(
			//				(width - (2 * boatWidth - 1)) / (double) boatWidth);
			//			int numHits = (width / (double) boatWidth) - 2;
			//			result += numHits;
			//			remaining = width - (numHits * boatWidth);
			//		}
					
					// Now find the boat.
					result1 += boatWidth;
					if (remaining != boatWidth) {
						result1++;
					}
			
			// Solve this test case;
			int result = result1;
			
			// Print the result.
			String resultStr = String.format("%s", result);
			String fullResultStr = String.format("Case #%s: %s", caseIdx,
				resultStr);
			out.println(fullResultStr);
			System.out.println(fullResultStr);
		}
		
		in.close();
		out.close();
	}
}