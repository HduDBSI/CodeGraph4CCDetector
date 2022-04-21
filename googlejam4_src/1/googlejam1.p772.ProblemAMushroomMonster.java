package googlejam1.p772;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Yaroslav
 * @since 17-Apr-15
 */
public class ProblemAMushroomMonster {

    /**3
     * Usage: java ProblemAMushroomMonster < fileIn.txt > fileOut.txt
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        byte testCount = scanner.nextByte();

        for (byte t = 0; t < testCount; t++) {
            // read and transform inputs
            int N = scanner.nextInt();

            int[] shrooms = new int[N];
            for (int i = 0; i < N; i++) {
                shrooms[i] = scanner.nextInt();
            }


            // Strategy 1
            int counter1 = 0;
            int maxInterval = -1;
            int currInterval = 0;
            int previousNumber = shrooms[0];
            int currentNumber = 0;
            for (int i = 1; i < shrooms.length; i++) {
                currentNumber = shrooms[i];
                currInterval = Math.max(0, previousNumber - currentNumber);
                //System.out.println("currInterval = " + currInterval);
                // strategy 1
                counter1 += currInterval;
                //System.out.println("counter1 = " + counter1);
                // for strategy 2
                maxInterval = Math.max(maxInterval, currInterval);
                previousNumber = currentNumber;
            }

            //System.out.println("maxInterval = " + maxInterval);

            // Strategy 2
            int counter2 = Math.min(maxInterval, shrooms[0]);
            for (int i = 1; i < shrooms.length-1; i++) {
                int minEaten = Math.min(maxInterval, shrooms[i]);
                // System.out.println("eating " + minEaten);
                counter2 += minEaten;

            }

            System.out.println("Case #" + (t + 1) + ": " + counter1 + " " + counter2);
        }
    }
}