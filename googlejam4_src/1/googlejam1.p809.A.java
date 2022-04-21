package googlejam1.p809;
import java.io.*;
import java.util.*;
public class A{
	final static String inputFile="A-large.in";
	final static String outputFile="A-output.txt";
	static Scanner reader;
	static PrintStream writer;
	static int n; static long res1,res2,m[],a[],trest2;
	public static void main(String[] args) throws Exception{
		reader=new Scanner(new FileInputStream(inputFile));
		writer=new PrintStream(new FileOutputStream(outputFile));
		int ntest=reader.nextInt();  int i;
		for (int test=1; test<=ntest;test++){
			n=reader.nextInt(); m=new long[n];
			for (i=0;i<n;i++) m[i]=reader.nextLong();
			long maxrate=0; res1=0;
			for (i=1;i<n;i++){
				if (m[i-1]>m[i]) res1+=(m[i-1]-m[i]);
				maxrate=Math.max(maxrate,m[i-1]-m[i]);
			}
			a=new long [n+2];
			res2=maxrate*n*n; 
			long rs,l=0,r=maxrate*n*n,rate;
			while(l<=r){
				rate=(l+r)/2;
				rs=0;
				for (i=1;i<n;i++){
					if (m[i-1]>=rate)rs+=rate;
					else rs+=m[i-1];
					if (m[i-1]-rate>m[i]) break;
				}
				if (i==n){
					res2=Math.min(rs,res2);
					r=rate-1;
				}else{
					l=rate+1;
				}
			}
			writer.println("Case #"+test+": "+res1+" "+res2);
		}
	}
	
}
