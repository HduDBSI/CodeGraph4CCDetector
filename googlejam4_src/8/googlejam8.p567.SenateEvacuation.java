package googlejam8.p567;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by crist on 5/8/2016.
 * <p/>
 * https://code.google.com/codejam/contest/4314486/dashboard
 */
public class SenateEvacuation {

    public static void main(String[] args) throws FileNotFoundException {
        final int INPUT_FILE_NUMBER = 3;
        Scanner scanner = new Scanner(new File("C:\\dev\\Projects\\algorithms\\TestCases\\GoogleCodeJam\\SenateEvacuation\\input" + INPUT_FILE_NUMBER + ".txt"));
        PrintWriter printWriter = new PrintWriter(new File("C:\\dev\\Projects\\algorithms\\TestCases\\GoogleCodeJam\\SenateEvacuation\\output" + INPUT_FILE_NUMBER + ".txt"));

        int tc = scanner.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            int remaining = 0;
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
                remaining += a[i];
            }

            printWriter.write("Case #" + (t + 1) + ":");
            while (remaining > 0) {
                // find the top maximums, sort as time is not an issue
                Integer[] sorted = new Integer[a.length];
                for (int i = 0; i < a.length; i++) {
                    sorted[i] = a[i];
                }

                Arrays.sort(sorted, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });


                boolean okToRemove2 = true;
                boolean firstRemoved = false;
                boolean secondRemoved = false;
                boolean mustRemoveSame = a[0] - a[1] > 1;

                // try to remove 2
                int[] removedPos = new int[2];
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == sorted[0] && !firstRemoved) {
                        firstRemoved = true;
                        removedPos[0] = i;
                        if (mustRemoveSame) {
                            secondRemoved = true;
                            removedPos[1] = i;
                        }
                        int toRemove = 1 + (mustRemoveSame ? 1 : 0);
                        a[i] -= toRemove;
                    } else if (a[i] == sorted[1] && !mustRemoveSame && !secondRemoved) {
                        removedPos[1] = i;
                        a[i]--;
                        secondRemoved = true;
                    }

                    if (a[i] > (remaining - 2) / 2) {
                        okToRemove2 = false;
                    }
                }

                if (!okToRemove2) {
                    a[removedPos[0]]++;
                    a[removedPos[1]]++;

                    // just remove the maximum
                    boolean removed = false;
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] == sorted[0] && !removed) {
                            printWriter.write(" ");
                            printWriter.write((char) ('A' + i));
                            a[i]--;
                            removed = true;
                        }
                        if (a[i] > (remaining - 1) / 2) {
                            System.out.println("Error test case " + t + "a " + i + " " + a[i] + " remaining " + remaining);
                        }
                    }
                    remaining--;
                } else {
                    remaining -= 2;
                    printWriter.write(" ");
                    printWriter.write((char) ('A' + removedPos[0]));
                    printWriter.write((char) ('A' + removedPos[1]));
                }
            }
            printWriter.write("\n");
        }
        printWriter.flush();
        printWriter.close();
    }
}
