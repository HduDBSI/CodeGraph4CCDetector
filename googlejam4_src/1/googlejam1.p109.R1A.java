package googlejam1.p109;


import java.io.*;
import java.util.*;

public class R1A {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("other/gcj2015/A-large.in"))));
		PrintWriter ou = new PrintWriter("other/gcj2015/R1A.txt");
		
		int res,rep,i,j,n,rate;
		long ans1,ans2;
		int[] m = new int[10001];
		
		
		res = sc.nextInt();
		for(rep=1;rep<=res;rep++){
			
			n = sc.nextInt();
			ans1 = 0; rate = 0;
			
			for(i=0;i<n;i++) {
				m[i] = sc.nextInt();
				
				if (i>0) {
					ans1 += Math.max(0, m[i-1]-m[i]);
					if (m[i-1]-m[i]>rate) rate = m[i-1]-m[i];
				}
			}
			
			ans2 = 0;
			for(i=0;i<n-1;i++) {
				if (m[i]>=rate) ans2 += rate;
				else ans2 += m[i];
			}
			
			System.out.printf("Case #%d: %d %d\n",rep,ans1,ans2);
			ou.printf("Case #%d: %d %d\n",rep,ans1,ans2);
		}
		
		ou.close();
	}
}
