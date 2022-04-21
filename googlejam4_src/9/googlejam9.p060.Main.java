package googlejam9.p060;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("B-large.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));

        int caseLength = in.nextInt();
        for (int caseNumber = 1; caseNumber <= caseLength; caseNumber++) {
            System.out.println("==" + caseNumber);
            out.write(String.format("Case #%d: ", caseNumber));
            int buildingCount = in.nextInt();
            long target = in.nextLong() - 1;

            long temp = Long.highestOneBit(target);
            int buildingNeeded = temp != 0 ? Long.numberOfTrailingZeros(temp) + 3 : 2;

            if (buildingCount < buildingNeeded) {
                out.write("IMPOSSIBLE\n");
                continue;
            }

            out.write("POSSIBLE\n");

            boolean[] answer = new boolean[buildingCount];
            answer[0] = true;

            while (target > 0) {
                System.out.println(target);

                long temp2 = Long.highestOneBit(target);
                answer[Long.numberOfTrailingZeros(temp2) + 1] = true;
                target -= temp2;
            }

            for (int i = buildingCount - 1; i >= 0; i--) {
                out.write(answer[i] ? '1' : '0');
            }

            out.newLine();

            for (int i = 1; i < buildingCount; i++) {
                for (int j = 0; j < i + 1; j++) {
                    out.write('0');
                }

                for (int j = 0; j < buildingCount - (i + 1); j++) {
                    out.write('1');
                }

                out.newLine();
            }
        }

        out.close();
    }
}
