package googlejam6.p204;


import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class ProblemB {


    public static void main(String[] args) throws Exception {
        ProblemB r = new ProblemB();
		String name = "B-large";
		        String path = "";
		
		        Locale.setDefault(Locale.US);
		
		        Scanner sc = new Scanner(new File(path + name + ".in"));
		        PrintWriter pw = new PrintWriter(path + name + ".out");
		//		Scanner sc = new Scanner(System.in);
		//		PrintWriter pw = new PrintWriter(System.out);
		
		        int testCases = sc.nextInt();
		        for (int testCase = 1; testCase <= testCases; testCase++) {
		            int N = sc.nextInt();
		            pw.print("Case #" + testCase + ": ");
		            int[] counts = new int[2501];
					Arrays.fill(counts, 0);
					
					for (int k=0; k<((2*N-1)*N); k++) {
					    int current = sc.nextInt();
					    counts[current]++;
					}
					
					for (int k=0; k< counts.length; k++) {
					    if (counts[k] %2 == 1) {
					        pw.print(k + " ");
					    }
					}
					pw.println();
		            pw.flush();
		        }
		
		        pw.close();
		        sc.close();
    }
}