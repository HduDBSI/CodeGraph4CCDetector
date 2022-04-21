package googlejam3.p060;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

	private final int input_R, input_C, input_W;

	private final String output;

	public A(final Scanner sc) {
		super();
		this.input_R = sc.nextInt();
		this.input_C = sc.nextInt();
		this.input_W = sc.nextInt();
		long nb = this.input_C / this.input_W * this.input_R;
		nb += this.input_W - 1;
		if (this.input_C % this.input_W != 0) {
			nb++;
		}
		this.output = String.valueOf(nb);
	}

	public static void main(final String[] args) {
		try (final Scanner sc = new Scanner(args.length > 0 ? new FileInputStream(args[0]) : System.in);
				final PrintStream pr = args.length > 1 ? new PrintStream(args[1]) : System.out;) {
			final int nb_test = sc.nextInt();
			for (int i = 1; i <= nb_test; i++) {
				System.out.println("Case #" + i + ": " + new A(sc));
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
