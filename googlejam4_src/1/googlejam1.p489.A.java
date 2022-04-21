package googlejam1.p489;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-4-17.
 */
public class A {
    final static String PROBLEM_NAME = "A-small-attempt0";
    final static String WORK_DIR = "/Users/cecilia/Downloads/" + PROBLEM_NAME;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader(WORK_DIR + ".in"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + ".out"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			A r = new A();
            int N = sc.nextInt();
			int[] a = new int[N];
			for(int i = 0; i < N; i++){
			    a[i] = sc.nextInt();
			}
			long ret1 = 0;
			long ret2 = 0;
			int max = 0;
			for(int i = 1; i < N; i++){
			    if(a[i] < a[i-1]){
			        int dif = a[i-1] - a[i];
			        max = Math.max(max, dif);
			        ret1 += dif;
			    }
			}
			
			for(int i = 0; i < N-1; i++){
			    ret2 += Math.min(a[i], max);
			}
			pw.println(ret1 + " " + ret2);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
