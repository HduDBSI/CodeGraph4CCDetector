package googlejam1.p497;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.String.format;

/**
 * @author Oleg Tsal-Tsalko
 */
public class MushroomMonster {

    public static final String IN = "src/main/resources/codejam/round1a2015/mushroom/A-large.in-2.txt";
    public static final String OUT = "src/main/resources/codejam/round1a2015/mushroom/A-large.out-2.txt";

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(OUT);
        Scanner scanner = new Scanner(new File(IN));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] mushroomsLeft = new int[N];
            for (int j = 0; j < N; j++) {
                mushroomsLeft[j] = scanner.nextInt();
            }
			int accum = 0;
			for (int i1 = 0; i1 < mushroomsLeft.length - 1; i1++) {
			    int diff = mushroomsLeft[i1] - mushroomsLeft[i1 + 1];
			    if (diff > 0) accum += diff;
			}
            int eaten1 = accum;
			int accum1 = 0;
			int maxInterval = 0;
			for (int i1 = 0; i1 < mushroomsLeft.length - 1; i1++) {
			    int diff = mushroomsLeft[i1] - mushroomsLeft[i1 + 1];
			    if (diff > maxInterval) maxInterval = diff;
			}
			for (int i2 = 0; i2 < mushroomsLeft.length - 1; i2++) {
			    accum1 += Math.min(mushroomsLeft[i2], maxInterval);
			}
            int eaten2 = accum1;
            fw.write(format("Case #%d: %d %d", i + 1, eaten1, eaten2) + "\n");
        }
        scanner.close();
        fw.close();
    }

}
