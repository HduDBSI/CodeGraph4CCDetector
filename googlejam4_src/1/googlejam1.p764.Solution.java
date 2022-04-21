package googlejam1.p764;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chathura
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner input = new Scanner(new File("in.in"));
        ArrayList<String> answeres = new ArrayList<>();
        int T = 0, N = 0;

        int y = 0;
        int z = 0;
        int rate = 0;

        int temprate = 0;

        T = input.nextInt();

        for (int i = 0; i < T; i++) {

            N = input.nextInt();

            int[] data = new int[N];

            for (int j = 0; j < N; j++) {
                data[j] = input.nextInt();
            }

            y = 0;
            z = 0;
            rate = 0;
            temprate = 0;

            for (int j = 0; j < N - 1; j++) {
                if (data[j] > data[j + 1]) {
                    y += data[j] - data[j + 1];

                    temprate = (data[j] - data[j + 1]);

                    if (temprate > rate) {
                        rate = temprate;
                    }

                }

            }

            for (int j = 0; j < N - 1; j++) {
                if (data[j]-rate  <0) {
                    z += data[j];
                } else {
                    z += rate;
                }
            }

            answeres.add(y+" "+z);



        }

        String out = "";
        for (int i = 0; i < T; i++) {
            out += "Case #" + (i + 1) + ": ";
            out += answeres.get(i);
            out += "\r\n";
        }
        System.out.println(out);
        File outF = new File("out.out");
        FileWriter fw = new FileWriter(outF);
        fw.write(out);
        fw.flush();//*/

    }

}
