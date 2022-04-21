package googlejam6.p027;


import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class B
{
   static int N;
   static int [][]grid;
   static int [][] inputs;
   public static void main(String[] args) throws Exception
   {
      System.setOut(new PrintStream(new File("a.out")));
      Scanner scan = new Scanner(new File("a.in"));
      int numCases = scan.nextInt();
      for (int z = 1; z <= numCases; z++)
      {
         int [] count = new int[2501];
         N = scan.nextInt();
         grid = new int[N][N];
         inputs = new int[2*N-1][N];
         for (int i = 0 ; i < 2*N-1; i++)
         {
            for (int j = 0; j < N; j++) 
            {
               inputs[i][j] = scan.nextInt();
               count[inputs[i][j]]++;
            }
         }

         System.out.print("Case #" + z + ":");
         for (int i = 0; i < count.length; i++) 
         {
            if (count[i] % 2 != 0)
            {
               System.out.print(" " + i);
            }
         }
         System.out.println();
         
      }
      scan.close();
   }
}
