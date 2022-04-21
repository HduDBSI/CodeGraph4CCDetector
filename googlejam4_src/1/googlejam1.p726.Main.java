package googlejam1.p726;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String args[]) {
		Scanner s = null;
		PrintWriter out = null;

		try {
			String inputFilename;
			if (args.length > 0) {
				inputFilename = args[0];
			} else {
				System.out.print("Input file name: ");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				inputFilename = in.readLine();
			}

			File f = new File("data/" + inputFilename);
			String outputFilename = inputFilename.replaceFirst("(\\.in)?$",
					".out");

			s = new Scanner(new FileReader(f));
			out = new PrintWriter(new FileWriter("data/" + outputFilename));
			int testCases = s.nextInt();
			for (int t = 1; t <= testCases; ++t) {
				int sampleCount = s.nextInt();
				Vector<Integer> samples = new Vector<Integer>(sampleCount);
				for (int i = 0; i < sampleCount; ++i) {
					samples.add(s.nextInt());
				}
				int result = 0;
				for (int i = 1; i < samples.size(); ++i) {
					int diff = samples.elementAt(i - 1) - samples.elementAt(i);
					if (diff > 0) {
						result += diff;
					}
				}

				int method1 = result;
				int maxDown = 0;
				for (int i = 1; i < samples.size(); ++i) {
					int diff = samples.elementAt(i - 1) - samples.elementAt(i);
					if (diff > maxDown) {
						maxDown = diff;
					}
				}
				
				int result1 = 0;
				for (int i = 1; i < samples.size(); ++i) {
					if (samples.elementAt(i) == 0) {
						result1 += samples.elementAt(i - 1);
					} else if (samples.elementAt(i - 1) < maxDown) {
						result1 += samples.elementAt(i - 1);
					} else {
						result1 += maxDown;
					}
				}
				int method2 = result1;

				out.println("Case #" + t + ": " + method1 + " " + method2);
			}

			out.close();
			s.close();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (null != out)
				out.close();
			if (null != s)
				s.close();
		}
	}
}
