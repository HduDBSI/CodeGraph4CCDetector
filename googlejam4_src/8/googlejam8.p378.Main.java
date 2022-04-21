package googlejam8.p378;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "src/A-large";
        System.setIn(new FileInputStream(new File(filename + ".in")));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        FileWriter fw = new FileWriter(filename + ".out");
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int[] parties = new int[n];

            int max = 0;
            int maxIdx = -1;
            int rest = 0;
            for (int i = 0; i < n; i++) {
                rest += parties[i] = sc.nextInt();
                if (parties[i] > max) {
                    max = parties[i];
                    maxIdx = i;
                }
            }

            StringBuilder result = new StringBuilder();
            if (rest % 2 == 1) {
                parties[maxIdx]--;
                rest--;
                result.append((char) ('A' + maxIdx));
                result.append(' ');
            }

            while (rest > 0) {
                for (int i = 0; i < 2; i++) {
                    max = 0;
                    maxIdx = -1;
                    for (int j = 0; j < n; j++) {
                        if (parties[j] > max) {
                            max = parties[j];
                            maxIdx = j;
                        }
                    }
                    parties[maxIdx]--;
                    rest--;
                    result.append((char) ('A' + maxIdx));
                }
                result.append(' ');
            }

            String output = "Case #" + (t+1) + ": " + result.toString().trim();
            System.out.println(output);
            fw.write(output);
            fw.write("\n");
            fw.flush();
        }
    }
}
