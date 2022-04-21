package googlejam9.p036;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StreamTokenizer;

public class Slides {

	public static void main(String[] args) throws Exception {
		Slides object = new Slides();
		String className = object.getClass().getSimpleName();

		FileReader fileReader = new FileReader(new File(className.toLowerCase() + ".in"));
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));

		FileWriter wr = new FileWriter(className.toLowerCase() + ".out");

		st.nextToken();
		int testCases = (int) st.nval;

		st.resetSyntax();
		st.wordChars(0, 256);
		st.whitespaceChars(0, 32);

		for (int tc = 1; tc <= testCases; tc++) {

			System.out.println("At test " + tc + "/" + testCases);

			st.nextToken();
			int B = Integer.valueOf(st.sval);

			st.nextToken();
			long M = Long.valueOf(st.sval);
			int[][] mat = new int[B][B];
			String result1 = "IMPOSSIBLE";
			
			long[] row = new long[B];
			
			for (int i = 0; i < B - 1; i++)
				for (int j = 0; j < B - 1; j++) {
			
					if (i >= j) {
						continue;
					}
			
					mat[i][j] = 1;
				}
			
			row[0] = row[1] = 1;
			for (int i = 2; i < B - 1; i++) {
				row[i] = 2 * row[i - 1];
			}
			
			long requested = M;
			
			for (int i = B - 2; i >= 0; i--) {
			
				if (row[i] <= requested) {
					requested -= row[i];
					mat[i][B - 1] = 1;
				}
			
			}
			
			if (requested == 0) {
				// encode
			
				result1 = "POSSIBLE\n";
			
				for (int i = 0; i < B; i++) {
					for (int j = 0; j < B; j++)
						result1 += mat[i][j];
			
					result1 += "\n";
				}
			}

			String result = result1;

			wr.write("Case #" + tc + ": " + result.trim() + "\r\n");
		}

		wr.close();
	}

}
