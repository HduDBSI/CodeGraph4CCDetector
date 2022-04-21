package googlejam3.p227;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by cheto on 5/10/2015.
 */
public class Brattleship {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].length() - 2) + "out"));
        int testCases = Integer.parseInt(reader.readLine());
        System.out.println("Test cases: " + testCases);
        for (int test = 0; test < testCases; test++) {
            String[] splitLine = reader.readLine().split(" ");
            int R = Integer.parseInt(splitLine[0]);
            int C = Integer.parseInt(splitLine[1]);
            double W = Double.parseDouble(splitLine[2]);
            int cells = R*C;
            int fuller = (int) Math.floor(C / W);
            int completeFuller = fuller * R;
            int res = (int)(completeFuller + (W - 1) + (C % W == 0 ? 0 : 1) );
            writer.write("Case #" + (test + 1) + ": " + res + "\n");
            System.out.println("Case #" + (test + 1) + ": " + res + "\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
