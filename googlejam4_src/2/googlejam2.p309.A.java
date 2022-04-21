package googlejam2.p309;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class A {
	
	static int[] arr=new int[1000001];
	
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;
	
	public static void main(String[] args)throws IOException {
		br=new BufferedReader(new FileReader("A-small-attempt0.in"));
		pw=new PrintWriter(new FileOutputStream("output_A.in"));
		int t=Integer.parseInt(br.readLine());
		for(int i=2;i<1000001;i++)
			arr[i]=1000001;
		arr[1]=1;
		for(int i1=2;i1<1000001;i1++) {
			arr[i1]=Math.min(arr[i1-1]+1, arr[i1]);
			int num=i1;
			long rev=0;
			while(num>0) {
				rev=num%10+rev*10;
				num/=10;
			}
			//pw.println(rev);
			if(rev<1000000 && rev>i1)
				arr[(int)rev]=Math.min(arr[i1]+1, arr[(int)rev]);
		}
		for(int i=1;i<=t;i++) {
			int n=Integer.parseInt(br.readLine());
			pw.println("Case #"+i+": "+arr[n]);
		}
		pw.flush();
	}
}







