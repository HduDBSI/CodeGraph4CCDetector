package googlejam3.p211;
import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt");

		int cases = scan.nextInt();

		for (int i = 0; i < cases; i++) {
			int ans = 0;

			int r = scan.nextInt();
			int c = scan.nextInt();
			int w = scan.nextInt();

			ans = (r - 1) * (c / w) + (c - 1) / w + w;

			writer.print("Case #");
			writer.print(i+1);
			writer.print(": ");
			writer.print(ans);
			writer.println();
		}

		scan.close();
		writer.close();
	}

}
