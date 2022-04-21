package googlejam1.p126;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MushroomMonster {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open input file.\n" + e.getMessage());
			e.printStackTrace();
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File("output.txt"));
		} catch (IOException e) {
			System.out.println("Couldn't open/make output file."
					+ e.getMessage());
			e.printStackTrace();
		}

		int numTrials = scanner.nextInt();
		for (int trial = 1; trial <= numTrials; trial++) {
			try {
				writer.write("Case #" + trial + ": ");
				int N = scanner.nextInt();
				
				int previous = scanner.nextInt();
				int sum = 0;
				int max = 0;
				int[] values = new int[N];
				values[0] = previous;
				for (int i = 1; i < N; i++) {
					int current = scanner.nextInt();
					values[i] = current;
					int difference = previous - current;
					if (difference > 0) {
						max = Math.max(difference, max);
						sum += difference;
					}
					previous = current;
				}
				int sum2 = 0;
				for (int i = 0; i < N-1; i++) {
					if (values[i] >= max)
						sum2 += max;
					else
						sum2 += values[i];
				}
				writer.write(sum + " " + sum2);
				writer.write("\n");
			} catch (IOException e) {
				System.out.println("Error on trial #" + trial + "\n"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
		System.out.println("Completed Trials!");
	}
}
