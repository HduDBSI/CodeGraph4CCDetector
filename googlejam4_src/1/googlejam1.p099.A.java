package googlejam1.p099;

import java.io.*;
import java.util.*;

public class A {
	Scanner sc;
	PrintWriter pw;
	int N;
	int[] m;
	
	public static void main(String[] args) throws Exception{
		String filePrefix = args.length>0?args[0]:"A-large (1)";

		try {
			A r = new A();
			r.sc = new Scanner(new FileReader(filePrefix + ".in"));
			r.pw = new PrintWriter(new FileWriter(filePrefix + ".out"));
			int ntest = r.sc.nextInt();
			for(int test=1; test<=ntest; test++) {
				Scanner sc = r.sc;
				r.N = sc.nextInt();
				r.m = new int[r.N];
				for(int i=0; i<r.N; i++)
					r.m[i] = sc.nextInt();
				r.pw.print("Case #" + test + ": ");
				System.out.print("Case #" + test + ": ");
				int ans1 = 0,ans2 = 0;
				int maxrate = 0;
				for(int i=1; i<r.N; i++) {
					ans1 += Math.max(r.m[i-1]-r.m[i], 0);
					maxrate = Math.max(r.m[i-1]-r.m[i], maxrate);
				}
				
				for(int i=1; i<r.N; i++) {
					ans2 += Math.min(r.m[i-1], maxrate);
				}
				Object s = ans1 + " " + ans2;
				
				r.pw.println(s);
				System.out.println(s);
			}
			System.out.println("Finished.");
			r.sc.close();
			r.pw.close();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
}
