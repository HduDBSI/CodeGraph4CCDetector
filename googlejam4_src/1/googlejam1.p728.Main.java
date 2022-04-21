package googlejam1.p728;
import java.util.*;
import java.io.*;
public class Main {
public static void main(String [] args)throws Exception{
	BufferedReader br=new BufferedReader(new FileReader("C:/users/abhishek/Desktop/input.txt"));
	FileWriter f=new FileWriter("C:/users/abhishek/Desktop/output.txt");
	String newLine=System.getProperty("line.separator");
	int t=Integer.parseInt(br.readLine());
	for(int test=1;test<=t;test++){
	int n=Integer.parseInt(br.readLine());
	int array[]=new int[n];
	StringTokenizer st=new StringTokenizer(br.readLine());
	for(int i=0;i<n;i++)array[i]=Integer.parseInt(st.nextToken());
	int ans=0;
	for(int i=0;i<n-1;i++){
		if(array[i] <= array[i+1])continue;
		else ans+=array[i]-array[i+1];
	}
	int min=-1;
	for(int i=0;i<n-1;i++){
		if(array[i] >= array[i+1])min=Math.max(min,array[i]-array[i+1]);
	}
	if(min <= 0){
	 f.write("Case #" + test + ": " + ans + " " + "0" + newLine);
	 continue;
	}
	int temp=0;
	for(int i=0;i<n-1;i++){
		temp+=Math.min(array[i],min);
	}
	f.write("Case #" + test + ": " + ans + " " +temp + newLine);
	}
	f.close();
}
}