package googlejam3.p257;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

class Brattleship {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(args[0].replace(".in", ".out"));

		int numberOfCases = Integer.parseInt(in.readLine());
		for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
			out.printf("Case #%d: ", caseNumber);

			String[] params = in.readLine().split(" ");
			int rows = Integer.parseInt(params[0]);
			int columns = Integer.parseInt(params[1]);
			int shipWidth = Integer.parseInt(params[2]);

			int scoutsPerRow = columns / shipWidth;
			int totalScouts = scoutsPerRow * rows;
			int totalCalls = totalScouts + shipWidth - 1;

			if (columns % shipWidth > 0) totalCalls += 1;

			out.println(totalCalls);
		}

		in.close();
		out.close();
	}
}