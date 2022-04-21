package googlejam3.p185;
import static java.util.Arrays.deepToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AL {
	static final boolean _PRACTICE = false;
	static final boolean _SMALL = false;
	static final boolean _FILEOUT = true;
	static final String _PROBLEM = "A";

	private int R, C, W;

	private int compute() {
		int firstHit = C / W * R;
		return firstHit + (W - 1) + ((C % W == 0) ? 0 : 1);
	}

	public static void main(String... args) throws IOException {
		FileInputStream is = null;
		PrintStream ps = null;
		if (_SMALL) {
			int i = 0;
			while (new File(_PROBLEM + "-small"
			+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".in").exists())
				i++;
			i--;
			if (new File(_PROBLEM + "-small"
			+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".out").exists()) {
				System.err.println("overwrite?(y/n)");
				char c = (char) System.in.read();
				if (c != 'y') {
					return;
				}
			}
			System.setIn(is = new FileInputStream(_PROBLEM + "-small"
			+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".in"));
			if (_FILEOUT) {
				System.setOut(ps = new PrintStream(_PROBLEM + "-small"
				+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".out"));
			}
			AL r = new AL();
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			for (int k = 1; k <= t; k++) {
				System.out.print("Case #" + k + ": ");
			
				r.R = sc.nextInt();
				r.C = sc.nextInt();
				r.W = sc.nextInt();
			
				System.out.println(r.compute());
			}
			if (sc != null) {
				sc.close();
			}
		} else {
			System.setIn(is = new FileInputStream(_PROBLEM + "-large" + (_PRACTICE ? "-practice" : "") + ".in"));
			if (_FILEOUT) {
				System.setOut(ps = new PrintStream(_PROBLEM + "-large" + (_PRACTICE ? "-practice" : "") + ".out"));
			}
			AL r = new AL();
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			for (int k = 1; k <= t; k++) {
				System.out.print("Case #" + k + ": ");
			
				r.R = sc.nextInt();
				r.C = sc.nextInt();
				r.W = sc.nextInt();
			
				System.out.println(r.compute());
			}
			if (sc != null) {
				sc.close();
			}
		}
		if (is != null)
			is.close();
		if (ps != null)
			ps.close();
	}
}
