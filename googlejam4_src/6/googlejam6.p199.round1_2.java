package googlejam6.p199;
import java.io.*;
import java.util.Scanner;

class round1_2
{
public static void main(String args[])throws IOException
{ 
FileInputStream in =new FileInputStream("B-large.in");
FileOutputStream outer =  new FileOutputStream("output.txt");
InputStreamReader inn=new InputStreamReader(in);
BufferedReader br=new BufferedReader(inn);
PrintWriter ob=new PrintWriter(outer,true);
String bb=br.readLine();int i;
int t=Integer.parseInt(bb);int j=0;
while(t-->0)
{
++j;
String a=br.readLine();
int n=Integer.parseInt(a);
int k[]=new int[2501];
for(i=1;i<2*n;i++)
{
String b[]=br.readLine().split(" ");
for(int l=0;l<n;l++)
k[Integer.parseInt(b[l])]++;
}
ob.print("Case #"+j+": ");
for(i=1;i<=2500;i++)
{
if(k[i]%2!=0)
ob.print(i+" ");
}
ob.println();
}
in.close();
outer.flush();
outer.close();
}

}