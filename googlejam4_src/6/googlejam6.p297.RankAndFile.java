package googlejam6.p297;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RankAndFile {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/home/mbroshi/Downloads/B-large.in"));
        int numCases = sc.nextInt();
        StringBuffer output = new StringBuffer();
        for (int i = 1; i <= numCases; i++) {
            int numRows = sc.nextInt();
            int[] intCounts = new int[2501];
            for (int h = 0; h < (2 * numRows - 1) * numRows; h++) {
                int next = sc.nextInt();
                intCounts[next] += 1;
            }
            List<Integer> missing = new ArrayList<>(numRows);
            for (int j = 1; j < 2501; j++) {
                if (intCounts[j] % 2 == 1) {
                    missing.add(j);
                }
            }
            Collections.sort(missing);
            StringBuilder builder = new StringBuilder(2 * numRows);
            for (int m : missing) {
                builder.append(" ").append(m);
            }
            output.append(String.format("Case #%d: %s\n", i, builder));
        }
        System.out.println(output);
        FileWriter fw = new FileWriter(new File("/home/mbroshi/Downloads/B-large.out"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output.toString());
        bw.close();
    }
}
