package googlejam1.p224;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class A
{
   public static void main(String[] args) throws FileNotFoundException
   {
      File f = new File("input1.txt");
      Scanner s = new Scanner(f);

      int numTests = s.nextInt();

      for(int i = 0; i < numTests; i++)
      {
         int steps = s.nextInt();
         int[] hist = new int[steps];
         int firstMethod = 0;
         int maxEaten = 0;
         int secondMethod = 0;

         for(int j = 0; j < steps; j++)
         {
            hist[j] = s.nextInt();
            if(j > 0)
            {
            if(hist[j] < hist[j-1])
            {
               firstMethod += hist[j - 1] - hist[j];
               if(hist[j - 1] - hist[j] > maxEaten)
               {
                  maxEaten = hist[j-1] - hist[j];
               }
            }
         }
         }

         for(int j = 0; j < steps - 1; j++)
         {
            if(hist[j] < maxEaten)
            {
               secondMethod += hist[j];
            }
            else
            {
               secondMethod += maxEaten;
            }
         }

         System.out.println("Case #" + (i+1) + ": " + firstMethod + " " + secondMethod);
      }


   }
}