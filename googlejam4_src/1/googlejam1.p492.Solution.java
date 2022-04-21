package googlejam1.p492;
import java.util.*;
import java.io.*;

public class Solution
{
	static String filename = "A-large";
	static Scanner input;

    public static void main(String ... orange) throws Exception
    {
		File file = new File(filename + ".in");
        input = new Scanner(file);
	    PrintWriter writer = new PrintWriter(filename + ".out", "UTF-8");

        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++)
        {
        	// Solve each test case
        	int N = input.nextInt();
			int room[] = new int[N];
			for (int i = 0; i < N; i++) {
				room[i] = input.nextInt(); 
			}
			
			// Method 1
			int eat1 = 0;
			for (int i = 1; i < room.length; i++) {
				if (room[i] < room[i-1]) {
					eat1 += room[i-1] - room[i];
				}
			}
			
			// Method 2
			int eat2 = 0;
			int fastestEatRate = 0;
			for (int i = 1; i < room.length; i++) {
				if (room[i-1] - room[i] > fastestEatRate) {
					fastestEatRate = room[i-1] - room[i];
				}
			}
			
			for (int i = 0; i < room.length-1; i++) {
				if (room[i] < fastestEatRate) {
					eat2 += room[i];
				} else {
					eat2 += fastestEatRate;
				}
			}
			String solution = "" + eat1 + " " + eat2;
            
            writer.printf("Case #%d: %s\n", n + 1, solution);
            System.out.printf("Case #%d: %s\n", n + 1, solution);
        }
        
        writer.close();
        input.close();
    }
}
