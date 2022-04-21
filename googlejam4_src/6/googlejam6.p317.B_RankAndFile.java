package googlejam6.p317;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class B_RankAndFile {

	private final String missingLine;

	public B_RankAndFile(final int N, int[][] lines) {
		super();
		Set<Integer> oddNumbers = new TreeSet<>();
		for (int j = 0; j < 2 * N - 1; j++) {
			for (int k = 0; k < N; k++) {
				if (oddNumbers.contains(lines[j][k])) {
					oddNumbers.remove(lines[j][k]);
				} else {
					oddNumbers.add(lines[j][k]);
				}
			}
		}
		StringBuilder missingLineBuilder = new StringBuilder();
		for (Integer n : oddNumbers) {
			missingLineBuilder.append(String.format("%d ", n.intValue()));
		}
		this.missingLine = missingLineBuilder.substring(0, missingLineBuilder.length() - 1);
	}

	public static void main(final String[] args) {
		try (final Scanner sc = new Scanner(args.length > 0 ? new FileInputStream(args[0]) : System.in);
				final PrintStream pr = args.length > 1 ? new PrintStream(args[1]) : System.out;) {
			final int nb_test = sc.nextInt();
			for (int i = 1; i <= nb_test; i++) {
				final int nb = sc.nextInt();
				final int[][] matrix = new int[2 * nb - 1][nb];
				for (int j = 0; j < 2 * nb - 1; j++) {
					for (int k = 0; k < nb; k++) {
						matrix[j][k] = sc.nextInt();
					}
				}
				B_RankAndFile test = new B_RankAndFile(nb, matrix);
				StringBuilder output = new StringBuilder(
						String.format("Case #%d: %s", i, test.missingLine));
				System.out.println(output.toString());
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
