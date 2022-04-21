package googlejam6.p598;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prg2 {

	private static final String INPUT_FILENAME = "input.in";
	private static final String OUTPUT_FILENAME = "output.in";

	// private static final String INPUT_FILENAME = "A-small.in";
	// private static final String OUTPUT_FILENAME = "A-small-out.in";
	//
	// private static final String INPUT_FILENAME = "A-large.in";
	// private static final String OUTPUT_FILENAME = "A-large-out.in";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		BufferedWriter write = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
		Scanner scanInput = new Scanner(reader);

		int t = scanInput.nextInt();

		for (int i = 0; i < t; ++i) {
			int n = scanInput.nextInt();
			final int fixed = 2 * n - 1;
			List<Integer> output = new ArrayList<Integer>();
			StringBuilder sb = new StringBuilder();

			int[] list = new int[n * fixed];
			for (int j = 0; j < n * fixed; j++) {
				list[j] = scanInput.nextInt();
				// System.out.println(list[j]);
			}

			Arrays.sort(list);

			int count = 1;
			int k = 0;
			for (k = 0; k < list.length - 1; k++) {

				if (list[k] == list[k + 1]) {
					count++;
//					System.out.println("count " + count);
				} else {
					if (count % 2 != 0) {
						output.add(list[k]);
					}
					count = 1;
				}
			}

			if (output.size() != n) {
				output.add(list[k]);
			}

			sb.append("Case #" + (i + 1) + ": ");
			for (int a : output) {
				sb.append(a + " ");
			}
			// write.write("Case #" + (t + 1) + ": " + sb.toString() + "\n");
			write.write(sb.toString().trim() + "\n");
			// System.out.println(sb.toString().trim() + "\n");
		}

		scanInput.close();
		write.flush();
		write.close();

	}
}