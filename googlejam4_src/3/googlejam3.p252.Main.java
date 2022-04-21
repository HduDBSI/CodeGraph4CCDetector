package googlejam3.p252;
import java.util.*;
import java.io.*;
public class Main {
public static void main(String [] args)throws Exception{
	BufferedReader br=new BufferedReader(new FileReader("C:/users/abhishek/Desktop/abhi.txt"));
	FileWriter f=new FileWriter("C:/users/abhishek/Desktop/output.txt");
	String newLine=System.getProperty("line.separator");
	int t=Integer.parseInt(br.readLine());
    for(int test=1;test<=t;test++){
    StringTokenizer st=new StringTokenizer(br.readLine());
    int r=Integer.parseInt(st.nextToken());
    int c=Integer.parseInt(st.nextToken());
    int w=Integer.parseInt(st.nextToken());
    int ans=(c/w)*r;
    if(c%w==0)
    	f.write("Case #" + test + ": " + (ans+w-1) + newLine);
    else f.write("Case #" + test + ": " + (ans+w) + newLine);
	}
	f.close();
}
}