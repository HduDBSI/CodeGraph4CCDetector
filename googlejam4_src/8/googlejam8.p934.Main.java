package googlejam8.p934;
import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static PrintWriter writer;
    static String name = "A-small-attempt0";

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(new BufferedReader(new FileReader(new File(name + ".in"))));
        writer = new PrintWriter(new FileWriter(new File(name + ".out")));

        int t = scanner.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            writer.print("Case #" + i + ": ");
            int max = scanner.nextInt();
			int[] count = new int[14];
			int total = 0;
			int[] save = new int[3];
			
			for (int i1 = 0; i1 < max; i1++) {
			    count[i1] = scanner.nextInt();
			    total += count[i1];
			}
			
			while (total > 0) {
			    int m = -1;
			    int s = 0;
			    for (int i3 = 0; i3 < max && s <= 2; i3++) {
			        if (count[i3] > m) {
			            m = count[i3];
			            s = 0;
			            save[s] = i3;
			            s++;
			        }
			        else if (count[i3] == m) {
			            save[s] = i3;
			            s++;
			        }
			    }
			
			    if (s > 2) {
			        s = 1;
			    }
			
			    for (int i2 = 0; i2 < s; i2++) {
			        writer.print((char)('A' + save[i2]));
			        count[save[i2]]--;
			        total--;
			    }
			
			    writer.print(' ');
			}
			
			writer.println();
        }

        writer.close();
        scanner.close();
    }
}