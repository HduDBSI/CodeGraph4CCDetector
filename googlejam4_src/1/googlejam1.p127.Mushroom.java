package googlejam1.p127;


import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mushroom {

	private static final boolean USE_SMALL = true;
	private static final String INPUT_FILE;
	private static final String OUTPUT_FILE;
	static {
		String problem = "mushroom";
		if (USE_SMALL) {
			INPUT_FILE = problem + "/A-small.in";
			OUTPUT_FILE = problem + "/small.out";
		} else {
			INPUT_FILE = problem + "/A-large.in";
			OUTPUT_FILE = problem + "/large.out";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)));
		PrintWriter out = new PrintWriter(new FileOutputStream(OUTPUT_FILE));

		int T = Integer.parseInt(in.readLine());
		for (int CASE = 1; CASE <= T; CASE++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = parseInt(st.nextToken());
			int[] array = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				array[i] = parseInt(st.nextToken());
			}
			int total1 = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] - array[i + 1] > 0) {
					total1 += array[i] - array[i + 1];
				}
			}
			int max = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] - array[i + 1] > max) {
					max = array[i] - array[i + 1];
				}
			}
			int total2 = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > max) {
					total2 += max;
				} else
					total2 += array[i];
			}

			out.println("Case #" + CASE + ": " + total1 + " " + total2);
			out.flush();
		}
		out.close();
		in.close();
	}
}