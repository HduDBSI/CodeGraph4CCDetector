package googlejam3.p468;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {


    private static final String WORK_DIR = "C:\\users\\eamudha\\codejam\\2015\\1C\\";

    public static void main(String[] args) throws Exception {
        A a = new A();
        Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-small.in"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "A-small.out"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
            int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			if (w == 1) {
			    pw.println(c);
			} else if (w == c) {
			    pw.println(w);
			} else {
			    pw.println(((c-1)/w) + w);
			}
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
