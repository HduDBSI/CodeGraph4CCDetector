package googlejam1.p616;
import java.util.Scanner;


public class Jam2015_1AC {
	int	ret1;
	int	ret2;
	
	public static void main(String[] args) {
		Scanner	scanIn	= new Scanner(System.in);
		
		int T	= scanIn.nextInt();
		
		for(int i=0; i<T; ++i) {
			Jam2015_1AC	inst	= new Jam2015_1AC();
			int		n		= scanIn.nextInt();
			
			int[]	pList	= new int[n];

			for(int j=0; j<n; ++j)
				pList[j]	= scanIn.nextInt();
			int[]	ret	= new int[n-1];
			
			for(int i1=0; i1<n-1; ++i1)
				ret[i1]	= pList[i1+1] - pList[i1];
			
			int[]	tmp	= ret;
			int	ret1	= 0;
			for(int item: tmp) {
				ret1 += (item < 0) ? -item: 0;
			}
			
			inst.ret1	= ret1;
			int	speed	= 0;
			for(int item2: tmp) {
				speed = (speed > item2) ? item2: speed;
			}
			speed	= -speed;
			
			int	ret2	= 0;
			for(int i1=0; i1<n-1; ++i1) {
				int item1	= pList[i1];
				int	tmp1	= speed;
				ret2	+= (item1 < tmp1) ? item1: tmp1;
			}
			inst.ret2	= ret2;
			
			System.out.println("Case #" + (i+1) + ": " + inst.ret1 + " " + inst.ret2);
		}
		
		scanIn.close();
	}
}
