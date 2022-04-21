package googlejam1.p447;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Xenophon on 4/17/2015.
 */
public class P1 {
    static String filename = "./src/A-large.in";

    public static void main(String[] args) throws IOException {
        try (Scanner s = new Scanner(new FileReader(filename));
             FileWriter writer = new FileWriter(new File(filename.substring(0, filename.length() - 2) + "out"))) {

            int T = Integer.valueOf(s.nextLine());

            for (int i = 0 ; i < T ; i++) {
                // Eat a line
                s.nextLine();

                String[] intStrings = s.nextLine().split(" ");
                int[] ints = new int[intStrings.length];
                for (int inti = 0 ; inti < intStrings.length ; inti++) {
                    ints[inti] = Integer.valueOf(intStrings[inti]);
                }
				int result = 0;
				int last = 0;
				for (int i1 : ints) {
				    if (i1 < last)
				        result += last - i1;
				    last = i1;
				}

                int min1 = result;
				int max = 0;
				int last1 = 0;
				for (int i3 : ints) {
				    if (i3 < last1 && (max < (last1 - i3))) {
				        max = last1 - i3;
				    }
				    last1 = i3;
				}
				
				int result1 = 0;
				for (int i2 = 0 ; i2 < ints.length - 1; i2++) {
				    int plate = ints[i2];
				    int eatenThisTime = Math.min(plate, max);
				    result1 += eatenThisTime;
				}
                int min2 = result1;

                writer.write("Case #" + (i + 1) + ": " + min1 + " " + min2 + "\n");
                System.out.println("Case #" + (i + 1) + ": " + + min1 + " " + min2);
            }
        }
    }
}
