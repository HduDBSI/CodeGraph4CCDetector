package googlejam6.p430;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Victor on 4/15/2016.
 */
public class rankandfile {

    public static void main(String [] args) {
        String filePath = "C:\\Users\\Victor\\IdeaProjects\\googleJam\\files\\B-large (1).in";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Victor\\IdeaProjects\\googleJam\\files\\rankandfileresults.txt"));
            int count = 1;
            Integer t = Integer.parseInt(br.readLine());

            for (int tt =0; tt<t; tt++){
                int[] heightArray = new int[2500];
                Integer n = Integer.parseInt(br.readLine());
                ArrayList<Integer> missing = new ArrayList<Integer>();

                StringBuilder sb = new StringBuilder();
                for (int nn = 0; nn < 2*n-1; nn++) {
                    String list = br.readLine();
                    for (int nnn = 0; nnn < n; nnn++) {
                        Integer height = Integer.parseInt(list.split("\\s+")[nnn]);
                        heightArray[height-1] = heightArray[height-1] + 1;
                    }
                }
                for (int i=0; i< heightArray.length; i++) {
                    if (heightArray[i]%2 != 0 ){
                        missing.add(i+1);
                    }
                }

                Collections.sort(missing);
                for (Integer height : missing){
                    sb.append(height);
                    sb.append(" ");
                }
                bw.write("Case #" + count + ": " + sb.toString());
                count++;
                bw.newLine();


            }
            br.close();
            bw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
