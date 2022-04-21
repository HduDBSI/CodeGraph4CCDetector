package googlejam3.p231;
import java.util.*;
import java.io.*;
import java.text.*;

public class Brattleship
{
    public static void main (String[] args) throws IOException
    {
        //DecimalFormat df = new DecimalFormat("0.0######");
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("A-large.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
        int t = scan.nextInt();
        
        for (int i=1; i<=t; i++)
        {
            int rows = scan.nextInt();
            int cols = scan.nextInt();
            int wid = scan.nextInt();
            int cnt=0;
            boolean[][] grid = new boolean[rows][cols];
            for (int r=0; r<rows; r++)
            {
                int loc = wid-1;
                while (loc<cols)
                {
                    grid[r][loc] = true;
                    cnt++;
                    loc += wid;
                }
                if (r==0)
                {
                    if (cnt==1)
                    {
                        cnt += Math.min(wid, cols-1);
                    }
                    else
                    {
                        cnt += wid;
                        if (cols%wid==0)
                            cnt--;
                    }
                }
            }
           
            out.println("Case #" + i + ": " + cnt);
        }
        out.close();
        System.exit(0);
    }
}
