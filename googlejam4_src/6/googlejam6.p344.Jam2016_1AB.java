package googlejam6.p344;
import java.util.Scanner;


public class Jam2016_1AB {
	public static void main(String[] args) {
		Scanner	scanIn	= new Scanner(System.in);
		
		int T	= scanIn.nextInt();
		
		for(int i=0; i<T; ++i) {
			Jam2016_1AB	inst	= new Jam2016_1AB();
			int		n		= scanIn.nextInt();
			int N = 2*n-1;

			int[][]		d	= new int[N][n];
			
			for(int j=0; j<N; ++j) {
				for(int k=0; k<n; ++k) {
					d[j][k]	= scanIn.nextInt();
				}
			}
			int	n1 = d[0].length;
			int[] h = new int[2501];
			
			for(int i1=0; i1<d.length; ++i1) {
				for(int j1=0; j1<n1; ++j1) {
					h[d[i1][j1]]++;
				}
			}
			
			int idx = 0;
			int[] ret1 = new int[n1];
			for(int i2=0; i2<2501; ++i2) {
				int dd = h[i2];
				if(dd%2 != 0)
					ret1[idx++] = i2;
			}
			
			int[] ret = ret1;

			System.out.print("Case #" + (i+1) + ":");
			for(int j: ret)
				System.out.print(" " + j);
			System.out.println();
		}
		
		scanIn.close();
	}

}
