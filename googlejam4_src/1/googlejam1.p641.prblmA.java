package googlejam1.p641;
import java.util.*;
import java.io.*;

public class prblmA {
    final static String PROBLEM_NAME = "prblmA";
    final static String WORK_DIR = "F:\\GCJ\\" + PROBLEM_NAME + "\\";

    public static void main(String[] args) throws Exception {
         //Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-small-attempt0.in"));
         Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
           // System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			prblmA r = new prblmA();
            int N= sc.nextInt();
			int m[] = new int[N];
			 for(int i=0;i<N;i++)
			    m[i]=sc.nextInt();
			 int c1=0,c2=0;
			int d=0;
			for(int i=1;i<N;i++)
			{
				if(m[i]<m[i-1])
				{
					c1+=m[i-1]-m[i]; 
					if((m[i-1]-m[i])>d)
					{d=m[i-1]-m[i];}
				}
			}
			for(int i=0;i<N-1;i++)
			{
				c2+=Math.min(m[i],d);
			}
			           
			 pw.println(c1+" "+c2);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
