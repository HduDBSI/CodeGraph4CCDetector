package googlejam6.p420;
import java.util.*;
import java.io.*;

public class B {
    public static void main (String args[]) throws Exception
    {
        File file = new File("C:\\Users\\charafi\\IdeaProjects\\Round_1_A_2016\\src\\B.in");
        PrintWriter out = new PrintWriter("C:\\Users\\charafi\\IdeaProjects\\Round_1_A_2016\\src\\B.out","UTF-8");
        Scanner in =new Scanner(file);
        int T=in.nextInt();
        for(int i=0;i<T;i++)
        {
            out.printf("Case #%d:",i+1);
            int N=in.nextInt();
            int e[]=new int[2501];
            for(int k=1;k<2501;k++)
            {
                e[k]=0;
            }
            for (int j=0;j<((N-1)*2+1);j++)
            {
                for(int k=0;k<N;k++)
                {
                    e[in.nextInt()]++;
                }
            }
            for(int k=1;k<2501;k++)
            {
                if(e [k]%2==1)
                    out.printf(" %d",k);
            }

            out.printf("\n");
        }
        out.close();
    }
}
