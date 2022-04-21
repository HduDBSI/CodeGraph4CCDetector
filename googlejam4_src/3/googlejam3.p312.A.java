package googlejam3.p312;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class A {

	//private static final String STAGE = "A-test";
	//private static final String STAGE = "A-small-attempt0";
	// private static final String STAGE = "A-small-attempt1";
	// private static final String STAGE = "A-small-attempt2";
	private static final String STAGE = "A-large";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = null;
		PrintStream out = null;
		try {
			in = new Scanner(new File(STAGE + ".in"));
			out = new PrintStream(new File(STAGE + ".out"));
			int t = in.nextInt();
			int caseNumber = 1;
			while (caseNumber <= t) {
				int r = in.nextInt();
				int c = in.nextInt();
				int w = in.nextInt();
				out.println("Case #" + caseNumber++ + ": " + solve(r, c, w));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static int solve(int r, int c, int w) {
		int s = r * c;
		int result = w == 1 ? s : (c / w) * r + w - (c % w == 0 ? 1 : 0);
		return result;
	}
}