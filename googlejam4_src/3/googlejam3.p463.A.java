package googlejam3.p463;
import java.util.*;
import java.util.Set;
import java.io.*;

public class A
{
    public static void main(String[] args) throws Exception
    {
    	File file = new File("A-small-attempt0.in");
        Scanner input = new Scanner(file);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++)
        {
            int r = input.nextInt();
            int c = input.nextInt();
            int w = input.nextInt();
            int[][] b = new int[r][c];
            int score = 0;
            for(int j=0; j<r; j++)
	        {
	        	int i = 0;
	            while(i < c)
	            {
	            	i += w;
	            	score++;
	            }
	        }
	        score += (w-1);
	        System.out.println("Case #"+(n+1)+": "+score);
        }
    }
}