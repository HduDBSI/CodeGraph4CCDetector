package googlejam2.p335;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Main
{
public static void main(String[] args)throws java.lang.Exception
{
BufferedReader in = new BufferedReader(new FileReader("A-small-attempt2.in"));
PrintWriter out=new PrintWriter("output.txt");
int t,x1,i,j,n,n1,cnt,v;
String str1,str2;

t=Integer.parseInt(in.readLine());
 
 
for(x1=0;x1<t;x1++)
{
n=Integer.parseInt(in.readLine());


int[] steps=new int[n+1];

steps[1]=1;

for(i=2;i<=n;i++)
	steps[i]=1000001;



for(j=2;j<=n;j++)
{
str1=String.valueOf(j);

str2="";

for(i=str1.length()-1;i>=0;i--)
{
str2+=str1.charAt(i);
}

v=Integer.parseInt(str2);

str2=String.valueOf(v);

if(v<j && v>=1 && str1.length()==str2.length())
	{
	steps[j]=Math.min(steps[v]+1,steps[j-1]+1);
	}
else
	steps[j]=steps[j-1]+1;
}

out.println("Case #"+(x1+1)+": "+steps[n]);

}

out.flush();
out.close();
}
}

