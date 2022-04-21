package googlejam1.p142;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

	final boolean DEBUG = false;
	final boolean isSmall = false;
	final String PACKAGE = "gcj2015/r1a";
	final String PROBLEM = "A";
	
	public static void main(String[] args) {
		A r = new A();
		if(!r.DEBUG){
			try {
				if(r.isSmall)System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small-attempt1.in")));
				else System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large.in")));
				if(r.isSmall)System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small_out2.txt")));
				else System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large_out.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int CASE=1;CASE<=T;CASE++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int resY = 0, res = 1<<29;
			for(int i=1;i<n;i++){
				if (a[i] < a[i-1]) resY += a[i-1]-a[i];
			}
			for(int rate=0;rate<=10000;rate++){
				boolean f = true;
				int sum = 0, now = a[0];
				for(int i=1;f&&i<n;i++){
					if (now <= rate) {
						sum += now;
						now = a[i];
					} else if (now-rate <= a[i]){
						sum += rate; now = a[i];
					} else f=false;
				}
				if (f) {
					res = Math.min(res, sum); break;
				}
			}
			System.out.println("Case #"+CASE+": "+resY+" "+res);
		}
	}
}
