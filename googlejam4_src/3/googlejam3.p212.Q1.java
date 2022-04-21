package googlejam3.p212;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1]))));
        int iterationsNum = Integer.parseInt(br.readLine());


        for (int i = 0; i < iterationsNum; ++i) {
            String[] parameters = br.readLine().split("\\s+");
            long Rows = Long.parseLong(parameters[0]);
            long Columns = Long.parseLong(parameters[1]);
            long Width = Long.parseLong(parameters[2]);

            long res = Rows * new Double(Math.floor(Columns / Width * 1.0)).intValue() + Width - 1;

            if (Columns % Width > 0) {
                res += 1;
            }

            // if (Width == Columns || Columns == 1)
            // res -= 1;
            // int time = new Double(Math.ceil(Math.log(max) / Math.log(2)) + 1).intValue();
            bw.write("Case #" + (i + 1) + ": " + res + "\n");
        }

        br.close();
        bw.close();
    }

}
