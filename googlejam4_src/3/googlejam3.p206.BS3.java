package googlejam3.p206;
import java.util.Scanner;

public class BS3 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int numCases = scan.nextInt();
      
      for(int caseNum = 1; caseNum <= numCases; caseNum++) {
         int numRows = scan.nextInt();
         int numCols = scan.nextInt();
         int shipWidth = scan.nextInt();
         
         System.out.print("Case #" + caseNum + ": ");
         
         int findInRowMin = numCols/shipWidth;
         int finishShip = shipWidth - (numCols % shipWidth == 0 ? 1 : 0);
         System.out.println(numRows * findInRowMin + finishShip);
         
      }
      
   }
}