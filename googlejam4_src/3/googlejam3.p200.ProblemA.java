package googlejam3.p200;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProblemA {	

	private static BufferedWriter writer;
	private static Scanner scanner;
	

private static long r, c, w, score;

	public static void main(String[] args) throws IOException {
		Path input = Paths.get("input.in");
		Path output = Paths.get("output.txt");
		scanner = new Scanner(input);
		writer = Files.newBufferedWriter(output);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			r = scanner.nextLong();
			c = scanner.nextLong();
			w = scanner.nextLong();
			long shipsPerRow = c/w;
			long minScore = 0;
			for(long i1 = 0; i1 < r - 1; i1++) {
				minScore += shipsPerRow;
			}
			long uncovered = c;
			while (uncovered > w) {
				uncovered -= w;
				minScore++;
			}
			if (uncovered == w) {
				minScore += w;
			} else {
			    minScore++;
			    minScore += (w-1);	    	
			}
			score = minScore;
			String out = String.format("Case #%d: %d", i + 1, score);
			System.err.println(out);
			writer.write(out);
			writer.newLine();
		}
		writer.close();

	}

}
