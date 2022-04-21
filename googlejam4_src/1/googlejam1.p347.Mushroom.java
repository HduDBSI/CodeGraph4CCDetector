package googlejam1.p347;


import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

public class Mushroom {
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = parseInt(s.nextLine());
		
		for (int i=1 ; i<=n ; i++) {
			System.out.print("Case #" + i + ": ");
			System.err.println(i+"/"+n);
			
			int N = s.nextInt();
			
			long kfirst = 0;
			long ksecond = 0;
			
			int m[] = new int[N];
			for (int i2=0 ; i2<N ; i2++) {
				m[i2] = s.nextInt();
			}
			
			int rate = 0;
			
			for (int i3=1 ; i3<N ; i3++) {
				int dif = m[i3] - m[i3-1];
				
				if (dif < 0) {
					kfirst += -dif;
				}
				
				if (-dif > rate) {
					rate = -dif;
				}
			}
			
			for (int i1=1 ; i1<N ; i1++) {
				ksecond += Math.min(rate, m[i1-1]);
			}
			
			System.out.println(kfirst + " " + ksecond);
		}
	}
	
}
