package googlejam3.p446;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class A {

    private A() {
    }

    public static void main(final String[] args) throws Exception {
        final A a = new A();
        final BufferedReader in = new BufferedReader(new FileReader(new File("f.in")));
		System.setOut(new PrintStream(a.getClass().getSimpleName() + ".out"));
		final String line = in.readLine();
		final int test = Integer.parseInt(line);
		
		
		start: for (int w = 1; w <= test; w++) {
		
		    final String s = in.readLine();
		    final String[] ss = s.split(" ");
		    final int r = Integer.parseInt(ss[0]);
		    final int c = Integer.parseInt(ss[1]);
		    final int x = Integer.parseInt(ss[2]);
		
		    if (x == c) {
		        System.out.println("Case #" + w + ": " + x * r);
		        continue;
		    }
		
		    final int m = c % x;
		    final int d = m + x;
		
		    if (c <= d) {
		        // / FIXME
		        System.out.println("Case #" + w + ": " + (x + 1) * r);
		        continue;
		    }
		
		
		    int q = (c / x) - 1;
		    if (m == 0) {
		        q--;
		    }
		
		    System.out.println("Case #" + w + ": " + (q + (x + 1)) * r);
		}
    }

    long[] mas = new long[41];
    final Set<Long> qq = new HashSet<Long>();

}
