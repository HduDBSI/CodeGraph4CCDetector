package googlejam8.p411;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
	
	// Workaround for not being able to pipe a file to stdin in Eclipse.
	private static final String IN_FILE = "text/" + "A-large.in";
	
	public static void main(String[] args) throws Exception {
		try (Scanner in = new Scanner(new BufferedReader(new FileReader(IN_FILE)))) {
			int numCases = in.nextInt();
			for (int i = 0; i < numCases; i++) {
				int numParties = in.nextInt();
				int[] counts = new int[numParties];
				for (int j = 0; j < numParties; j++) {
					counts[j] = in.nextInt();
				}
				StringBuilder result1 = new StringBuilder();
				int totalCount = Arrays.stream(counts).sum();
				int numRemoved = 0;
				while (numRemoved < totalCount) {
					if (result1.length() > 0) {
						result1.append(" ");
					}
					Integer maxVal = null;
					Integer secondMax = null;
					Integer ix11 = null;
					Integer ix21 = null;
					
					for (int i1 = 0; i1 < counts.length; i1++) {
						if (maxVal == null || counts[i1] > maxVal) {
							if (maxVal != null && (secondMax == null || maxVal > secondMax)) {
								secondMax = maxVal;
								ix21 = ix11;
							}
							maxVal = counts[i1];
							ix11 = i1;
						}
						else if (secondMax == null || counts[i1] > secondMax) {
							secondMax = counts[i1];
							ix21 = i1;
						}
					}
					
					assert (ix11 == null || ix11 != ix21);
					
					Integer[] maxIxs = new Integer[] { ix11, ix21 };
					int ix1 = maxIxs[0];
					int ix2 = maxIxs[1];
					
					if (counts[ix1] == counts[ix2] && !(counts[ix1] == 1 && totalCount - numRemoved == 3)) {
						result1.append((char) ('A' + ix1));
						result1.append((char) ('A' + ix2));
						counts[ix1]--;
						counts[ix2]--;
						numRemoved += 2;
					}
					else {
						result1.append((char) ('A' + ix1));
						counts[ix1]--;
						numRemoved++;
					}
				}
				
				String result = result1.toString();
				String resultStr = result;
				
				System.out.println(String.format("Case #%s: %s", i+1, resultStr));
			}
		}
	}
}
