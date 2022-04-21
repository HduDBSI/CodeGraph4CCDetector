package googlejam3.p452;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CodeJamA {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(new FileReader("A-small-attempt0.in"));
		try {
			// READ PROBLEM DATA
			Integer testCases = input.nextInt();
			input.nextLine();
			for (int i = 1; i <= testCases; i++) {
				int rows = input.nextInt();
				int columns = input.nextInt();
				int width = input.nextInt();
				
				int minimumHitsPerRow = columns / width + (columns % width == 0 ? 0 : 1);
				int totalInitialHits = minimumHitsPerRow * rows;
				
				int totalHits = totalInitialHits + width - 1;
				
				System.out.println("Case #" + i + ": " + totalHits);
			}

		} finally {
			input.close();
		}
	}

}