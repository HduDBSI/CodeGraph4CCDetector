package googlejam3.p490;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Battleship {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Battleship [inputFile]");
            System.exit(0);
        }
        String input = args[0];
        Scanner scanner = new Scanner(new File(input));
        PrintWriter out = new PrintWriter(input.substring(0, input.length()-3) + ".out");
        
        int numCases = scanner.nextInt();
        
        for (int curCase = 1; curCase <= numCases; curCase++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int W = scanner.nextInt();
			int score = 0;
			
			int numOnRow = C / W;
			if (C % W != 0) {
			    numOnRow++;
			}
			score += (R-1) * numOnRow;
			
			score += C / W + (W-1);
			if (C % W != 0) {
			    score++;
			}
            
            int minScore = score;
            
            out.println("Case #" + curCase + ": " + minScore);
        }
        scanner.close();
        out.close();
    }
}
