package googlejam1.p648;

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
            // method 1
			int eat1 = 0;
			for (int i2 = 0; i2 < intervals.length - 1; i2++) {
			    if (intervals[i2] > intervals[i2 + 1]) {
			        eat1 += intervals[i2] - intervals[i2 + 1];
			    }
			}
			// method 2
			// get the bigest can be eaten
			int eat2 = 0, maxEaten = 0;
			for (int i3 = 0; i3 < intervals.length - 1; i3++) {
			    if (intervals[i3] - intervals[i3 + 1] > maxEaten) {
			        maxEaten = intervals[i3] - intervals[i3 + 1];
			    }
			}
			// now eat and count
			for (int i1 = 0; i1 < intervals.length - 1; i1++) {
			    if (intervals[i1] <= maxEaten) {
			        eat2 += intervals[i1];
			    } else {
			        eat2 += maxEaten;
			    }
			}
			
			// output
			System.out.println("Case #" + i + ": " + eat1 + " " + eat2);
        }
    }
}
