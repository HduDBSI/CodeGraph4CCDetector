package googlejam6.p221;


import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.PrintWriter;

public class ProblemB {

static final String FILENAME = "B-large";
static final String IN = FILENAME + ".in";
static final String OUT = FILENAME + ".out";
//static PrintStream out = System.out;
static Scanner sc;
static PrintWriter out;

public static void main(String args[]) throws Exception {
	sc = new Scanner(new File(IN));
	out = new PrintWriter(OUT);
	ProblemB r = new ProblemB();
	// out = new PrintStream(new FileOutputStream(OUT));
	int t = ProblemB.sc.nextInt();
	for (int i = 1; i <= t; i++) {
		ProblemB.out.print("Case #" + i + ": ");
		int ans = 0;
		int n = ProblemB.sc.nextInt();
		int marks[] = new int[2501];
		
		for (int i1 = 0; i1 < n*2 - 1; ++i1) {
			for (int j = 0; j < n; ++j) {
				int tmp = ProblemB.sc.nextInt();
				marks[tmp] ++;
			}
		}
		
		for (int i2 = 1; i2 <= 2500; i2++) {
			if (marks[i2]%2 != 0) {
				ProblemB.out.print(i2);
				ProblemB.out.print(" ");
			}
		}
		
		ProblemB.out.println();
	}
	ProblemB.sc.close();
	ProblemB.out.close();
}

}