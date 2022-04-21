package googlejam9.p164;
import java.io.*;
import java.util.*;

class B {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("B.in"));
        PrintWriter out = new PrintWriter(new File("B.out"));
		
		int tt = in.nextInt();
		for(int tc=1; tc<=tt; tc++) {            
			int b = in.nextInt();
			long m = in.nextLong();
			out.print("Case #"+tc+": ");
			long p = 1;
			long[] pp = new long[b];
			pp[0] = 1;
			for (int i = 1; i < b-1; i++) {				
				pp[i] = p;
				p = p*2;				
			}
			if (p < m) {
				out.println("IMPOSSIBLE");
			} else {
				out.println("POSSIBLE");
				
				out.print("0");
				for (int i = 1; i < b; i++) {
					if (m >= pp[b-i-1]) {
						out.print("1");
						m -= pp[b-i-1];
					} else {
						out.print("0");
					}
				}
				
				out.println();
				
				for (int i = 1; i < b; i++) {
					for (int j = 0; j <= i; j++)
						out.print("0");
					for (int j = i+1; j < b; j++)
						out.print("1");
					out.println();
				}
			}			
		}
		
		out.close();
		in.close();
	}
}
