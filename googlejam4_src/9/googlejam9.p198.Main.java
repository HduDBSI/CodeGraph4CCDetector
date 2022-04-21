package googlejam9.p198;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // set up scanner and iterate over test cases
        Scanner scanner = new Scanner(new FileInputStream(
            "C:\\Users\\Stefan\\Downloads\\B-small-attempt1.in"));
        PrintStream output = new PrintStream(
            "C:\\Users\\Stefan\\Downloads\\B-small-attempt1.out");
        int T = scanner.nextInt();
        for (int t = 1; t <= T; ++t) {
            // get parameters
            int B = scanner.nextInt();
            int M = scanner.nextInt();
            // solve problem
            output.print("Case #" + t + ":");
            // there are no cycles in graph
            // determine if it is possible, only depends on maximum
            long maxWays = 0x01 << (B - 2);
            if (M > maxWays) {
                output.println(" IMPOSSIBLE");
                continue;
            }
           	output.println(" POSSIBLE");
           	// print solution matrix
           	// first node: construct M by using counts of 2 ^ X
           	if (B == 2)
           		output.println("01");
           	else {
           		long maxNodeWays = 0x01 << (B - 3);
           		output.print("0");
                for (int slide = 1; slide < B - 1; ++slide) {
                	if (M >= maxNodeWays) {
                   		output.print("1");
                   		M -= maxNodeWays;
                	}
                	else
                		output.print("0");
               		maxNodeWays /= 2;
                }
           		if (M > 0)
           			output.println("1");
           		else
           			output.println("0");
           	}
           	// output slides from building b towards any other building
        	// make slides between all nodes except 1 and B
            for (int b = 1; b < B - 1; ++b) {
	            for (int slide = 0; slide < B; ++slide)
	            	if (slide <= b)
	            		output.print("0");
	            	else
	            		output.print("1");
	           	output.println();
            }
            // no slides from last node
            for (int slide = 0; slide < B; ++slide)
        		output.print("0");
           	output.println();
        }
        output.close();
        System.out.println("finished");
    }
}
