package googlejam1.p717;
import java.io.*;
import java.util.*;
public class ProbA
{
    static Scanner sc;
    static PrintWriter pw;
    public static void main(String args[])throws IOException
    {
        sc=new Scanner(new File("input/A-large.in")); //For Scanning input file
        pw=new PrintWriter(new File("output/A-large.out"));//For writing output file
        int T=sc.nextInt();//no. of cases

        for(int x=1 ;x<=T; x++)
        {
            int N=sc.nextInt();
            int pc[]=new int[N];
            int y=0,z=0,rate=0;
            for(int i=0;i<N;i++)
            {
                pc[i]=sc.nextInt();
                if(i!=0)
                {
                    if(pc[i]<pc[i-1])
                    y+=pc[i-1]-pc[i];
                    
                    if((pc[i-1]-pc[i])>rate)
                    rate=pc[i-1]-pc[i];
                }
            }
            for(int i=0;i<(N-1);i++)
            {
                if(pc[i]<rate)
                z+=pc[i];
                else
                z+=rate;
            }
            pw.println("Case #"+x+": "+y+" "+z);
        }
        sc.close();
        pw.close();
    }
}
