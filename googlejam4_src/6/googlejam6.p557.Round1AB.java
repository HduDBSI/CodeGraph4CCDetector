package googlejam6.p557;
import java.util.*;
import java.io.*;

public class Round1AB {
  
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int amount = scan.nextInt();
    scan.nextLine();
    
    for (int i = 0; i < amount; i++) {
      
      int cases = scan.nextInt();
      scan.nextLine();
      
      int[] arr = new int[2501];
      
      for (int x = 0; x < 2*cases-1; x++) {
        
        String[] curr = scan.nextLine().split(" ");
        
        // find the smallest for ROW
        for (String r : curr) {
          arr[Integer.parseInt(r)]++;
        }
        
      }
      
      String f = "";
      for (int num = 1; num < arr.length; num++) {
        if (arr[num] == 1 || (arr[num] > 2 && arr[num]%2 != 0)) {
          f += " " + num;
        
        }
        
      }
      System.out.println("Case #" + (i+1) + ":" + f);

      
    }
    
  }
}