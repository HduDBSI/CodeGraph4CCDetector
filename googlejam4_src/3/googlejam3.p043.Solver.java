package googlejam3.p043;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solver {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("input.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.out"));

		int t = Integer.parseInt(reader.readLine());

		for (int c = 1; c <= t; ++c) {
			int result = 0;
			
			String[] values = reader.readLine().split(" ");
			int rows = Integer.parseInt(values [0]);
			int cows = Integer.parseInt(values[1]);
			int w = Integer.parseInt(values[2]);
			
			int perRow = cows / w;
			result = perRow * rows;
			
			int currentCow = (cows / w) * w;
			if (currentCow == cows) {
				result += (w - 1);
			} else {
				result += w;
			}
			
			
			System.out.println("Case #" + c + ": " + result);
			writer.write("Case #" + c + ": " + result);
			writer.newLine();	
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}

}
