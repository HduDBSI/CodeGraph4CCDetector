package googlejam8.p572;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
	private static Scanner in;
	private static PrintWriter out;
	private static final boolean USE_FILE = true;
	private static final String FILE_NAME = "A-large";

	public static void main(String[] args) throws IOException {
		in = new Scanner(new BufferedReader(new InputStreamReader(USE_FILE ? new FileInputStream(FILE_NAME + ".in") : System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(USE_FILE ? new FileOutputStream(FILE_NAME + ".out") : System.out)));
		
		int testCount = in.nextInt();
		for (int test = 0; test < testCount; test++) {
			int N = in.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = in.nextInt();
			}
			
			String res = "";
			int max = 0;
			int nz = 0;
			int z1 = -1;
			int z2 = -1;
			while (true) {
				for (int i = 0; i < a.length; i++) {
					if (a[i] > a[max]) {
						max = i;
					}
					if (a[i] > 0) {
						nz++;
						z2 = z1;
						z1 = i;
					}
				}
				if (nz == 0) {
					break;
				}
				if (nz == 1 || nz > 2) {
					res += (char)('A' + max) + " ";
					a[max]--;
				}
				if (nz == 2) {
					if (a[z1] == a[z2]) {
						res += (char)('A' + z1) + "" +  (char)('A' + z2) + " ";
						a[z1]--;
						a[z2]--;
					} else {
						res += (char)('A' + max) + " ";
						a[max]--;
					}
				}
				max = 0;
				nz = 0;
				z1 = -1;
				z2 = -1;
			}
			out.println("Case #" + (test + 1) + ": " + res.trim());
		}
		
		in.close();
		out.close();
	}
}
