package googlejam6.p128;

import java.util.Scanner;
import java.io.PrintStream;
import java.util.Arrays;

public class Rank {
    
    public static void main(String[] args) {
        Rank r = new Rank();
		int i,T;
		T=r.sc.nextInt();
		for (i=1;i<=T;i++) {
		    r.out.printf("Case #%d: ",i);
		    r.N=r.sc.nextInt();
			int allsize=(2*r.N-1)*r.N;
			int i1,i0,j;
			r.all=new int[allsize];
			r.missing=new int[r.N];
			for (i1=0;i1<allsize;i1++) r.all[i1]=r.sc.nextInt();
			i1=j=i0=0;
			Arrays.sort(r.all);
			while (true) {
			    i0=i1;
			    if (i0>=allsize) break;
			    while (i1<allsize && r.all[i0]==r.all[i1]) i1++;
			    int count=i1-i0;
			    if ((count & 1)==1) r.missing[j++]=r.all[i0]; 
			}
			for (int x : r.missing) r.out.printf("%d ",x);
			r.out.println();
		}
    }
    
    Scanner sc=new Scanner(System.in);
    PrintStream out=System.out;
    
    int N;
    int[] all;
    int[] missing;
    
}
