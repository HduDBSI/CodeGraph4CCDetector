package googlejam1.p259;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by noMoon on 2015-04-17.
 */
public class Mushroom {

    public static void main(String[] args) throws IOException {
        File file = new File("A-large.in.txt");
//        File file = new File("Mushroom.in");
        File outputFile = new File("Mushroom.out");
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        int numberOfTestCases = Integer.valueOf(br.readLine());
        int count = 0;
        while (count++ < numberOfTestCases) {
            int n=Integer.valueOf(br.readLine());
            String[] params=br.readLine().split(" ");
            long a=0;
            long rate=0;
            int[] mushrooms=new int[n];
            for (int i=0;i<n;i++){
                mushrooms[i]=Integer.valueOf(params[i]);
                if(i>0) {
                    int minus = mushrooms[i - 1] - mushrooms[i];
                    if (minus > 0) {
                        a += minus;
                    }
                    if (rate < minus) {
                        rate = minus;
                    }
                }
            }
            long b=0;
            for (int i=0;i<n-1;i++){
                if(mushrooms[i]>0){
                    if(mushrooms[i]>rate){
                        b+=rate;
                    }else{
                        b+=mushrooms[i];
                    }
                }
            }


            bw.write("Case #" + String.valueOf(count) + ": " + String.valueOf(a) + " " + String.valueOf(b));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
