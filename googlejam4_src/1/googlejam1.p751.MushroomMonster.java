package googlejam1.p751;
import java.util.Scanner;

/**
 * Created by david on 18/04/15.
 */
public class MushroomMonster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        int numTimes;
        int[] mushrooms;
        int maxMushroomsForCase2;
        long mushroomsCase1;
        long mushroomsCase2;

        for (int casesIterator = 0; casesIterator < numTestCases; casesIterator++) {
            numTimes = scanner.nextInt();
            mushrooms = new int[numTimes];
            maxMushroomsForCase2 = 0;
            mushroomsCase1 = 0;
            mushroomsCase2 = 0;

            mushrooms[0] = scanner.nextInt();
            for (int timesIterator = 1; timesIterator < numTimes; timesIterator++) {
                mushrooms[timesIterator] = scanner.nextInt();
                if (mushrooms[timesIterator] < mushrooms[timesIterator - 1]) {
                    mushroomsCase1 += mushrooms[timesIterator - 1] - mushrooms[timesIterator];
                    maxMushroomsForCase2 = Math.max(maxMushroomsForCase2, mushrooms[timesIterator - 1] - mushrooms[timesIterator]);
                }
            }

            for (int timesIterator = 0; timesIterator < numTimes - 1; timesIterator++) {
                mushroomsCase2 += Math.min(mushrooms[timesIterator], maxMushroomsForCase2);
            }

            System.out.println("Case #" + (casesIterator + 1) + ": " + mushroomsCase1 + " " + mushroomsCase2);
        }
    }
}
