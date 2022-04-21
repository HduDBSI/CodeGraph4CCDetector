package googlejam3.p395;
import java.io.*;
import java.util.*;

public class A {
	public static void main (String[]args)throws IOException{
		BufferedReader x=new BufferedReader(new FileReader("Alarge.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Alarge.out")));
		int t=Integer.parseInt(x.readLine());
		int[][]dp=new int[21][21];
		for (int i=1; i<=20; i++){
			dp[i][1]=i;
			dp[i][i]=i;
			dp[i][i-1]=i;
		}
		for (int i=1; i<=20; i++){
			for (int j=2; j<=i/2; j++){
				if (i%j==0){
					dp[i][j]=dp[2*j-1][j]+i/j-2;
				}else{
					dp[i][j]=dp[2*j-1][j]+i/j-1;
				}
			}
			for (int j=i/2+1; j<=i; j++){
				dp[i][j]=dp[2*i-2*j][i-j]+2*j-i;
			}
		}
		for (int cases=1; cases<=t; cases++){
			StringTokenizer st=new StringTokenizer(x.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			out.println("Case #"+cases+": "+((r-1)*(c/w)+dp[c][w]));
		}
		out.close();
		System.exit(0);
	}
}