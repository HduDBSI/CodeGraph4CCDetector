package googlejam1.p811;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		File fileInput = new File("A-large.in");
		File fileOutput = new File("output.out");

		BufferedReader reader = new BufferedReader(new FileReader(fileInput));
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));

		int cases = Integer.parseInt(reader.readLine());

		for (int c = 1; c <= cases; c++) {

			int n = Integer.parseInt(reader.readLine());
			String mushroomsS[] = reader.readLine().split(" ");
			int mushrooms[] = new int[n];

			for (int i = 0; i < n; i++) {
				mushrooms[i] = Integer.parseInt(mushroomsS[i]);
			}

			int eaten1 = 0;

			for (int i = 1; i < n; i++) {

				if (mushrooms[i - 1] > mushrooms[i]) {
					eaten1 += (mushrooms[i - 1] - mushrooms[i]);
				}
			}
			int t[] = Arrays.copyOf(mushrooms, mushrooms.length);
			int k = 0;
			
			for (int i1 = 1; i1 < t.length; i1++) {
				if ((t[i1-1] - t[i1]) > k) {
					k = (t[i1-1] - t[i1]);
				}
			}

			int eatCount = k;
			int eaten2 = 0;

			if (eatCount == 0) {

			} else {

				for (int i = 0; i < n - 1; i++) {

					if (mushrooms[i] < eatCount) {
						eaten2 += mushrooms[i];
					} else {
						eaten2 += eatCount;
					}
				}
			}
			writer.write("Case #" + c + ": " + eaten1 + " " + eaten2 + "\n");

		}
		reader.close();
		writer.close();
	}
}