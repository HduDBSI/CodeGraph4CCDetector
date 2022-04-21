package googlejam1.p505;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MushroomMonster {

	public static void main (String [] args) throws IOException {
		String root = "A-large";
		String fileName = "C:\\Users\\Aaron\\Downloads\\" + root + ".in";
		BufferedReader reader = new BufferedReader (new FileReader(new File(fileName)));
		int nTestCases = Integer.parseInt(reader.readLine());
		ArrayList<String> out = new ArrayList<String>();
		for (int t = 0; t < nTestCases; t++) {
			int numWatches = Integer.parseInt(reader.readLine());
			String[] parts = reader.readLine().split(" ");
			int[] eat = new int[parts.length];
			for (int i = 0; i < parts.length; i++) eat[i] = Integer.parseInt(parts[i]);
			// Eat as much as she wants
			int numEaten1 = 0;
			for (int i1 = 1; i1 < eat.length; i1++) {
				numEaten1 += Math.max(0, eat[i1 - 1] - eat[i1]);
			}
			
			int y = numEaten1;
			//10 second intervals.  Biggest rate of change?
			int numEaten = 0;
			int maxRate = 0;
			for (int i = 1; i < eat.length; i++) {
				int rate = (eat[i - 1] - eat[i]);
				maxRate = Math.max(maxRate, rate);
			}
			
			System.out.println("Max rate: " + maxRate);
			
			for (int i = 0; i < eat.length; i++) {
				numEaten += maxRate;
				if (eat[i] < maxRate) {
					numEaten -= maxRate - eat[i];
					
				}
			}
			numEaten -= Math.min(maxRate, eat[eat.length - 1]);
			numEaten = Math.max(0, numEaten);
			int z = numEaten;
			
			
			System.out.println("Input: " + Arrays.toString(eat));
			System.out.println("Answer: " + y + " " + z);
			System.out.println("-----------------");
			out.add("Case #" + (t+1) + ": " + y + " " + z);
		}
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Aaron\\Downloads\\"+ root + "-SOL.out")));
		for (String s : out) {
			writer.write(s + "\n");
		}
		
		writer.close();
		reader.close();
	}
	
}
