package googlejam6.p024;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class GCJ {

	public static void main(String[] args) throws Throwable {
		long start = System.currentTimeMillis();

		String pkg = new Object(){}.getClass().getEnclosingClass().getPackage().getName().replace('.', '/');
		String dir = "src/" + pkg;

		String filename = "";

//		if (true) { filename = "sample.in"; }
//		if (true) { filename = "B-small-attempt0.in"; }
		if (true) { filename = "B-large.in"; }

		Scanner sc = null;
		try {
			sc = new Scanner(new File(dir + "/" + filename));
		} catch (FileNotFoundException e) {
			Object[] o = { e.getMessage() };
			System.err.println(Arrays.deepToString(o));
			return;
		}
		PrintWriter fout = new PrintWriter(new File(dir + "/" + filename + ".res"));

		GCJ obj = new GCJ();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			fout.write(String.format("Case #%d: ", (t + 1)));
			int n = sc.nextInt();
			int[] count = new int[2501];
			for (int i = 0; i < 2 * n - 1; i++){
				for (int j = 0; j < n; j++) {
					int x = sc.nextInt();
					count[x]++;
				}
			}
			for (int i = 0; i < count.length; i++) if (count[i] % 2 == 1) fout.print(" " + i);
			fout.println();
			fout.flush();
		}
		fout.flush();
		fout.close();
		long end = System.currentTimeMillis();
		Object[] o = { (end - start) + "ms" };
		System.err.println(Arrays.deepToString(o));
	}
	
}
