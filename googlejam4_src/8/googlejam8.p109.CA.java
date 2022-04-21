package googlejam8.p109;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Benedek on 5/8/2016.
 */
public class CA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            ArrayList<Integer> senate = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                senate.add(i, 0);
            }
            int senateSize = 0;
            for (int i = 0; i < N; i++) {
                int temp = in.nextInt();
                senate.set(i, temp);
                senateSize += temp;
            }

            System.out.printf("Case #%d: ", t);
            while (senateSize > 2) {
                int max = 0;
                int maxIndex = -1;
                int second = 0;
                int secondIndex = -1;
                ArrayList<Integer> ordered = new ArrayList<>(senate);
                Collections.sort(ordered, Collections.reverseOrder());
                max = ordered.get(0);
                maxIndex = senate.indexOf(max);
                second = ordered.get(1);
                secondIndex = senate.lastIndexOf(second);
                if (max == second && senateSize != 3) {
                    System.out.print(Character.toChars(65 + maxIndex)[0]);
                    System.out.print(Character.toChars(65 + secondIndex)[0]);
                    System.out.print(" ");
                    senate.set(maxIndex, senate.get(maxIndex) - 1);
                    senate.set(secondIndex, senate.get(secondIndex) - 1);
                    senateSize -= 2;
                } else {
                    System.out.print(Character.toChars(65 + maxIndex)[0]);
                    System.out.print(" ");
                    senate.set(maxIndex, senate.get(maxIndex) - 1);
                    senateSize -= 1;
                }
            }
            if (senateSize == 2){
                int max = 0;
                int maxIndex = -1;
                int second = 0;
                int secondIndex = -1;
                ArrayList<Integer> ordered = new ArrayList<>(senate);
                Collections.sort(ordered, Collections.reverseOrder());
                max = ordered.get(0);
                maxIndex = senate.indexOf(max);
                second = ordered.get(1);
                secondIndex = senate.lastIndexOf(second);
                System.out.print(Character.toChars(65 + maxIndex)[0]);
                System.out.print(Character.toChars(65 + secondIndex)[0]);
                System.out.print(" ");
                senate.set(maxIndex, senate.get(maxIndex) - 1);
                senate.set(secondIndex, senate.get(secondIndex) - 1);
            }
            System.out.println();
        }
    }
}

