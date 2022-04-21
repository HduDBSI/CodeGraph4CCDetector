package googlejam1.p460;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Problem1 {
	public static void main(String[] args) throws IOException {
		Scanner s = null;
		Scanner lineScan = null;
		int size;
		int currentSize;
		String line;
		File output = new File("output.txt");
		PrintWriter printer = new PrintWriter(output);
		s = new Scanner(new BufferedReader(new FileReader("A-large.in")));
		size = s.nextInt();
		s.nextLine();
		for (int i = 0; i < size; i++) {
			currentSize = s.nextInt();
			s.nextLine();
			int[] plateValues = new int[currentSize];
			line = s.nextLine();
			lineScan = new Scanner(line);
			int j = 0;
			while (lineScan.hasNextInt()) {
				plateValues[j] = lineScan.nextInt();
				j++;
			}
			int firstMethod = 0;
			int fastestRate = 0;
			for (int m = 1; m < currentSize; m++) {
				if (plateValues[m] < plateValues[m - 1]) {
					firstMethod += plateValues[m - 1] - plateValues[m];
					fastestRate = Math.max(fastestRate, plateValues[m - 1] - plateValues[m]);
				}
			}
			int secondMethod = 0;
			for (int m = 0; m < currentSize - 1; m++) {
				if (plateValues[m] > fastestRate) {
					secondMethod += fastestRate;
				} else {
					secondMethod += plateValues[m];
				}
			}
			printer.print("Case #" + (i + 1) + ": ");
			printer.println(firstMethod + " " + secondMethod);
		}
		printer.close ();   
	}
}
