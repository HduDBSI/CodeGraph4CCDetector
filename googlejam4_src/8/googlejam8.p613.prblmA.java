package googlejam8.p613;
import java.util.*;
import java.io.*;

public class prblmA {
    final static String PROBLEM_NAME = "prblmA";
    final static String WORK_DIR = "F:\\GCJ\\" + PROBLEM_NAME + "\\";

    public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.txt"));
        //Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-small-attempt0.in"));
		Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-large.in"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++) {
           System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum+1) + ": ");
			prblmA r = new prblmA();
            int N = sc.nextInt();
			int P[] = new int[N];
			for(int i=0;i<N;i++)
			{
				P[i]=sc.nextInt();
			}
			int flag=1;
			int max = P[0];
			int maxi=0;
			char out = 'A'; 
			while(true)
			{max = P[0];
			         maxi=0;
				for(int i=0;i<N;i++)
				{   
					if(P[i]>max)
					{
						max=P[i];
						maxi=i;
					}	
				}
				if(max==1)
				{int count =0;
					for(int i=0;i<N;i++)
				{   
					if(P[i]==1)
					{
						count++;
					}	
				}
				if(count==3)
				{
					flag=0;
				}
				}	
			System.out.println(max+" "+maxi);
			    if(max==0)
				{break;}
			    else
				{
					P[maxi]=P[maxi]-1;
					out = (char)('A'+maxi);
					if(flag==1)
					{pw.print(out);flag=0;}
				    else //if(flag==0)
					{pw.print(out+" ");flag=1;}
				}
			}
			  pw.println();
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
