package googlejam6.p399;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main
{
   public static void main(String[] args) throws Exception
   {
      Scanner inp = new Scanner(new File("inLarge.txt"));
      PrintWriter pw = new PrintWriter(new File("outLarge.txt"));
      int c = 0;
      int cases = inp.nextInt();
      while( c < cases )
      {
         int n = inp.nextInt();
         int[] h = new int[2501];
         int[] m = new int[n];
         for( int i=0; i<2*n*n-n; i++ )
         {
            h[inp.nextInt()]++;
         }
         int p = 0;
         for( int i=0; i<2500; i++ )
         {
            if( h[i] % 2 != 0 )
            {
               m[p] = i;
               p++;
            }
         }
         String r = "";
         for( int i=0; i<n; i++ ) 
         {
            r += " " + m[i];
         }
         System.out.println("Case #" + (c+1) + ":" + r );
         pw.println("Case #" + (c+1) + ":" + r );
         
         c++;
      }
      pw.close();
   }
}