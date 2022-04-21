package googlejam1.p003;
import java.util.*;
import java.io.*;
import java.math.*;

public class Mushroom {
    final static String PROBLEM_NAME = "mushroom";
    final static String WORK_DIR = "D:\\GCJ\\" + PROBLEM_NAME + "\\";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			Mushroom r = new Mushroom();
            int N = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
			    A[i] = sc.nextInt();
			}
			
			int ans1 = 0;
			int speed = 0;
			for (int i = 0; i + 1 < N; i++) {
			    if (A[i + 1] < A[i]) {
			        ans1 += A[i] - A[i + 1];
			        speed = Math.max(speed, A[i] - A[i + 1]);
			    }
			}
			
			int ans2 = 0;
			for (int i = 0; i + 1 < N; i++) {
			    ans2 += Math.min(A[i], speed);
			}
			
			pw.println(ans1 + " " + ans2);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
