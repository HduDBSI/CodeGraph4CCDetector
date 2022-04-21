package googlejam3.p458;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by noMoon on 2015-05-10.
 */
public class Brattleship {
    public static void main(String[] args) throws IOException {
//        System.out.prLongln(reverse(19));

//        File file = new File("A-large.in.txt");
//        File file = new File("Brattleship.in");
        File file = new File("A-small-attempt0.in.txt");
        File outputFile = new File("Brattleship.out");
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        Long numberOfTestCases = Long.valueOf(br.readLine());
        Long count = (long)0;
        while (count++ < numberOfTestCases) {

            String line=br.readLine();
            String[] params=line.split(" ");
            int R=Integer.valueOf(params[0]);
            int C=Integer.valueOf(params[1]);
            int W=Integer.valueOf(params[2]);
            int singleRow=C/W+W-1;
            if(C%W>0){
                singleRow++;
            }
            bw.write("Case #" + String.valueOf(count) + ": " + String.valueOf(R*singleRow));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
