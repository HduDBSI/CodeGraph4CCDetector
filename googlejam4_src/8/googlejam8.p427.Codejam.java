package googlejam8.p427;
import java.util.*;
import java.io.*;

public class Codejam {
	final static String PROBLEM_NAME = "A-small";
	final static String WORK_DIR = "C:\\Users\\Ketan\\Documents\\NetBeansProjects\\codejam\\src\\";
	final static String INPUT_FILE_NAME = PROBLEM_NAME+".in";
	final static String OUTPUT_FILE_NAME = PROBLEM_NAME+".out";

	static int[][] maxBest = new int[31][2];

	char digittochar(int i) {
            char c;
            c = (char) (i+65);
            return c;
        }
        
	public static void main(String[] args) throws Exception {
		try (
                    Scanner sc = new Scanner(new FileReader(WORK_DIR+INPUT_FILE_NAME));
                    PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR+OUTPUT_FILE_NAME))
                ) 
            {
                int caseCnt = sc.nextInt();
                for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
                        System.out.println("Processing test case " + (caseNum + 1));
                        pw.print("Case #" + (caseNum + 1) + ": ");
						Codejam r = new Codejam();
                        int n = sc.nextInt();
						int[] arr = new int[n];
						int sum = 0;
						for(int i=0; i<n; i++) {
						    arr[i] = sc.nextInt();
						    sum += arr[i];
						}
						boolean even = sum%2==0 ? true : false;
						boolean stop = false;
						while(!stop) {
						    int m1 = 0;
						    int m1i = 0;
						    int m2 = 0;
						    int m2i = 0;
						    for(int i=0; i<n; i++){
						        if(m1 < arr[i] && arr[i] > 0){
						            m2 = m1;
						            m2i = m1i;
						            m1 =arr[i];
						            m1i = i;
						        } else if(m2 < arr[i] && arr[i] > 0){
						            m2 = arr[i];
						            m2i = i;
						        }
						    }
						    if (!even) {
						        pw.print(r.digittochar(m1i));
						        arr[m1i]--;
						        even = true;
						    }
						    else if(m1 > 0 && m2 > 0) {
						        pw.print(r.digittochar(m1i)+""+r.digittochar(m2i));
						        arr[m1i]--;
						        arr[m2i]--;
						    }
						    else if(m1 > 0 && m2 <= 0) {
						        pw.print(r.digittochar(m1i));
						        arr[m1i]--;
						    }
						    else
						        stop = true;
						    pw.print(" ");
						}
						pw.println();
                }
                pw.flush();
            }
	}
}