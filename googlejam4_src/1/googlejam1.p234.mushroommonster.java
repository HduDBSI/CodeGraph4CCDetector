package googlejam1.p234;
// gengkev
// This is the brute-force solution.
// Useful for checking answers with other program, probably.

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mushroommonster {
	private static final boolean useStandardInput = false;
	private static final String filename = "round1A/A-large";
	private static final boolean log = false;

	


	// ----------------------------------------------------------------------------------------------------------------
	// competition helper methods

	private static BufferedReader reader;
	private static BufferedWriter writer;

	public static void main(String[] args) throws IOException {
		if (useStandardInput) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new StringWriter());
		} else {
			reader = new BufferedReader(new FileReader(filename + ".in"));
			writer = new BufferedWriter(new FileWriter(filename + ".out"));
		}
		final int T = Integer.parseInt(reader.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(reader.readLine());
			String[] strings = reader.readLine().split("\\s");
			int L = strings.length;
			int[] ints = new int[L];
			for (int i3 = 0; i3 < L; i3++) {
				ints[i3] = Integer.parseInt(strings[i3]);
			}
			int[] mushrooms = ints;
			int N1 = mushrooms.length;
			int total = 0;
			for (int i1 = 1; i1 < N1; i1++) {
				// if mushrooms decrease
				if (mushrooms[i1] < mushrooms[i1-1]) {
					int diff = mushrooms[i1-1] - mushrooms[i1];
					total += diff;
				}
			}
			int result1 = total;
			int N2 = mushrooms.length;
			int max = 0;
			for (int i2 = 1; i2 < N2; i2++) {
				// if mushrooms decrease
				if (mushrooms[i2] < mushrooms[i2-1]) {
					int diff = mushrooms[i2-1] - mushrooms[i2];
					if (diff > max) max = diff;
				}
			}
			
			if (log) System.out.println("max = " + max);
			
			int total1 = 0;
			for (int i1 = 1; i1 < N2; i1++) {
				int x = Math.min(mushrooms[i1-1], max);
				total1 += x;
			}
			int result2 = total1;
			String output = "Case #" + i + ": " + String.valueOf(result1) + " " + String.valueOf(result2) + "\n";
			System.out.print("OUT: " + output);
			if (!useStandardInput) {
				writer.write(output);
			}
		}
		reader.close();
		writer.close();
		if (!useStandardInput)
			System.out.println("FINISHED for file " + filename);
		System.exit(0);
	}
}
