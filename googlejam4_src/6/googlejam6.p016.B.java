package googlejam6.p016;

import java.io.*;
import java.util.*;

public class B {
	Scanner sc;
	PrintWriter pw;
	int N;
	int[][] h;
	
	public static void main(String[] args) throws Exception{
		String filePrefix = args.length>0?args[0]:"B-large";

		try {
			B r = new B();
			r.sc = new Scanner(new FileReader(filePrefix + ".in"));
			r.pw = new PrintWriter(new FileWriter(filePrefix + ".out"));
			int ntest = r.sc.nextInt();
			for(int test=1; test<=ntest; test++) {
				Scanner sc = r.sc;
				r.N = sc.nextInt();
				r.h = new int[2*r.N-1][r.N];
				for(int i=0; i<2*r.N-1; i++)
					for(int j=0; j<r.N; j++)
						r.h[i][j] = sc.nextInt();
				r.pw.print("Case #" + test + ": ");
				System.out.print("Case #" + test + ": ");
				int[] count = new int[2500];
				for(int i=0; i<2*r.N-1; i++)
					for(int j=0; j<r.N; j++)
						count[r.h[i][j]-1]++;
				
				int[] ans = new int[r.N];
				int idx=0;
				for(int i=0; i<2500; i++)
					if(count[i]%2!=0)
						ans[idx++] = i+1;
				
				for(int i=0; i<r.N; i++) {
					Object s = ans[i] + (i==r.N-1 ? "\n" : " ");
					r.pw.print(s);
					System.out.print(s);
				}
			}
			System.out.println("Finished.");
			r.sc.close();
			r.pw.close();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
}
