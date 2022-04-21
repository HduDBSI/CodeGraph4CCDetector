package googlejam1.p563;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Mushrooms {
	public static void main(String[] args) throws IOException {
		// IO
		BufferedReader br = new BufferedReader(
				new FileReader(new File(args[0])));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(args[1]))));

		// Solve
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; ++i) {
			int totalTime = Integer.parseInt(br.readLine());
			String[] mushroormNumbers = br.readLine().split("\\s+");

			int[] coockiesNumbers = new int[totalTime];
			
			int totalEaten = 0;
			
			double maxRate = 0;
			int current = Integer.parseInt(mushroormNumbers[0]);
			coockiesNumbers[0] = current;
			
			
			for (int time = 1; time < totalTime; ++time) {
				int newNum = Integer.parseInt(mushroormNumbers[time]);
				coockiesNumbers[time] = newNum;
				if (current > newNum) {
					totalEaten += current - newNum;
					maxRate = new Double(Math.max(maxRate, (current - newNum) / 10.0));
				}
				current = newNum;
			}
			
			double totalEatenB = 0;
			current = coockiesNumbers[0];
			for (int time = 1; time < totalTime; ++time) {
				int newNum =  coockiesNumbers[time];
				totalEatenB += Math.min(maxRate * 10, current);
				current = newNum;
			}
			
			writer.append("Case #" + (i + 1) + ": " + totalEaten + " " + new Double(totalEatenB).intValue() + "\n");
		}

		writer.close();
		br.close();
	}
}
