package googlejam3.p170;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            //these variables handle input and output from plain text files
            in = new Scanner(new FileReader("input.in"));
            out = new PrintWriter("output.txt");

            int cases = in.nextInt();
            for (int caseIndex = 1; caseIndex <= cases ; caseIndex++) {

                int r = in.nextInt();
                int c = in.nextInt();
                int w= in.nextInt();
                int result = (c / w) * r + (w-1);
                if(c%w!=0){
                    result++;
                }
                out.printf("Case #%d: %d\n",caseIndex,result);
                out.flush();


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }
}
