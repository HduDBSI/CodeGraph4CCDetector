package googlejam2.p338;
import java.util.*;
import java.io.*;
public class Main {
public static void main(String [] args)throws Exception{
	BufferedReader br=new BufferedReader(new FileReader("C:/users/abhishek/Desktop/input.txt"));
	FileWriter f=new FileWriter("C:/users/abhishek/Desktop/output.txt");
	String newLine=System.getProperty("line.separator");
	int t=Integer.parseInt(br.readLine());
	int array[]=new int[1000005];
	Arrays.fill(array,Integer.MAX_VALUE);
	array[1]=1;
	for(int i=2;i<=1000000;i++){
	String str=String.valueOf(i);
	StringBuilder sb=new StringBuilder(str);
	str=sb.reverse().toString();
	int temp=Integer.parseInt(str);
	array[i]=Math.min(array[i],i);
	array[i]=Math.min(array[i-1]+1,array[i]);
	if(temp<=1000001){
	array[temp]=Math.min(array[temp],array[i]+1);
	}
	}
	System.out.println(array[21]);
	for(int test=1;test<=t;test++){
	int n=Integer.parseInt(br.readLine());	
	f.write("Case #" + test + ": " + array[n] + newLine);
	}
	f.close();
}
}