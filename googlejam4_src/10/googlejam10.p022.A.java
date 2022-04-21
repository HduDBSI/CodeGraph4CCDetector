package googlejam10.p022;

import java.io.*;
import java.util.*;

public class A {
	Scanner sc;
	PrintWriter pw;
	int N;
	int[] p = new int[3];
	
	public static void main(String[] args) throws Exception{
		String filePrefix = args.length>0?args[0]:"A-large";

		try {
			A r = new A();
			r.sc = new Scanner(new FileReader(filePrefix + ".in"));
			r.pw = new PrintWriter(new FileWriter(filePrefix + ".out"));
			int ntest = r.sc.nextInt();
			for(int test=1; test<=ntest; test++) {
				Scanner sc = r.sc;
				r.N = sc.nextInt();
				for(int i=0; i<3; i++)
					r.p[i] = sc.nextInt();
				r.pw.print("Case #" + test + ": ");
				System.out.print("Case #" + test + ": ");
				int SIZE = 1<<r.N;
				char[] C = {'R','P','S'};
				char[] ans = null;
				for(int i=0; i<3; i++) {
					int[] win = new int[SIZE*2-1];
					win[0] = i;
					for(int j=0; j<SIZE-1; j++) {
						win[j*2+1] = win[j];
						win[j*2+2] = (win[j]+2)%3;
					}
					
					int[] cnt = new int[3];
					char[] ini = new char[SIZE];
					for(int j=0; j<SIZE; j++) {
						cnt[win[SIZE-1+j]]++;
						ini[j] = C[win[SIZE-1+j]];
					}
					boolean ok = true;
					for(int j=0; j<3; j++)
						if(cnt[j]!=r.p[j])
							ok = false;
					
					if(!ok)
						continue;
					
					//sort for alphabetical 
					for(int j=0; j<r.N; j++) {
						for(int k=0; k<SIZE; k+=1<<(j+1)) {
							boolean rev = false;
							for(int l=0; l<1<<j; l++) {
								if(ini[k+l] > ini[k+(1<<j)+l]) {
									rev = true;
									break;
								}
							}
							if(rev) {
								for(int l=0; l<1<<j; l++) {
									char temp = ini[k+l];
									ini[k+l] = ini[k+(1<<j)+l];
									ini[k+(1<<j)+l] = temp;
								}
							}
						}
					}
					if(ans==null || String.valueOf(ini).compareTo(String.valueOf(ans))<0)
						ans = ini;
				}
				Object s = ans==null ? "IMPOSSIBLE" : String.valueOf(ans);
				
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
