package googlejam1.p694;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class A {
	
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;
	
	public static void main(String[] args)throws IOException {
		br=new BufferedReader(new FileReader("A-large.in"));
		pw=new PrintWriter(new FileOutputStream("output_A.in"));
		int t=Integer.parseInt(br.readLine());
		for(int j=1;j<=t;j++) {
			int n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int[] arr=new int[n];
			int ans=0, ans1=0, diff=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<n-1;i++) {
				diff=arr[i]-arr[i+1]>diff?arr[i]-arr[i+1]:diff;
			}
			//pw.println(diff);
			for(int i=0;i<n-1;i++) {
				if(arr[i]<diff)
					ans1+=arr[i];
				else
					ans1+=diff;
				if(arr[i+1]<arr[i])
					ans+=arr[i]-arr[i+1];
			}
			pw.println("Case #"+j+": "+ans+" "+ans1);
		}
		pw.flush();
	}
}