package googlejam7.p055;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProblemBLarge {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("B-large.in")));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        PrintWriter pw = new PrintWriter("B-large.out");

        for (int test = 0; test < T; test++) {
            line = br.readLine();
            char[] chars = line.toCharArray();
            int count = 0;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i-1]) {
                    count++;
                }
            }
            if (chars[chars.length - 1] == '-') {
                count++;
            }
            pw.println("Case #" + (test + 1) + ": " + count);
        }
        pw.close();
        br.close();
    }
}
