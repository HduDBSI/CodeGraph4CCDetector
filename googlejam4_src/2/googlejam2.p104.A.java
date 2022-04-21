package googlejam2.p104;
import java.util.*;

public class A {
public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	int nCase = scanner.nextInt();
	
	/*
	int[] best = new int[1000001];
	for (int i = 1; i < best.length; i++)
		best[i] = i;
	for (int i = 10; i < best.length; i++) {
		best[i] = Math.min(best[i], best[i-1]+1);
		int next = (int) Long.parseLong(new StringBuilder(""+i).reverse().toString());
		best[next] = Math.min(best[i]+1, best[next]);
	}
	//for (int i = 1; i < 200; i++)
	//	System.out.println("" +i+": "+best[i]);
	
		
	for (int nc = 1; nc <= nCase; nc++) {
		long N = scanner.nextLong();
		
		
		System.out.println("Case #" + nc + ": " + best[(int)N]);
	}
	*/
	
	for (int nc = 1; nc <= nCase; nc++) {
		long N = scanner.nextLong();
		long N1 = N;
		int ans3 = 1;
		while ((N1 /= 10) > 0) ans3++;
		int dN = ans3;
		long ans = 0;
		long start = 0;
		if (N <= 11)
			ans = N;
		else {
			ans = 10;
			int cd = 2;
			long d10 = 10;
			while (cd < dN) {
				d10 *= 10;
				long need = d10 - 1;
				ans += Long.parseLong(new StringBuilder((""+need).substring(0, cd/2)).reverse().toString());
				ans += Long.parseLong((""+need).substring(cd/2, cd));
				ans++;
				cd++;
			}
			
			//System.out.print("ans: "+ans+" ");
			// no more reverse
			long ans1 = ans;
			ans1 += (N - d10);
			
			//System.out.print("ans1: "+ans1+" ");
			// 1 more reverse 
			long ans2 = ans;
			if (N == d10)
				ans2 = ans1;
			else {				
				if ((int) (N%10) == 0) {
					ans2++;
					N--;
				}
				ans2 += Long.parseLong(new StringBuilder((""+N).substring(0, dN/2)).reverse().toString());
				//System.out.print("ans2a: "+ans2+" ");
				ans2 += Long.parseLong((""+N).substring(dN/2, dN));
				//System.out.println("ans2b: "+ans2+" ");	
			}
			
			ans =  Math.min(ans1, ans2);
		}
		
		
		System.out.println("Case #" + nc + ": " + ans);
	}
	
}

}