package googlejam1.p654;
import java.io.*;
import java.util.*;

public class A {
    public static Scanner in;
    public static PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
	in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
		"input.txt"))));
	out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
		new File("output.txt"))));
	int nCases = in.nextInt();
	in.nextLine();
	for (int CASE = 1; CASE <= nCases; CASE++) {
	    out.print("Case #" + CASE + ": ");
	    int m = in.nextInt();
		int[] a = new int[m];
		int maxD = 0;
		for (int i = 0; i < m; i++)
		    a[i] = in.nextInt();
		long r1 = 0, r2 = 0;
		for (int i = 0; i < m - 1; i++) {
		    maxD = Math.max(maxD, a[i] - a[i + 1]);
		}
		for (int i = 1; i < m; i++) {
		    if (a[i] < a[i - 1])
			r1 += a[i - 1] - a[i];
		}
		for (int i = 0; i < m - 1; i++)
		    if (a[i] < maxD)
			r2 += a[i];
		    else
			r2 += maxD;
		out.println(r1 + " " + r2);
	}
	out.close();
	System.err.println("Done");
    }
}
