package googlejam2.p057;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CodeJam {

	Scanner in;
	PrintWriter out;

	
	static private final String path = "C:\\jam\\1B\\";
	static private final String problem = "A";
	static private final String tests = "A-small";
	

	public static void main(String[] args) {
		CodeJam r = new CodeJam();
		try {
					r.in = new Scanner(new FileReader(CodeJam.path + CodeJam.problem + "\\" + CodeJam.tests + ".in"));
					r.out = new PrintWriter(CodeJam.path + CodeJam.problem + "\\" + CodeJam.tests + ".out");
				} catch (IOException e) {
					throw new Error(e);
					
		//			in = new Scanner(System.in);
		//			out = new PrintWriter(System.out);
		//			out.println(">");
		//			out.flush();
				}
				try {
					int n = r.in.nextInt();
					for (int test = 1; test <= n; test++) {
						r.out.print("Case #" + test + ": ");
						int n1 = r.in.nextInt();
						int ar[] = new int[1 + n1];
						ar[1] = 1;
						for (int i = 2; i <= n1; i++) {
							ar[i] = ar[i - 1] + 1;
							StringBuilder s = new StringBuilder(i + "");
							int rev = Integer.parseInt(s.reverse().toString());
							int len = (rev + "").length();
							int len2 = (i + "").length();
							if (len == len2 && rev < i) {
								ar[i] = Math.min(ar[i], ar[rev] + 1);
							}
						}
						r.out.println(ar[n1]);
						r.out.flush();
					}
				} finally {
					r.out.close();
				}
	}
}