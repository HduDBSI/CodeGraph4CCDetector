package googlejam1.p389;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class MainA {

	public static void main(String[] args) throws Exception {
		// Open input and output files. (stdin and stdout are not used because
		// of the lack of support for using a file as stdin in Eclipse.)
		InputStream inStream = new FileInputStream(
			"input/A-large.in");
		OutputStream outStream = new FileOutputStream(
			"output/A-large-out.txt");
		
		Scanner in = new Scanner(new BufferedInputStream(inStream));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(outStream));
		
		int numCases = in.nextInt();
		for (int caseIdx = 1; caseIdx <= numCases; caseIdx++) {
			
			int numSamples = in.nextInt();
			int[] samples = new int[numSamples];
			for (int i = 0; i < numSamples; i++) {
				samples[i] = in.nextInt();
			}
			int decreaseSum = 0;
			int maxDecrease = 0;
			
			for (int i = 0; i < samples.length - 1; i++) {
				int decrease = samples[i] - samples[i+1];
				if (decrease > 0) {
					decreaseSum += decrease;
					maxDecrease = Math.max(decrease, maxDecrease);
				}
			}
			
			double minRate = maxDecrease / 10.0;
			int time = (samples.length - 1) * 10;
			
			double minEaten1 = 0;
			for (int i = 0; i < samples.length - 1; i++) {
				minEaten1 += Math.min(minRate * 10, samples[i]);
			}
			
			int result0 = decreaseSum;
			int result1 = (int) Math.floor(minEaten1);
			
			// Solve this test case;
			int[] result = new int[] { result0, result1 };
			
			// Print the result.
			String resultStr = String.format("%s %s", result[0], result[1]);
			String fullResultStr = String.format("Case #%s: %s", caseIdx,
				resultStr);
			out.println(fullResultStr);
			System.out.println(fullResultStr);
		}
		
		in.close();
		out.close();
	}
}
