package googlejam8.p367;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SenateEvacuation {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            final int N = in.nextInt();
            final List<Integer> P = new ArrayList<>(N);
            int senatorsCount = 0;
            for(int i = 0; i < N; i++) {
                P.add(in.nextInt());
                senatorsCount += P.get(i);
            }
            System.out.printf("Case #%d: ", t);

            while(senatorsCount > 0) {
                final Integer maxInteger = Collections.max(P);
                final int indexOfMax = P.indexOf(maxInteger);

                if(maxInteger == 1) {
                    P.set(indexOfMax, maxInteger - 1);
                    senatorsCount--;
                    System.out.printf("%s", String.valueOf((char)('A' + indexOfMax)));
                    if(P.stream().filter(integer -> integer == 1).count() < 2) {
                        final Integer maxInteger2 = Collections.max(P);
                        final int indexOfMax2 = P.indexOf(maxInteger);
                        P.set(indexOfMax2, maxInteger2 - 1);
                        System.out.printf("%s", String.valueOf((char)('A' + indexOfMax2)));
                        senatorsCount--;
                    }
                } else {
                    P.set(indexOfMax, maxInteger - 1);
                    senatorsCount--;
                    System.out.printf("%s", String.valueOf((char)('A' + indexOfMax)));

                    final Integer maxInteger2 = Collections.max(P);
                    if (maxInteger2.equals(maxInteger)) {
                        final int indexOfMax2 = P.indexOf(maxInteger);
                        P.set(indexOfMax2, maxInteger2 - 1);
                        System.out.printf("%s", String.valueOf((char)('A' + indexOfMax2)));
                        senatorsCount--;
                    }
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}