package googlejam8.p685;
import java.util.Scanner;

public class SenateEvacuation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        reader.nextLine();

        for (int i = 1; i <= t; i++) {
            int n = reader.nextInt();
            int[] p = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                p[j] = reader.nextInt();
                sum += p[j];
            }

            String sol = "";
            int acc = 0;
            while (acc < sum) {
                // find current max
                int maxP = 0, maxPI = 0;
                for (int k = 0; k < n; k++) {
                    if (p[k] > maxP) {
                        maxP = p[k];
                        maxPI = k;
                    }
                }
                p[maxPI]--; acc++;
                char e = (char)(maxPI + 65);
                sol += " " + e;
                // how many max(s) we're left with?
                int l = 0, m = 0;
                for (int k = 0; k < n; k++) {
                    if (p[k] == maxP) {
                        l++;
                        m = k;
                    }
                }
                if (l == 1) { // no good!
                    // remove the last max together
                    p[m]--; acc++;
                    char f = (char)(m + 65);
                    sol += f;
                }
            }

            System.out.println("Case #" + i + ":" + sol);
        }
    }
}
