package googlejam1.p344;
import java.util.*;

public class R1A_A {
	int n;
	int[] m;
	
	
	public static void main(String[] args) {
		R1A_A r = new R1A_A();
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int test=1;test<=t;test++){
			r.n = sc.nextInt();
			
			r.m = new int[r.n];
			for(int i=0;i<r.n;i++) r.m[i] = sc.nextInt();
			
			int ans1 = 0;
			int difmax = 0;
			for(int i=0;i<r.n-1;i++){
				int dif = r.m[i]-r.m[i+1];
				if(dif>0){
					ans1 += dif;
					difmax = Math.max(dif, difmax);
				}
			}
			
			int ans2 = 0;
			for(int i=0;i<r.n-1;i++){
				if(r.m[i]-difmax>0) ans2 += difmax;
				else ans2 += r.m[i];
			}
			
			System.out.println("case #" + test + ": " + ans1 + " " + ans2);
		}
		sc.close();
	}

}
