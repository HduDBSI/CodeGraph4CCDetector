package googlejam1.p562;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstProb {

	public static void main(String[] args) throws IOException {
		try (Scanner scanner = new Scanner(
				new File("/Users/bbaker/Documents/practice/round1A2015/a/A-large.in"));
				Writer writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("/Users/bbaker/Documents/practice/round1A2015/a/A-large.out"), "utf-8"))) {
			int t = scanner.nextInt();
			for (int i = 1; i <= t; ++i) {
				int n = scanner.nextInt();
				
				ArrayList<Long> mushrooms = new ArrayList<>(n);
				for (int j = 0; j < n; ++j) {
					mushrooms.add(scanner.nextLong());
				}
				
				long y = 0;
				long prev = mushrooms.get(0);
				for (int j = 1; j < n; ++j) {
					long current = mushrooms.get(j);
					long diff = prev - current;
					if (diff > 0) {
						y += diff;
					}
					prev = current;
				}
				

				prev = mushrooms.get(0);
				long maxDiff = 0;
				for (int j = 1; j < n; ++j) {
					long current = mushrooms.get(j);
					long diff = prev - current;
					if (diff > maxDiff) {
						maxDiff = diff;
					}
					prev = current;
				}
				
				long z = 0;
				for (int j = 0; j < n - 1; ++j) {
					long current = mushrooms.get(j);
					long diff = current - maxDiff;
					if (diff  >= 0) {
						z += maxDiff;
					} else {
						z += (maxDiff - Math.abs(diff));
					}
				}
				
				writer.write("Case #" + i + ": " + y + " " + z + "\n");
			}
		}
	}
}
