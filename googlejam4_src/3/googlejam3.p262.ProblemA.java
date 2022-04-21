package googlejam3.p262;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("/Users/bfa/Documents/workspace/cf300/src/A-large.in"));
		Formatter format = new Formatter(new File("/Users/bfa/Documents/workspace/cf300/src/large.out"));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			int w = in.nextInt();

			int k = c / w;

			int result = r * k;
			result+=(w-1);

			if (c % w != 0) {
				result++;
			}

			
			format.format("Case #%d: %d%n", i, result);
		}
		format.flush();
		format.close();
		in.close();
	}

}
