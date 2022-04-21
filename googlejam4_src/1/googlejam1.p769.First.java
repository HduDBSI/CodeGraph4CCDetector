package googlejam1.p769;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class First {


    private static final String WORK_DIR = "C:\\users\\eamudha\\codejam\\qualification\\first\\";

    public static void main(String[] args) throws Exception {
        First first = new First();
        Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
            int n = sc.nextInt();
			int[] input = new int[n];
			long min = 0;
			long constant = 0;
			int constantSpeed = Integer.MIN_VALUE;
			input[0] = sc.nextInt();
			for (int i = 1; i < n; i++) {
			    input[i] = sc.nextInt();
			    if (input[i] < input[i-1]) {
			        int diff = input[i-1] - input[i];
			        min += diff;
			        if (diff > constantSpeed) {
			            constantSpeed = diff;
			        }
			    }
			}
			int validConstantSpeed = input[n-2] - input[n-1];
			if (constantSpeed == Integer.MIN_VALUE) {
			    constantSpeed = input[n-2] - input[n-1];
			} else {
			    if (validConstantSpeed > 0 && validConstantSpeed > constantSpeed) {
			        constantSpeed = validConstantSpeed;
			    }
			}
			if (constantSpeed > 0) {
			    for (int i = 0; i < n-1; i++) {
			        if (input[i] > constantSpeed) {
			            constant += constantSpeed;
			        } else {
			            constant += input[i];
			        }
			    }
			}
			pw.printf("%d %d\n", min, constant);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
