package googlejam1.p805;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int tests = Integer.parseInt(in.readLine());
        int n;
        int[] mushrooms;
        int[] differences;
        long totalDifferences;
        String[] tok;
        int maxDifference;
        long linearCount;
        
        for(int testno = 1; testno <= tests; testno++)
        {
            out.append("Case #").append(testno).append(": ");
            
            n = Integer.parseInt(in.readLine());
            tok = in.readLine().trim().split("\\s+");
            
            mushrooms = new int[n];
            differences = new int[n];
            totalDifferences = 0;
            maxDifference = 0;
            linearCount = 0;
            
            mushrooms[0] = Integer.parseInt(tok[0]);
            
            for(int i = 1; i < n; i++)
            {
                mushrooms[i] = Integer.parseInt(tok[i]);
                differences[i] = mushrooms[i - 1] - mushrooms[i];
                maxDifference = Math.max(maxDifference, differences[i]);
                totalDifferences += differences[i] > 0 ? differences[i] : 0;
            }
            
            for(int i = 0; i < n - 1; i++)
            {
                if(mushrooms[i] >= maxDifference)
                {
                    linearCount += maxDifference;
                }
                else
                {
                    linearCount += mushrooms[i];
                }
            }
            
            out.append(totalDifferences).append(" ").append(linearCount).append("\n");
        }
        
        System.out.println(out);
    }
}
