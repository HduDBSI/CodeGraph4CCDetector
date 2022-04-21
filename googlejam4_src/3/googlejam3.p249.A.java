package googlejam3.p249;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws FileNotFoundException {
		Locale.setDefault(Locale.US);
//		try (Scanner scanner = new Scanner(new File("a_example.in"))) {
//		try (Scanner scanner = new Scanner(new File("a_small.in"))) {
		try (Scanner scanner = new Scanner(new File("a_large.in"))) {
			int numberOfCases = scanner.nextInt();
						
			for (int i = 1; i <= numberOfCases; i++) {
				int R = scanner.nextInt();
				int C = scanner.nextInt();
				int W = scanner.nextInt();
				
				int solution = R * (C / W) + W;
				if (C % W == 0) {
					solution--;
				}
				System.out.println("Case #" + i + ": " + solution);
			}
		}
	}
}
