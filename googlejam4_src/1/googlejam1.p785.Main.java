package googlejam1.p785;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileInputStream("input.txt"));
			scanner.useLocale(Locale.ENGLISH);
			BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
			int tests = scanner.nextInt();
			for (int i = 0; i < tests; i++) {
				int n = scanner.nextInt();
				int[] values = new int[n];
				for (int j = 0; j < values.length; j++) {
					values[j] = scanner.nextInt();
				}
				int minSlope = 0;
				int firstMin = 0;
				for (int j = 0; j < values.length - 1; j++) {
					int delta = values[j]-values[j+1];
					if (delta > 0) {
						firstMin += delta;
						minSlope = Math.max(minSlope, delta);
					}
				}
				int secondMin = 0;

				for (int j = 0; j < values.length - 1; j++) {
					secondMin += Math.min(values[j], minSlope);
				}
				
				out.write("Case #" + (i + 1) + ": " + firstMin + " " + secondMin + "\n");
			}
			out.close();
		} catch (FileNotFoundException e) {
			// ????
		} catch (IOException e) {
			// ????
		}
	}
}