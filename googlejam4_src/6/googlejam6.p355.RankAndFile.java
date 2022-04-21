package googlejam6.p355;


import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Jeff on 4/15/2016.
 */
public class RankAndFile {

    public static void main(String[] args) {
        String problemSet = "B-large";

        File inFile = new File("inputs/" + problemSet + ".in");
        File outFile = new File("outputs/" + problemSet + ".out");

        try (PrintStream out = new PrintStream(new FileOutputStream(outFile))) {
            outFile.createNewFile();
            Scanner sc = new Scanner(inFile);

            int numberOfTests = sc.nextInt();
            for (int t = 0; t < numberOfTests; t++) {
                int n = sc.nextInt();
                Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
                for (int i = 0; i < 2*(n*n)-n; i++) {
                    int value = sc.nextInt();
                    Integer entry = counts.get(value);
                    if (entry == null) {
                        counts.put(value, 1);
                    } else {
                        counts.put(value, entry + 1);
                    }
                }

                int[] answer = new int[n];
                int numFound = 0;
                for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
                    if (entry.getValue() % 2 > 0) {
                        answer[numFound++] = entry.getKey();
                    }
                    if (numFound == n) {
                        break;
                    }
                }
                Arrays.sort(answer);
                out.printf("Case #%d:", t+1);
                Arrays.stream(answer).forEach( v -> out.printf(" %d", v));
                out.print("\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
