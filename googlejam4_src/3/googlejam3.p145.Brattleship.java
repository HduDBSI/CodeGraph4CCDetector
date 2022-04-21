package googlejam3.p145;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Brattleship{

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
			System.out.println("Couldn't open/make output file." + e.getMessage());
			e.printStackTrace();
		}
		
		int numTrials = scanner.nextInt();
		for (int trial = 1; trial <= numTrials; trial++) {
			try {
				writer.write("Case #" + trial + ": ");
				int R = scanner.nextInt();
				int C = scanner.nextInt();
				int W = scanner.nextInt();
				int steps = R*(C/W) + W - 1; // R*(C/W) + (W-1)
				if (C % W != 0)
					steps++;
				writer.write(steps + "");
				writer.write("\n");
			}catch (IOException e) {
				System.out.println("Error on trial #" + trial + "\n" + e.getMessage());
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
