package googlejam6.p489;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    private static final String FILENAME = "B-large";

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new FileReader(FILENAME + ".in"));
        PrintWriter output = new PrintWriter(new FileWriter(FILENAME + ".out"));

        long start = System.currentTimeMillis();
        int testCase = input.nextInt();
        for (int t=1; t<=testCase; t++) {
        	int N = input.nextInt();
        	boolean[] check = new boolean[2501];
        	Arrays.fill(check, false);
        	for (int i=0; i<(2*N-1); i++) {
        		for (int j=0; j<N; j++) {
        			int n = input.nextInt();
        			check[n] = !check[n];
        		}
        	}
        	output.print("Case #"+t+":");
        	for (int i=1; i<=2500; i++) {
        		if (check[i]) output.print(" " + i); 
        	}
        	output.print("\n");
        }
        System.out.printf("Total duration: %dms\n", System.currentTimeMillis() - start);

        input.close();
        output.close();
	}
}
