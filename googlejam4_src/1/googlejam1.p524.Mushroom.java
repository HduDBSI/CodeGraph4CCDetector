package googlejam1.p524;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class Mushroom {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter("mushroom.out");
        
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int curCase = 1; curCase <= numCases; curCase++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            
            String[] intervalStr = scanner.nextLine().split(" ");
            int[] intervals = new int[numIntervals];
            for (int i = 0; i < numIntervals; i++) {
                intervals[i] = Integer.parseInt(intervalStr[i]);
            }
            
            int minEatFree = 0;
            int minEatConstant = 0;
            
            int maxDrop = 0;
            
            for (int i = 1; i < numIntervals; i++) {
                int difference = intervals[i-1] - intervals[i];
                minEatFree += Math.max(0, difference);
                
                maxDrop = Math.max(maxDrop, difference);
            }
            
            for (int i = 0; i < numIntervals-1; i++) {
                if (intervals[i] < maxDrop) {
                    minEatConstant += intervals[i];
                }
                else {
                    minEatConstant += maxDrop;
                }
            }
            
            out.println("Case #" + curCase + ": " + minEatFree + " " + minEatConstant);
        }
        scanner.close();
        out.close();
    }
}
