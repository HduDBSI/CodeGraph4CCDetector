package googlejam1.p533;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mushrooms {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("A-large (1).in"));

        int t = in.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int intervals = in.nextInt();
            int method1 = 0, method2 = 0;

            int[] mushrooms = new int[intervals];

            for (int i = 0; i < intervals; i++) {
                mushrooms[i] = in.nextInt();
            }
			int rate = Integer.MIN_VALUE;
			
			for (int i1 = 1; i1 < mushrooms.length; i1 ++) {
			    rate = Math.max(rate, mushrooms[i1 - 1] - mushrooms[i1]);
			}

            int maxRate = rate;

            for (int i = 1; i < intervals; i++) {
                method1 += Math.max(0, mushrooms[i - 1] - mushrooms[i]);
                method2 += Math.min(maxRate, mushrooms[i - 1]);
            }

            System.out.println("Case #" + caseNum + ": " + method1 + " " + method2);
        }
    }
}
