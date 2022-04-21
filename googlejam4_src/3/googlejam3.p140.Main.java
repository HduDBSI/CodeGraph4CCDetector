package googlejam3.p140;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author John
 */
public class Main 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        int testCases = Integer.parseInt(in.readLine());
        String[] tokens;
        
        for(int testNumber = 1; testNumber <= testCases; testNumber++)
        {
            out.append("Case #").append(testNumber).append(": ");
            
            tokens = in.readLine().trim().split("\\s+");
            
            int r = Integer.parseInt(tokens[0]);
            int c = Integer.parseInt(tokens[1]);
            int w = Integer.parseInt(tokens[2]);
            
            int numberNeededPerRowToGetHit = c / w;
            int additionalNumberToSinkOnceHit;
            
            if (w > 1)
            {
                if (c > w && c % w != 0)
                {
                    additionalNumberToSinkOnceHit = w;
                }
                else
                {
                    additionalNumberToSinkOnceHit = w - 1;
                }
            }
            else
            {
                additionalNumberToSinkOnceHit = 0;
            }
            
            int total = numberNeededPerRowToGetHit * r + additionalNumberToSinkOnceHit;
            
            out.append(total).append("\n");
        }
        
        System.out.println(out);
    }

}
