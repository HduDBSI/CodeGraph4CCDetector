package googlejam9.p111;
import java.util.*;
import java.math.BigInteger;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	static long p2[] = new long[101];
	
	public static void main(String[] args) {
		int T = scan.nextInt();
		p2[0] = 1;
		for(int i=1; i<101; i++) p2[i] = p2[i-1]*2;
		int X = 1;
		while(T-- > 0) {
			int n = scan.nextInt();
			long m = scan.nextLong();
			boolean [][] ans = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					ans[i][j] = true;
				}
			}
			System.out.print("Case #" + (X++) + ": ");
			if(m <= p2[n-2]) {
				System.out.println("POSSIBLE");
				BigInteger bi = new BigInteger("" + (p2[n-2] - m));
				String s = bi.toString(2);
				for(int i=s.length()-1; i>=0; i--) {
					if(s.charAt(i) == '1') {
						ans[s.length()-i][n-1] = false;
					}
				}
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(ans[i][j] == true) System.out.print("1");
						else System.out.print("0");
					}
					System.out.println();
				}
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
	
}
