package googlejam3.p354;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] s1) throws Exception {
		Main r = new Main();
		File out = new File("output.txt");
		Scanner in = new Scanner(new File("input.txt"));
		PrintStream ostr = new PrintStream(new FileOutputStream(out));
		int T = in.nextInt();
		int N = 0;
		while(N++<T){
			int r1 = in.nextInt();
			int c = in.nextInt();
			int w = in.nextInt();
			int result = (c/w)*r1 +w;
			if (c%w<1)
				result--;
			ostr.printf("Case #%d: %d%n", N, result);
		}
	}

}