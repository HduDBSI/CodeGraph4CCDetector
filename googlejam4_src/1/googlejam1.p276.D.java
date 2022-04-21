package googlejam1.p276;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class D {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File("C:\\Users\\Samuel\\Downloads\\input.txt"));
        Integer cases = Integer.parseInt(scanner.nextLine());
        for (Integer i = 0; i < cases; i++) {
            Integer readings = Integer.parseInt(scanner.nextLine());
            String[] vals = (scanner.nextLine()).split(" ");
            ArrayList<Integer> values = new ArrayList<Integer>();
            for (String v : vals) {
                values.add(Integer.parseInt(v));
            }
            Integer maxDiff = 0;
            Integer totalDiff = 0;
            for (Integer j = 0; j < values.size() - 1; j++) {
                Integer diff = values.get(j) - values.get(j + 1);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
                if (diff > 0) {
                    totalDiff += diff;
                }
            }
            Integer eaten = 0;
            for (Integer j = 0; j < values.size() - 1; j++) {
                if (values.get(j) < maxDiff) {
                    eaten += values.get(j);
                } else {
                    eaten += maxDiff;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + totalDiff + " " + eaten);
        }
    }
}
