package googlejam1.p566;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemA {
	
	private static String inputFilePath = "/home/chiwang/Downloads/CodeJam/A-large.in";
	private static String outputFilePath = "/home/chiwang/Downloads/CodeJam/Solution/";
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static int[] plate;
	private static int N;
	
	public static void main(String[] args) {
		
		// Initialisation
		try {
			outputFilePath += inputFilePath.substring(inputFilePath.lastIndexOf("/") + 1, inputFilePath.length() - 3) + ".out";
			
			br = new BufferedReader(new FileReader(inputFilePath));
			bw = new BufferedWriter(new FileWriter(outputFilePath));
			
			final int T = Integer.parseInt(br.readLine());
			
			for (int caseNum = 1; caseNum <= T; caseNum++) {		
				/*
				 * Fill in the implementation details
				 */
				int N = Integer.parseInt(br.readLine());
				plate = new int[N];
				String[] parts = br.readLine().split(" ");
				
				for (int i = 0; i < N; i++) {
					plate[i] = Integer.parseInt(parts[i]);
				}
				long eaten = 0;
				int prev = plate[0];
				for (int i = 1; i < plate.length; i++) {
					if (prev > plate[i]) {
						eaten += (prev - plate[i]);
					}
					prev = plate[i];
				}
				
				long m1 = eaten;
				long eaten1 = 0;
				
				int biggestDiff = 0;
				int prev1 = plate[0];
				for (int i = 1; i < plate.length; i++) {
					if (prev1 - plate[i] > biggestDiff) {
						biggestDiff = prev1 - plate[i];
					}
					prev1 = plate[i];
				}
				
				
				
				for (int i = 0; i < plate.length -1; i++) {
					if (plate[i] > 0) {
						eaten1 += Math.min(biggestDiff, plate[i]);
					}
				}
				long m2 = eaten1;
				
				String result = String.format("Case #%d: %d %d%n", caseNum, m1 , m2);
				bw.write(result);
				System.out.println(result);
			}		
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		System.out.println("========================================");
		System.out.println("Done! :)");
	}

}

