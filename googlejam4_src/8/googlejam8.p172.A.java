package googlejam8.p172;
import java.io.*;
import java.util.*;

class A {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("A.in"));
        PrintWriter out = new PrintWriter(new File("A.out"));
		
		int tt = in.nextInt();
		in.nextLine();
		for(int tc=1; tc<=tt; tc++) {            
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = in.nextInt();
			}
			
			out.print("Case #"+tc+": ");
			
			if (n > 2) {
				int m1, i1;			
				while (true) {
					m1 = 0;
					i1 = -1;
					for(int i=0; i<n; i++) {
						if (a[i] >= m1) {
							m1 = a[i];
							i1 = i;
						}
					}
					if (m1 == 1) break;
					out.print((char)((int)'A'+i1)+" ");
					a[i1]--;			
				}
				out.print((char)((int)'A'+n-1)+" ");
				for(int i=0; i<n-1; i+=2) {
					out.print((char)((int)'A'+i)+""+(char)((int)'A'+i+1)+" ");
				}
			} else {
				if (a[0] == a[1]) {
					for(int i=0; i<a[0]; i++) {
						out.print("AB ");
					}
				} else {
					if (a[0] > a[1]) {
						for(int i=a[0]; i>a[1]; i--) {
							out.print("A ");
						}
						for(int i=0; i<a[1]; i++) {
							out.print("AB ");
						}
					} else {
						for(int i=a[1]; i>a[0]; i--) {
							out.print("B ");
						}
						for(int i=0; i<a[0]; i++) {
							out.print("AB ");
						}
					}					
				}				
			}
			out.println();
		}
		
		out.close();
		in.close();
	}
}
