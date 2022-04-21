package googlejam3.p400;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class A {
    private final int R, C, W;

    // parse
    public A(final Scanner sc) {
        R = sc.nextInt();
        C = sc.nextInt();
        W = sc.nextInt();
    }

    // Template
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            final Object[] solvers = new Object[T];
            for (int i = 0; i < T; i++)
                solvers[i] = new A(sc);
            final Iterator<String> results = Arrays.stream(solvers)
                    .map(s -> s.toString())
                    .iterator();
            for (int i = 1; i <= T; i++)
                System.out.printf("Case #%s: %s\n", i, results.next());
        }
    }
}
