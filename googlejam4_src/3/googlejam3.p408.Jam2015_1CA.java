package googlejam3.p408;
import java.util.Scanner;


public class Jam2015_1CA {
	public static void main(String[] args) {
		Scanner	scanIn	= new Scanner(System.in);
		
		int T	= scanIn.nextInt();
		
		for(int i=0; i<T; ++i) {
			Jam2015_1CA	inst	= new Jam2015_1CA();
			int		r	= scanIn.nextInt();
			int		c	= scanIn.nextInt();
			int		w	= scanIn.nextInt();
			int	total	= r*c;
			int	ret1		= 0;
			
			//	scan
			ret1	= r*(c/w);
			
			if(c % w == 0) {
				ret1	+= w-1;
			} else if( w == 1) {
			} else {
				ret1	+= w;
			}
			
			int	ret	= ret1;
			
			System.out.println("Case #" + (i+1) + ": " + ret);
		}
		
		scanIn.close();
	}
}
