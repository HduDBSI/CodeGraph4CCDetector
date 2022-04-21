package googlejam8.p070;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("A-large (1).in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));

        int caseLength = in.nextInt();
        for (int caseNumber = 1; caseNumber <= caseLength; caseNumber++) {
            out.write(String.format("Case #%d: ", caseNumber));
            int partyCount = in.nextInt();

            int[] party = new int[partyCount];
            int total = 0;

            for (int i = 0; i < partyCount; i++) {
                party[i] = in.nextInt();
                total += party[i];
            }

            ArrayList<Integer> nonZero = new ArrayList<>();
            for (int i = 0; i < partyCount; i++) {
                if (party[i] > 0) {
                    nonZero.add(i);
                }
            }

            if (nonZero.size() == 2) {
                int count = party[nonZero.get(0)];
                int first = nonZero.get(0);
                int second = nonZero.get(1);

                for (int i = 0; i < count; i++) {
                    out.write((char) ('A' + first));
                    out.write((char) ('A' + second));
                    out.write((' '));
                }
            } else {

                while (total > 2) {
                    int maxParty = 0;

                    for (int i = 1; i < partyCount; i++) {
                        if (party[i] > party[maxParty]) {
                            maxParty = i;
                        }
                    }

                    party[maxParty]--;
                    total--;
                    out.write((char) ('A' + maxParty));
                    out.write(' ');
                }

                for (int i = 0; i < partyCount; i++) {
                    if (party[i] != 0) {
                        out.write((char) ('A' + i));
                    }
                }
            }

            out.write('\n');

        }

        out.close();
    }
}
