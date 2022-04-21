package googlejam6.p362;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BB {
	private static Scanner in;
	private static PrintWriter out;
	private static final boolean USE_FILE = true;
	private static final String FILE_NAME = "B-large";

	public static void main(String[] args) throws IOException {
		in = new Scanner(new BufferedReader(new InputStreamReader(USE_FILE ? new FileInputStream(FILE_NAME + ".in") : System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(USE_FILE ? new FileOutputStream(FILE_NAME + ".out") : System.out)));
		
		int testCount = in.nextInt();
		for (int test = 0; test < testCount; test++) {
			int n = in.nextInt();
			int[] a = new int[2501];
			for (int i = 0; i < (2*n-1)*n; i++) {
				a[in.nextInt()]++;
			}
			
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				if (a[i] > 0 && a[i] % 2 == 1) {
					list.add(i);
				}
			}
			Collections.sort(list);
			String s = list.toString().replace(",", "").replace("[", "").replace("]", "");
			out.println("Case #" + (test + 1) + ": " + s);
		}
		
		in.close();
		out.close();
	}
}
