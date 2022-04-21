package googlejam1.p800;
import java.util.*;
import java.io.*;

public class Mushroom
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("A-large.in"));
        PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter("A-large.out")));
        
        int t = scan.nextInt();
        
        for (int i=1; i<=t; i++)
        {
            int n = scan.nextInt();
            int ans1 = 0, rate = 0, ans2 = 0;
            int[] m = new int[n];
            
            for (int j=0; j<n; j++)
                m[j] = scan.nextInt();
                
            for (int j=1; j<n; j++)
            {
                if (m[j]<m[j-1])
                {
                    ans1 += (m[j-1]-m[j]);
                    rate = Math.max(rate, m[j-1]-m[j]);
                }
            }
            
            for (int j=0; j<n-1; j++)
                ans2 += Math.min(rate, m[j]);
                
            out.println("Case #" + i + ": " + ans1 + " " + ans2);
        }
        out.close();
        System.exit(0);
    }
}
