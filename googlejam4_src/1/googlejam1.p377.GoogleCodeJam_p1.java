package googlejam1.p377;
import java.io.*;
import java.util.*;
class GoogleCodeJam_p1
{
    static int a[]=new int [1000];
    static int N;
    static int maxDif = 0;
    public static void main(String[]args)throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("E:\\input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("E:\\output.txt"));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++)
        {
            pw.print("Case #"+i+": ");
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            a[j]= Integer.parseInt(st.nextToken());
			int ans=0;
			int i1=0,j=1;
			while(j<=N-1)
			{
			    if(a[j] < a[i1])
			    {
			        ans+=a[i1]-a[j];
			        maxDif = Math.max(maxDif,a[i1]-a[j]);
			    }
			    i1++;
			    j++;
			}
            int x = ans;
			int ans1 = 0;
			for(int i2=0;i2<N-1;i2++)
			{
			    ans1+=Math.min(a[i2],maxDif);
			}
            int y = ans1;
            pw.println(x+" "+y);
            maxDif=0;
        }
        pw.close();
    }
}