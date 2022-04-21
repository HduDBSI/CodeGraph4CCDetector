package googlejam3.p016;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class codejam2015_1C_A {
    static PrintWriter out = null;
    static FileInputStream in = null;
    Scanner sc;

    int N;
    Integer R, C, W;

    public static void main(String[] args) {
        try {
            System.setIn(new BufferedInputStream(new FileInputStream(args.length > 0 ? args[0] : (codejam2015_1C_A.class.getName() + ".in"))));
        } catch (Exception e) {
        }
		codejam2015_1C_A r = new codejam2015_1C_A();
        try {
		    codejam2015_1C_A.in = new FileInputStream("src/com/resources/smallInput.txt");
		    codejam2015_1C_A.out = new PrintWriter("src/com/resources/output.txt");
		} catch (FileNotFoundException e) {
		    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		r.sc = new Scanner(codejam2015_1C_A.in);
		int caseN = r.sc.nextInt();
		for (int caseID = 1; caseID <= caseN; caseID++) {
		    r.R = r.sc.nextInt();
			r.C = r.sc.nextInt();
			r.W = r.sc.nextInt();
		    codejam2015_1C_A.out.printf("Case #%d: ", caseID);
		    System.out.printf("Case #%d: ", caseID);
		    long solution=0;
			solution += (r.R-1)*(r.C/r.W);
			
			solution += (r.C-1)/r.W;
			solution += r.W;
			
			codejam2015_1C_A.out.println(solution);
			System.out.println(solution);
		    System.out.flush();
		}
		codejam2015_1C_A.out.close();
    }
}
