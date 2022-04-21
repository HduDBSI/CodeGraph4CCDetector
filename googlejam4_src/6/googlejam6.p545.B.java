package googlejam6.p545;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		//BufferedReader f = new BufferedReader(new FileReader("B-small-attempt1.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
			//	"B-small.out")));
		 BufferedReader f=new BufferedReader(new FileReader("B-large.in"));
		 PrintWriter out=new PrintWriter(new BufferedWriter(new
		 FileWriter("B-large.out")));

		int t,n;
		t = Integer.parseInt(f.readLine());
		for(int tt = 1; tt <= t; tt++) {
			int[] dp=new int[2501];
			n=Integer.parseInt(f.readLine());
			
			
			for(int j=0;j<2*n-1;j++){
				StringTokenizer st=new StringTokenizer(f.readLine());
				for(int k=0;k<n;k++){
					
					dp[Integer.parseInt(st.nextToken())]++;
				}
			}
			
			
			int l=1;StringBuffer buf=new StringBuffer();
			
			//critical code
			while(l<2501){
				if(dp[l]!=0 && dp[l]%2==1){
					/*
					if(buf.length()==n){
						buf.append(l);break;
					}
					else*/
					
					buf.append(l+" ");
					
				}
				l++;
				
			}
			
			buf.deleteCharAt(buf.length()-1);
		System.out.println("Case #" + (tt) + ": "+buf);
			out.println("Case #" + (tt) + ": " + buf);
		}

		 f.close();out.close();
		 System.out.println("done bro!");
	}

}
