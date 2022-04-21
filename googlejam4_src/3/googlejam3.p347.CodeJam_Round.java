package googlejam3.p347;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Philip Lanaras
 */
public class CodeJam_Round {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int cases;
        
        final String filename = "aA-large.in";
        final String outFile = "aA-large.out";

        String[] vals;
        //----------------------------Inits-Go-Here----------------------------\\
        
        StringBuilder str = new StringBuilder();
        String temp;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            
            //Num of Cases
            temp = reader.readLine();
            cases = Integer.valueOf(temp);
            
            for (int i = 1; i <= cases; ++i) {
                temp = reader.readLine();
                vals = temp.split(" ");
                
                //------------------------Inits-Go-Here------------------------\\
                int R = Integer.parseInt(vals[0]);
                int C = Integer.parseInt(vals[1]);
                int W = Integer.parseInt(vals[2]);
                int sum = 0;

                sum += (C / W) * (R - 1);
                sum += (C - W) / W;
                sum += W;

                if (C % W != 0) {
                    sum++;
                }




                str.append("Case #").append(i).append(": ").append(sum);

                System.out.println(str.toString());

                writer.write(str.toString());
                writer.newLine();

                str = new StringBuilder();
            }
        }

    }
    
    
}
