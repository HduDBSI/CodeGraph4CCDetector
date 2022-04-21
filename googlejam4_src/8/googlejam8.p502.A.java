package googlejam8.p502;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by dont on 08/05/16.
 */
public class A {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("X:\\A\\A-large.in"));
            FileWriter fw = new FileWriter("X:\\A\\A-large.out");

            int T = Integer.valueOf(scanner.nextInt());
            scanner.nextLine();
            for (int i = 1; i <= T; i++) {
                // handle each test case
                int N = scanner.nextInt();
                scanner.nextLine();

                int[] P = new int[N];
                for(int j=0; j<N; j++) {
                    P[j] = scanner.nextInt();
                }

                // begin algorithm
                StringBuffer result = new StringBuffer();
                int numParties = N;
                do {
                    // find max1, max2
                    int max1 = -1, max2 = -1;
                    for(int j=0; j<N; j++) {
                        if(j == 0 || P[j] > P[max1]) {
                            max1 = j;
                        }
                    }
                    for(int j=0; j<N; j++) {
                        if(j != max1 && (max2 == -1 || P[j] > P[max2])) {
                            max2 = j;
                        }
                    }

                    if(numParties == 2 && P[max1] == P[max2]) {
                        String party = String.valueOf((char) ('A' + max1)) + String.valueOf((char) ('A' + max2));
                        result.append(party + " ");
                        P[max1]--;
                        P[max2]--;
                        if(P[max1] == 0)
                            numParties -= 2;
                    } else {
                        result.append(String.valueOf((char) ('A' + max1)) + " ");
                        P[max1]--;
                        if(P[max1] == 0)
                            numParties--;
                    }

                    if(P[max1] == 0 && P[max2] == 0)
                        break;
                } while (true);
                // end algorithm

                fw.write("Case #" + i + ": " + result.toString() + "\n");
                fw.flush();
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
