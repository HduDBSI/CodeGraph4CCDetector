package googlejam3.p544;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mesuterhanunal/Desktop/in.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/mesuterhanunal/Desktop/out.txt"));

            int testCase = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCase; i++) {
                String [] line = br.readLine().split("\\s+");
                int R = Integer.parseInt(line[0]), C = Integer.parseInt(line[1]), W = Integer.parseInt(line[2]);

                double Ratio = C / (1.00 * W);
                int toAdd = (int) Math.ceil(Ratio), Try = 0;

                Try = W + toAdd - 1;
                Try *= R;

                bw.write("Case #" + (i+1) + ": " + Try + "\n");
            }

            br.close();
            bw.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
