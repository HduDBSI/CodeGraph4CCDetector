package googlejam1.p724;


import java.util.Scanner;

/**
 * Created by jestinepaul on 18/4/15.
 */
public class MushroomMonster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {

            int numIntervals = scanner.nextInt();

            int[] numMushrooms = new int[numIntervals];

            for (int j = 0; j < numIntervals; j++) {
                numMushrooms[j] = scanner.nextInt();
            }

            int x = 0;
            int maxDrop = 0;
            for (int j = 0; j < numIntervals - 1; j++) {
                if (numMushrooms[j+1] < numMushrooms[j]) {
                    x = x + numMushrooms[j] - numMushrooms[j + 1];
                    if ((numMushrooms[j] - numMushrooms[j + 1]) > maxDrop)
                        maxDrop = numMushrooms[j] - numMushrooms[j + 1];
                }
            }

            int y = 0;
            for (int j = 0; j < numIntervals - 1; j++) {
                    if (numMushrooms[j] < maxDrop)
                        y = y + numMushrooms[j];
                    else
                        y = y + maxDrop;
                }


            System.out.println("Case #" + (i + 1) + ": " + x + " " + y);




        }
    }

}
