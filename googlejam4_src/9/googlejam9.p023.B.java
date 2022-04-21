package googlejam9.p023;


import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Scanner;

public class B {
    private static final double EPS = 1e-12;
    private static final int INF = 1 << 20;
    private static final int[] di = {-1, 0, 0, 1};
    private static final int[] dj = {0, -1, 1, 0};

    // shared table
    static {
        // :TODO
    }

    final int B;
    final long M;
    final static String possible = "POSSIBLE";
    final static String impossible = "IMPOSSIBLE";

    // parse
    public B(final Scanner sc) {
        B = sc.nextInt();
        M = sc.nextLong();
    }

    // Template
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            final Object[] solvers = new Object[T];
            for (int i = 0; i < T; i++)
                solvers[i] = new B(sc);
            final Iterator<String> results = Arrays.stream(solvers)
                    .map(Object::toString)
                    .iterator();
            for (int i = 1; i <= T; i++)
                System.out.printf("Case #%s: %s\n", i, results.next());
        }
    }
}
