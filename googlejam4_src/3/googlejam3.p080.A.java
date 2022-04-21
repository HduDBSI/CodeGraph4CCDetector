package googlejam3.p080;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A {

    private static final String FILE_NAME = "A-large";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FILE_NAME + ".in"));
        BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME + ".out"));

        int t = Integer.parseInt(in.readLine());
        for (int c = 1; c <= t; ++c) {
            String[] split = in.readLine().split(" ");
            int rows = Integer.parseInt(split[0]);
            int columns = Integer.parseInt(split[1]);
            int width = Integer.parseInt(split[2]);

            int turns = rows*(columns/width);
            if (columns%width > 0) {
                ++turns;
            }
            turns += width-1;

            String ans = String.format("Case #%d: %d\n", c, turns);
            out.write(ans);
            System.out.print(ans);
        }
        out.close();
    }
}
