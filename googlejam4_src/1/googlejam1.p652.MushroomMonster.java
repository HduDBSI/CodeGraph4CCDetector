package googlejam1.p652;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Xinan on 18/4/15.
 */
public class MushroomMonster {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Missing input!");
        } else {
            try (Scanner sc = new Scanner(new File(args[0]))) {
                int numCases = sc.nextInt();
                for (int i = 1; i <= numCases; i++) {
                    int inputLength = sc.nextInt();
                    ArrayList<Integer> input = new ArrayList<Integer>();
                    for (int j = 0; j < inputLength; j++) {
                        input.add(sc.nextInt());
                    }
					int total1 = 0;
					int max = 0;
					int previous1 = input.get(0);
					int diff, current1;
					for (int i2 = 1; i2 < input.size(); i2++) {
					    current1 = input.get(i2);
					    diff = previous1 - current1;
					    if (diff > max) {
					        max = diff;
					    }
					    previous1 = current1;
					}
					for (int i1 = 0; i1 < input.size() - 1; i1++) {
					    current1 = input.get(i1);
					    total1 += current1 < max ? current1 : max;
					}
                    int result2 = total1;
					int total = 0;
					int previous = input.remove(0);
					int current;
					while (!input.isEmpty()) {
					    current = input.remove(0);
					    if (current < previous) {
					        total += previous - current;
					    }
					    previous = current;
					}
                    int result1 = total;
                    System.out.printf("Case #%d: %d %d\n", i, result1, result2);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
