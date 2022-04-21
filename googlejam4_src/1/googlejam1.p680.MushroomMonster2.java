package googlejam1.p680;

import java.util.Scanner;

/**
 *
 * @author aboRagab
 */
public class MushroomMonster2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int[] intervals = new int[N];
            for (int j = 0; j < N; j++) {
                intervals[j] = in.nextInt();
            }
             int eat1 = 0;
        for (int j = 0; j < intervals.length - 1; j++) {
            if (intervals[j] > intervals[j + 1]) {
                eat1 += intervals[j] - intervals[j + 1];
            }
        }
       
        int eat2 = 0, maxEaten = 0;
        for (int j = 0; j < intervals.length - 1; j++) {
            if (intervals[j] - intervals[j + 1] > maxEaten) {
                maxEaten = intervals[j] - intervals[j + 1];
            }
        }
        
        for (int j = 0; j < intervals.length - 1; j++) {
            if (intervals[j] <= maxEaten) {
                eat2 += intervals[j];
            } else {
                eat2 += maxEaten;
            }
        }

       
        System.out.println("Case #" + (i) + ": " + eat1 + " " + eat2);
        }
    }


}
