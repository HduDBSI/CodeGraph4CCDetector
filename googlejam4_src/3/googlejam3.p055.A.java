package googlejam3.p055;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class A {

	final boolean DEBUG = false;
	final boolean isSmall = false;
	final String PACKAGE = "gcj2015/r1c";
	final String PROBLEM = "A";
	
	public static void main(String[] args) {
		A r = new A();
		if(!r.DEBUG){
			try {
				if(r.isSmall)System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small-attempt0.in")));
				else System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large.in")));
				if(r.isSmall)System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small_out-deg.txt")));
				else System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large_out.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int CASE=1;CASE<=T;CASE++){
			int R = sc.nextInt(), C = sc.nextInt(), W = sc.nextInt();
			int w = 0, res = 0;
			res += R*(C/W);
			if (C%W==0)res+=W-1;
			else res+=W;
			System.out.println("Case #"+CASE+": "+res);
		}
	}
}
