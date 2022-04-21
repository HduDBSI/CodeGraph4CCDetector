package googlejam1.p585;
import java.util.*;

class Main{

    int[] mash;

    public static void main(String[] args){
        Main r = new Main();
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
		    int n = sc.nextInt();
		    r.mash = new int[n];
		    for(int j=0; j<n; j++) r.mash[j] = sc.nextInt();
			int res = 0;
			for(int i1=1; i1<r.mash.length; i1++){
			    if(r.mash[i1-1]>r.mash[i1]) res += r.mash[i1-1] - r.mash[i1];
			}
		
		    int ans1 = res;
			int rate = 0;
			for(int i1=1; i1<r.mash.length; i1++){
			    rate = Math.max(rate, r.mash[i1-1] - r.mash[i1]);
			}
			
			int first = 0;
			int res1 = 0;
			for(int i2=0; i2<r.mash.length-1; i2++){
			    res1 += Math.min(rate, r.mash[i2]);
			}
		    int ans2 = res1;
		    System.out.printf("Case #%d: %d %d\n", i+1, ans1, ans2);
		}
    }
}
