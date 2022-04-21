package googlejam3.p303;
import java.util.*;
import java.io.*;

public class prblmA {
    final static String PROBLEM_NAME = "prblmA";
    final static String WORK_DIR = "F:\\GCJ\\" + PROBLEM_NAME + "\\";
	
    public static void main(String[] args) throws Exception {
         //Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-small-attempt1.in"));
         Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-large.in"));
		 //Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
           // System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			prblmA r = new prblmA();
            int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			
			int count = 0 ;
			count = (int) Math.floor(C/W);	 
			count = count*R;
			if(C%W==0)
			count = count+W-1; 
			else
			count = count+W;	
			           
			 pw.println(count);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
