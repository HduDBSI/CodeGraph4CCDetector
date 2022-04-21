package googlejam8.p037;
import java.util.Scanner;
public class A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for(int i = 0; i<n; i++) {
				p[i] = sc.nextInt();
			}
			int maxid1 = -1;
			int max1 = 0;
			int maxid2 = -1;
			int max2 = 0;
			for(int i = 0; i<n; i++) {
				if(p[i]>max1) {
					max2 = max1;
					maxid2 = maxid1;
					max1 = p[i];
					maxid1 = i;
				} else if(p[i]>max2) {
					max2 = p[i];
					maxid2 = i;
				}
			}
			StringBuilder out = new StringBuilder();
			if(max1 != max2) {
				for(int i = 0; i<max1-max2; i++) {
					out.append((char)('A'+maxid1));
					out.append(' ');
				}
			}
			for(int i = 0; i<n; i++) {
				if(i == maxid1 || i == maxid2) continue;
				for(int j = 0; j<p[i]; j++) {
					out.append((char)('A'+i));
					out.append(' ');
				}
			}
			for(int i = 0; i<max2; i++) {
				out.append((char)('A'+maxid1));
				out.append((char)('A'+maxid2));
				out.append(' ');
			}
			
			
			System.out.println("Case #" + t + ": " + out.toString());
		}
	}
}