package googlejam1.p024;


import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class A {
    private static final String PROBLEM = "round1a/A-large";
    private final Scanner in;
    public A(Scanner in) {
        this.in = in;
    }

    private List<Integer> nextIntList(int n) {
        ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        for (int i = 0; i < n; i++) {
            builder.add(in.nextInt());
        }
        return builder.build();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(PROBLEM + ".in"));
		A r = new A(in);
        int numCases = r.in.nextInt();
		PrintWriter writer = new PrintWriter(A.PROBLEM + ".out");
		for (int casenum = 1; casenum <= numCases; casenum++) {
		    int n = r.in.nextInt();
			List<Integer> vals = r.nextIntList(n);
			
			int maxDiff = 0;
			long result1 = 0;
			for (int i = 1; i < vals.size(); i++) {
			    int diff = vals.get(i - 1) - vals.get(i);
			    maxDiff = Math.max(maxDiff, diff);
			    if (diff > 0) {
			        result1 += diff;
			    }
			}
			
			long result2 = 0;
			for (int i = 0; i < vals.size() - 1; i++) {
			    result2 += Math.min(maxDiff, vals.get(i));
			}
			String result = String.format("%d %d", result1, result2);
		    System.out.printf("Case #%d: %s%n", casenum, result);
		    writer.printf("Case #%d: %s%n", casenum, result);
		    writer.flush();
		}
    }
}
