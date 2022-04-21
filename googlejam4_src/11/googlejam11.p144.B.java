package googlejam11.p144;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class B {
    private static final double EPS = 1e-12;

    final int N, K;
    final double[] P;

    // parse
    public B(final Scanner sc) {
        N = sc.nextInt();
        K = sc.nextInt();
        P = new double[N];
        for (int i = 0; i < N; i++)
            P[i] = sc.nextDouble();
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
