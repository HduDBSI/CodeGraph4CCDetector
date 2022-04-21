package googlejam6.p418;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.*;
import java.lang.StringBuilder;
import java.lang.Math;
class MyClass 
{



public static void main(String[] arguments) throws Exception
{
BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Java\\A-small-attempt0.in")));
BufferedWriter bw=new BufferedWriter(new FileWriter(new File("C:\\Java\\A-large.out")));
BufferedWriter bw2=new BufferedWriter(new FileWriter(new File("C:\\Java\\PractiseData2.out")));	

int T = java.lang.Integer.parseInt(br.readLine());
String[] Line;
int[] Arr = new int[2501];
for(int t=0;t<T;++t)
{

//initialize zero
for(int j=0;j<2501;j++)
{
Arr[j]=0;
}

int N = java.lang.Integer.parseInt(br.readLine());
	for(int n=0;n<(N*2-1);++n)
	{
		Line=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
		Arr[java.lang.Integer.parseInt(Line[i])]++;
		}
	}


bw.write("Case #"+(t+1)+": ");
int count=1;
for(int k=0;k<2501;k++)
{
if(Arr[k]>0)
bw2.write(""+k+"="+Arr[k]+" ");
if(Arr[k]>0)
{
if(Arr[k]%2!=0)
{
if(count == N)
bw.write(""+(k));
else
bw.write(""+(k)+" ");
count++;
}
}
}

bw.newLine();

}
bw.close();
bw2.close();
}
}


