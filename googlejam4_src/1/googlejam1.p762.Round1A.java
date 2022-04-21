package googlejam1.p762;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Max Muth on 17. April 2015
 * kontakt@maxi-muth.de
 */
public class Round1A {

    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileReader("input.txt"));
        int numCases = scanner.nextInt();

        for (int n = 0; n < numCases; n++) { // Loop through cases
            int N = scanner.nextInt(); // Length of the current case

            int eaten1 = 0, eaten2 = 0, prev = 0;
            int[] numbers = new int[N];
            int spr = 0; // ShroomsPerRound for method2
            for (int i = 0; i < N; i++) { // Loop current case
                int k = scanner.nextInt();
                // Method One, 10 5 15 5
                eaten1 += prev - k > 0 ? (prev - k) : 0;
                // Fill array for method2
                numbers[i] = k;
                spr = prev - k > spr ? prev - k : spr;

                prev = k;
            }

            // Method2
            for (int i = 0; i < N - 1; i++) {
                eaten2 += numbers[i] - spr >= 0 ? spr : numbers[i];
            }

            System.out.printf("Case #%d: %d %d\n", n + 1, eaten1, eaten2);
        }


        scanner.close();
    }
}

