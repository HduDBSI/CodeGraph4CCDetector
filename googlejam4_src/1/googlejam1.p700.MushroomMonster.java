package googlejam1.p700;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by anhsu on 4/17/15.
 */
public class MushroomMonster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources/googleCodeJam2015/round1a/mushroomMonster/A-large.in"));
        PrintWriter writer = new PrintWriter("resources/googleCodeJam2015/round1a/mushroomMonster/A-large.out", "UTF-8");

        int numofTestCases = Integer.valueOf(br.readLine());
        int[] answer1 = new int[numofTestCases];
        for (int i = 0; i < numofTestCases; i++) {
            String testCase = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalA = 0;
            int currentNumMushroom = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int nextMushroom = Integer.parseInt(st.nextToken());
                if (nextMushroom < currentNumMushroom) {
                    totalA += currentNumMushroom - nextMushroom;
                }
                currentNumMushroom = nextMushroom;
            }

            answer1[i] = totalA;
        }

        br = new BufferedReader(new FileReader("resources/googleCodeJam2015/round1a/mushroomMonster/A-large.in"));
        numofTestCases = Integer.valueOf(br.readLine());
        for (int i = 0; i < numofTestCases; i++) {
            String testCase = br.readLine();
            String[] array = br.readLine().split("\\s+");

            int maxDiff = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if ((Integer.parseInt(array[j]) - Integer.parseInt(array[j + 1])) > maxDiff) {
                    maxDiff = Integer.parseInt(array[j]) - Integer.parseInt(array[j + 1]);
                }
            }
            int rate = maxDiff;

            int answer2 = 0;
            for (int j = 0; j < array.length - 1; j++) {
                answer2 += Math.min(rate, Integer.parseInt(array[j]));
            }

            int testCaseNumber = i + 1;
            writer.println("Case #" + testCaseNumber + ": " + answer1[testCaseNumber - 1] + " " + answer2);
        }
        writer.close();
        br.close();
    }
}
