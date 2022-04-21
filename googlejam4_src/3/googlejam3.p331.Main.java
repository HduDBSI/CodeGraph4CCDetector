package googlejam3.p331;
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
int t,x1,r,c,w,val,res;

t=Integer.parseInt(in.readLine());
 
 
for(x1=0;x1<t;x1++)
{
StringTokenizer st1=new StringTokenizer(in.readLine());

r=Integer.parseInt(st1.nextToken());
c=Integer.parseInt(st1.nextToken());
w=Integer.parseInt(st1.nextToken());


val=c/w;
res=r*val;
res+=(w-1);

if(c%w!=0)
	res+=1;


if(w==1)
	res=r*c;

out.println("Case #"+(x1+1)+": "+res);


}

out.flush();
out.close();
}
}

