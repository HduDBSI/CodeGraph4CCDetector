package googlejam1.p085;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mushroom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("A-large.in"));
        int loopvar = in.nextInt();
        PrintWriter out = new PrintWriter(new File("mush.out"));
        for (int j = 0; j < loopvar; j++) {

            int mush = in.nextInt();
            int[] mushes = new int[mush];
            for (int i = 0; i < mush; i++) {
                mushes[i] = in.nextInt();
            }

            int tot = 0;
            for (int i = 1; i < mush; i++) {
                if (mushes[i - 1] > mushes[i]) {
                    tot += mushes[i-1] - mushes[i];
                }
            }

            int rate = 0;
            for (int i = 1; i < mush; i++) {
                if (mushes[i - 1] > mushes[i]) {
                    rate = Math.max(rate, mushes[i -1] - mushes[i]);
                }
            }
            int tr = 0;
            for (int i = 0; i < mush - 1; i++) {
                tr += Math.min(rate, mushes[i]);
            }

            out.printf("Case #%d: %d %d%n", j + 1, tot, tr);

        }
        out.close();
    }
}