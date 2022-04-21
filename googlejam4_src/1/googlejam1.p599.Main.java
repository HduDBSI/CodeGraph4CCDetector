package googlejam1.p599;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Main
{
public static void main(String[] args)throws java.lang.Exception
{
BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
PrintWriter out=new PrintWriter("output.txt");
int t,x1,n,i,v1,v2,ans1,ans2,diff;


t=Integer.parseInt(in.readLine());
 
 
for(x1=0;x1<t;x1++)
{
n=Integer.parseInt(in.readLine());

StringTokenizer st1=new StringTokenizer(in.readLine());

int[] a=new int[n];

for(i=0;i<n;i++)
{
a[i]=Integer.parseInt(st1.nextToken());
}

v1=a[0];

ans1=0;
diff=0;

for(i=1;i<n;i++)
{
v2=a[i];

if(v2<v1)
	{
	ans1+=(v1-v2);
	diff=Math.max(diff,v1-v2);
	}

v1=a[i];
}

ans2=0;

for(i=0;i<n-1;i++)
{
ans2+=Math.min(a[i],diff);
}

out.println("Case #"+(x1+1)+": "+ans1+" "+ans2);

}

out.flush();
out.close();
}
}    