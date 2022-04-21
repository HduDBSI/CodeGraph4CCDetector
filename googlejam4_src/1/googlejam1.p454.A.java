package googlejam1.p454;
import java.io.*;
import java.util.*;

public class A {
	public static void main (String[]args)throws IOException{
		BufferedReader x=new BufferedReader(new FileReader("Alarge.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Alarge.out")));
		int t=Integer.parseInt(x.readLine());
		for (int cases=1; cases<=t; cases++){
			int n=Integer.parseInt(x.readLine());
			int[]s=new int[n];
			StringTokenizer st=new StringTokenizer(x.readLine());
			for (int i=0; i<n; i++){
				s[i]=Integer.parseInt(st.nextToken());
			}
			int maxgap=-1;
			for (int i=1; i<n; i++){
				if (s[i-1]-s[i]>maxgap)maxgap=s[i-1]-s[i];
			}
			int sum1=0;
			for (int i=1; i<n; i++){
				if (s[i]<s[i-1])sum1+=s[i-1]-s[i];
			}
			int sum2=0;
			for (int i=0; i<n-1; i++){
				sum2+=Math.min(maxgap,s[i]);
			}
			out.println("Case #"+cases+": "+sum1+" "+sum2);
		}
		out.close();
		System.exit(0);
	}
}