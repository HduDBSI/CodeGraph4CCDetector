package googlejam1.p256;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    private static final String PATTERN = "CASE #%d: %s";
    private static final String PROBLEM = "A";

    //private static final String NAME = PROBLEM + ".in";
    //private static final String NAME = PROBLEM+"-small-attempt1.in";
    private static final String NAME = PROBLEM+"-large.in";
    //private static final String OUT = PROBLEM + ".out";
    //private static final String OUT = PROBLEM+"-small-attempt1.out";
    private static final String OUT = PROBLEM+"-large.out";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(NAME));
        PrintWriter pw = new PrintWriter(OUT);
        int testCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCount; i++) {
            sc.nextLine();
			String[] temp = sc.nextLine().split(" ");
			List<Integer> x = new ArrayList<>();
			for (String s : temp) {
			    x.add(Integer.parseInt(s));
			}
			long total0 = 0;
			long total1 = 0;
			int maxMin = 0;
			int prev = x.get(0);
			for (int i1 = 1; i1 < x.size(); i1++) {
			    Integer current = x.get(i1);
			    if (current < prev) {
			        total0 += prev - current;
			        maxMin = Math.max(maxMin, prev - current);
			    }
			    prev = current;
			}
			
			for (int i2 = 0; i2 < x.size() - 1; i2++) {
			    total1 += Math.min(maxMin, x.get(i2));
			}
			String sol = "" + total0 + " " + total1;
            System.out.println(String.format(PATTERN, i + 1, sol));
            pw.println(String.format(PATTERN, i + 1, sol));
        }
        pw.flush();
        pw.close();
    }
}
