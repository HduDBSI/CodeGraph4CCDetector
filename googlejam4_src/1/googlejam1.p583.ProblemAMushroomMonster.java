package googlejam1.p583;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemAMushroomMonster {

	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new FileReader("files/com/google/code/codejam2015/r1a/A-large.in"));
		final BufferedWriter writer = new BufferedWriter(new FileWriter("files/com/google/code/codejam2015/r1a/A-large.out"));

		final int T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {

			final int N = Integer.parseInt(reader.readLine());
			final String[] line = reader.readLine().split(" ");
			final int[] m = new int[N];
			
			for (int i = 0; i < line.length; i++) {
				m[i] = Integer.parseInt(line[i]);
			}
			
			int y = 0;
			int maxDiff = 0;
			for (int i = 0; i < m.length - 1; i++) {
				if (m[i] > m[i + 1]) {
					final int diff = m[i] - m[i + 1];
					y += diff;
					if (diff > maxDiff) {
						maxDiff = diff;
					}
				}
			}
			
			int z = 0;
			if (maxDiff > 0) {
				for (int i = 0; i < m.length - 1; i++) {
					if (m[i] > maxDiff) {
						z += maxDiff;
					} else {
						z += m[i];
					}
				}
			}
			
			String result = "Case #" + (t + 1) + ": " + y + " " + z;
			System.out.print(result + "\n");
			writer.write(result + "\n");
		}
		
		reader.close();
		writer.close();
	}

}
