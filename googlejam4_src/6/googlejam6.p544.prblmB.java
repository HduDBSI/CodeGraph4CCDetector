package googlejam6.p544;
import java.util.*;
import java.io.*;

public class prblmB {
    final static String PROBLEM_NAME = "prblmB";
    final static String WORK_DIR = "F:\\GCJ\\" + PROBLEM_NAME + "\\";
  	
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(new FileReader(WORK_DIR + "B-small-attempt0.in"));
        //Scanner sc = new Scanner(new FileReader(WORK_DIR + "B-small-attempt1.in"));
		Scanner sc = new Scanner(new FileReader(WORK_DIR + "B-large.in"));
		//Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			prblmB r = new prblmB();
            int N = sc.nextInt();
						int ar[][] = new int[2*N-1][N];
						int br[] = new int[2501];
						for(int i=0;i<2*N-1;i++)
						{ for(int j=0;j<N;j++)
						 {
							 ar[i][j] = sc.nextInt();
							 if(br[ar[i][j]]==0)
								 br[ar[i][j]]=1;
							 else
								 br[ar[i][j]]=0;
							
						 }				 
				       }
					   
					 for(int i=0;i<2501;i++)
						 {
							if(br[i]==1)
							 pw.print(i+" ");
						 }				 
			pw.println();
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
