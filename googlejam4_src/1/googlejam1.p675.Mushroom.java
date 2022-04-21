package googlejam1.p675;
import java.util.Scanner;


public class Mushroom {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for(int i = 1; i<= T; i++) {
			int N = input.nextInt();
			int[] m = new int[N];
			for(int j = 0; j<N; j++) {
				m[j] = input.nextInt();
			}
			long Meth1 = 0;
			for(int k =0; k<N-1; k++) {
				if(m[k]-m[k+1] > 0) {
					Meth1 += m[k]-m[k+1];
				}
			}
			
			long Meth2 = 0;
			long constRate = m[N-2] - m[N-1];
			
			for(int l = 0; l<N-1; l++) {
				if(m[l] <= constRate) {
					Meth2 += m[l];
				}
				else {
					Meth2 += constRate;
				}
			}
			
			System.out.printf("Case #%d: %d %d\n",i,Meth1,Meth2);
			
		}
		input.close();
	}

}
