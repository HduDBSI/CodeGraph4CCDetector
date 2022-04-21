package googlejam3.p223;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-small";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    public static void main(String args[]) throws Exception {
        A r = new A();
		int t = r.sc.nextInt();
		for (int i = 1; i <= t; i++) {
		    r.out.print("Case #" + i + ": ");
		    int ans = 0;
			int R = r.sc.nextInt();
			int C = r.sc.nextInt();
			int W = r.sc.nextInt();
			
			ans += R * ((C - 1)/W);
			ans += R * W;
			
			r.out.println(ans);
		}
		r.sc.close();
		r.out.close();
    }
}