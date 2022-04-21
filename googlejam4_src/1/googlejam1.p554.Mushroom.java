package googlejam1.p554;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by cheto on 4/17/2015.
 */
public class Mushroom {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].length() - 2) + "out"));
        int testCases = Integer.parseInt(reader.readLine());
        System.out.println("Test cases: " + testCases);
        for (int test = 0; test < testCases; test++) {
            int n = Integer.parseInt(reader.readLine());
            String[] splitLine = reader.readLine().split(" ");
            int case1 = 0;
            int case2 = 0;
            int maxEat = 0;
            for (int i = 0; i < n - 1; i++) {
                if (Integer.parseInt(splitLine[i]) > Integer.parseInt(splitLine[i + 1])) {
                    int eat = Integer.parseInt(splitLine[i]) - Integer.parseInt(splitLine[i + 1]);
                    case1 += eat;
                    maxEat = maxEat < eat ? eat : maxEat;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                if (Integer.parseInt(splitLine[i]) < maxEat) {
                    case2 += Integer.parseInt(splitLine[i]);
                }else{
                    case2 += maxEat;
                }
            }
            writer.write("Case #"+(test+1)+": "+case1+" "+case2+"\n");
            System.out.println("Case #" + (test + 1) + ": " + case1 + " " + case2+"\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
