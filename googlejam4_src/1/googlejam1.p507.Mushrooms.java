package googlejam1.p507;


import java.io.File;
import java.util.Scanner;

public class Mushrooms {

//   String inputFile = "./input/sample.txt";
   String inputFile = "./input/A-large (1).in";
   
   

   
   public static void main(String[] args) {
      Mushrooms mt = new Mushrooms();

      try {
         Scanner s = new Scanner(new File(mt.inputFile));
		
		  int t = s.nextInt();
		
		  for(int tc = 1; tc <= t; tc++) {
			System.out.print("Case #" + tc + ": ");
			
			  int N = s.nextInt();
			  int[] m = new int[N];
			
			  for(int i = 0; i < N; i++) {
			     m[i] = s.nextInt();
			  }
			
			  int bd = 0;
			
			  for(int i = 0; i < N-1; i++) {
			     if ((m[i] - m[i+1]) > bd) {
			        bd = m[i] - m[i+1]; 
			     }
			  }
			
			  int m1 = 0;
			  int m2 = 0;
			
			  for(int i = 0; i < N-1; i++) {
			     if ((m[i] - m[i+1]) > 0) {
			        m1 += m[i] - m[i+1];
			     }
			        
			     if (m[i] >= bd) {
			        m2 += bd;
			     }
			     else {
			        m2 += m[i];
			     }
			  }
			
			  System.out.println(m1 + " " + m2);
		}         
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
