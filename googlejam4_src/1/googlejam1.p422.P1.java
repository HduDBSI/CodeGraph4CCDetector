package googlejam1.p422;
import java.io.*;
import java.util.*;

public class P1 {
	public static void main (String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner (System.in);
//		PrintStream op = System.out;
		Scanner sc = new Scanner (new FileInputStream ("D:\\Internet\\A-large.in"));
		PrintStream op = new PrintStream ("D:\\Dropbox\\SRMs\\GCJ151A\\src\\A-large-output.txt");
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] m = new int [n];
			int y = 0, max = 0;
			for (int i = 0; i < n; i++) {
				m[i] = sc.nextInt();
				if (i > 0 && m[i] < m[i - 1]) {
					y += m[i - 1] - m[i];
					max = Math.max(max, m[i - 1] - m[i]);
				}
			}
			int z = 0;
			for (int i = 1; i < n; i++)
				z += Math.min(max, m[i - 1]);
			op.println("Case #" + t + ": " + y + " " + z);
		}
		sc.close();
		op.close();
	}
}