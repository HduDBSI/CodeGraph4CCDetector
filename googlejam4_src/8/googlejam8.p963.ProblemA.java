package googlejam8.p963;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Igor Cha on 5/8/2016.
 */
public class ProblemA {
    public static void main(String[] args) throws FileNotFoundException
    {
        FileReader file = new FileReader("A-small-attempt0.in");
        Scanner in = new Scanner(file);
        PrintWriter out = new PrintWriter("output.txt");

        int t = in.nextInt();
        char[] letters = "ABCDEFGHIJKLMNOPQESTUVWXYZ".toCharArray();
        for(int i = 1; i<=t; i++)
        {
            int n = in.nextInt();
            int[] ar = new int[n];
            int[] c = new int[n];
            for(int j = 0; j<n; j++)
            {
                ar[j] = in.nextInt();
                c[j] = ar[j];
            }
            String output ="";
            Arrays.sort(ar);
            while(ar[n-1] > 0)
            {
                if(n==2 || ar[n-3]==0)
                {
                    for(int k = 0; k<c.length; k++)
                    {
                        if(c[k] == ar[n-1])
                        {
                            output += letters[k];
                            c[k]--;
                        }
                    }
                    ar[n-1]--;
                    ar[n-2]--;
                    output+=" ";
                }
                else
                {
                    for(int k = 0; k<c.length; k++)
                    {
                        if(c[k] == ar[n-1])
                        {
                            output += letters[k]+" ";
                            c[k]--;
                            break;
                        }
                    }
                    ar[n-1]--;

                }
                Arrays.sort(ar);
            }
            out.println("Case #" + i + ": " + output);

        }
        in.close();
        out.close();
    }
}
