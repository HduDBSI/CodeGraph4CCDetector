package googlejam6.p239;
import java.util.Scanner;
public class B {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i<= T; i++) {
			int N = sc.nextInt();
			int[] in = new int[2501];
			for(int j = 0; j<2*N-1; j++) {
				for(int k = 0; k<N; k++) {
					in[sc.nextInt()]++;
				}
			}
			String s = "Case #" + i + ":";
			for(int j = 1; j<2501; j++) {
				if(in[j]%2 != 0) {
					s = s + " " + j;
				}
			}
			System.out.println(s);
			
		}
	}
}