package googlejam2.p327;
import java.util.Scanner;


public class A {

	public static int N;
	public static int[] dp1 = new int[1000010];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		for(int i=0;i<=1000005;i++){
			
			if(i <= 20){
				dp1[i] = i;
				continue;
			}
			dp1[i] = -1;
		}
		
		for(int n=21;n<1000002;n++){
			
			if(n % 10 == 0){
				dp1[n] = dp1[n-1] + 1;
				continue;
			}
			
			int reverse = 0;
			int n1 = n;
			while( n1 != 0 )
		    {
		          reverse = reverse * 10;
		          reverse = reverse + n1%10;
		          n1 = n1/10;
		    }

			if(reverse < n ){
				dp1[n] = Math.min(dp1[n-1]+1, dp1[reverse]+1);
			}else{
				dp1[n] = dp1[n-1] + 1;
			}
			
		}
		
		for(int test=1;test<=testCases;test++){
			
			N = sc.nextInt();
			
			System.out.println("Case #"+test+": "+dp1[N]);
		}

	}

/*	public static int dp(int a){
		
		if(a == N){
			return 0;
		}
		
		if(dp1[a] == -1){
			
			int reverse = 0;
			int n = a;
			while( n != 0 )
		    {
		          reverse = reverse * 10;
		          reverse = reverse + n%10;
		          n = n/10;
		    }
			
			if(reverse <= N && reverse > a){
				dp1[a] = Math.min(dp(a+1) + 1 , dp(reverse) + 1);
			}else{
				dp1[a] = (dp(a+1) + 1);
			}
			
		}
		
		return dp1[a];
	}
*/	
}
