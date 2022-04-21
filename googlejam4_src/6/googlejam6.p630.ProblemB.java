package googlejam6.p630;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Igor Cha on 4/15/2016.
 */
public class ProblemB {
    public static void main (String[] args) throws FileNotFoundException {

        FileReader file = new FileReader("B-large.in");
        Scanner in = new Scanner(file);
        PrintWriter out = new PrintWriter("output.txt");

        int t = in.nextInt();

        for(int b = 1; b<=t; b++) {
            int n = in.nextInt();
            int[] a = new int[2501];
            int[] result = new int[n];
            int k = 0;
            for (int i = 0; i < ((2 * n - 1) * n); i++) {
                a[in.nextInt()] += 1;

            }

            for(int j = 0; j<a.length; j++)
            {
                if(!((a[j] % 2)== 0))
                {
                    result[k] = j;
                    k++;
                }

            }
            String output ="";
            for(int s = 0; s<result.length; s++)
            {
                output += " " + result[s];
            }
            out.println("Case #" + b +":" + output);
        }

        in.close();
        out.close();
    }
}
