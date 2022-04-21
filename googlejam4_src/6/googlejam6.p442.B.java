package googlejam6.p442;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B
{
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("./input_large.txt"));
        PrintWriter writer = new PrintWriter("./output_large.txt");
        int nTests = scanner.nextInt();
        scanner.nextLine(); //skip line (i.e., next line)
        
        int bigN;
        int numSheets;
        
        int[] possibleHeights; 
        
        for (int i = 0; i < nTests; i++) {
            bigN = scanner.nextInt();
            numSheets = 2*bigN - 1;
            
            possibleHeights = new int[2501];
            
            writer.print("Case #" + (i+1) + ":");
            
            for(int j = 0; j < numSheets; j++)
            {
                scanner.nextLine(); //skip line (i.e., next line)
                for(int k = 0; k < bigN; k++)
                {
                    possibleHeights[scanner.nextInt()]++;
                }
            }
            
            for(int height = 0; height < possibleHeights.length; height++)
            {
                if(possibleHeights[height]%2 == 1) writer.print(" " + height);
            }
             
            writer.println(); //next line of output...
        }
        scanner.close();
        writer.close();
        long finish = System.currentTimeMillis();
        System.out.println("Time=" + (finish - start) + "ms");
    }
}
