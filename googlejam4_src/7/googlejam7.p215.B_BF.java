package googlejam7.p215;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class B_BF {
    private char[] C, J;

    // parse
    public B_BF(final Scanner sc) {
        C = sc.next().toCharArray();
        J = sc.next().toCharArray();
    }

    // Template
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            final Object[] solvers = new Object[T];
            for (int i = 0; i < T; i++)
                solvers[i] = new B_BF(sc);
            final Iterator<String> results = Arrays.stream(solvers)
                    .map(Object::toString)
                    .iterator();
            for (int i = 1; i <= T; i++)
                System.out.printf("Case #%s: %s\n", i, results.next());
        }
    }
}
