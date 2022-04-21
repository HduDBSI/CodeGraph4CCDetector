package googlejam1.p743;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Mushroom {

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("./input/A-large-mushroom.in"));
			writer = new BufferedWriter(new FileWriter("./output/mushroom-large.out", false));
			final int caseCount = Integer.parseInt(reader.readLine().toString());
			System.out.println("Case count: " + caseCount);
			for (int k = 0; k < caseCount; k++) {
				final int size = Integer.parseInt(reader.readLine());
				final int[] shrooms = new int[size];
				final String[] shroomsStr = reader.readLine().split(" ");
				int rate = 0;
				for (int i = 0; i < size - 1; i++) {
					shrooms[i] = Integer.parseInt(shroomsStr[i]);
					shrooms[i + 1] = Integer.parseInt(shroomsStr[i + 1]);
					final int r = shrooms[i] - shrooms[i + 1];
					if (r > rate) {
						rate = r;
					}
				}
				int y = 0, z = 0;
				for (int i = 0; i < size - 1; i++) {
					final int curr = shrooms[i];
					final int next = shrooms[i + 1];
					final int diff = curr - next;
					if (diff > 0) {
						y += diff;
					}
					if (rate > 0) {
						z += Math.min(curr, rate);
					}
				}
				System.out.println(Arrays.toString(shrooms) + ": " + y + " " + z);
				writer.write("Case #" + (k + 1) + ": " + y + " " + z + "\n");
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished in: " + (int) (System.currentTimeMillis() - startTime) / 1000 + "s");
	}

}
