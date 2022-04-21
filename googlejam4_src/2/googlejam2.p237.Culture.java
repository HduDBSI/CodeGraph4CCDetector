package googlejam2.p237;
import java.util.Scanner;

public class  Culture{
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      int[] memo = new int[1000001];
      
      for(int i = 1; i < memo.length; i++) {
         memo[i] = i;
      }
      
      for(int i = 1; i < memo.length; i++) {
         //System.out.println(i);
         String inputS = "" + i;
		  String outputS = "";
		  for(int i1 = inputS.length() - 1; i1 >= 0; i1--) {
		     outputS += inputS.charAt(i1);
		  }
		int invert = Integer.parseInt(outputS);
         int offset = 1;
         while(true) {
            
            if(invert >= 1 && invert < memo.length) {
               if(memo[invert] > memo[i] + offset) {
                  memo[invert] = memo[i] + offset;
               } else {
                  break;
               }
            } else {
               break;
            }
            invert++;
            offset++;
         }
      }
      
      //System.out.println("READY");
      
      int numCases = scan.nextInt();
      
      for(int caseNum = 1; caseNum <= numCases; caseNum++) {
         int countNum = scan.nextInt();
         
         System.out.print("Case #" + caseNum + ": ");
         int startNum = 0;
         
         
         
         System.out.println(memo[countNum]);
      }
      
   }
}