package googlejam3.p245;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException {
		String fileName = "A-large";
		Scanner s = null;
		PrintWriter p = null;
		try {
			s = new Scanner(new FileInputStream(fileName + ".in"));
			p = new PrintWriter(new File(fileName + ".out"));
		} catch (IOException e) {
		}
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int r = s.nextInt();	// row
			int c = s.nextInt();	// column
			int w = s.nextInt();	// width
			System.out.println(c / w * r + (w - 1) + (c % w == 0 ? 0 : 1));
			p.println("Case #" + (i + 1) + ": " + (c / w * r + (w - 1) + (c % w == 0 ? 0 : 1)));
		}
		p.close();
		s.close();
	}
}
