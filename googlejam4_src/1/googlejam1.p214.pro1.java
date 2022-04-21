package googlejam1.p214;
import java.util.Scanner;

public class pro1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T= scanner.nextInt();

		for( int t=0; t<T; t++){
			int N = scanner.nextInt();
			
			int[] num = new int[N];
			int[] subt = new int[N-1];
			num[0] = scanner.nextInt();
			int max = 0;
			for( int i=0; i<N-1; i++){
				num[i+1] = scanner.nextInt();
				subt[i] = num[i] - num[i+1];
				max = Math.max(subt[i], max);
			}

			int ans1 = 0;
			for( int i=0; i<N-1;i++){
				if( subt[i] > 0){
					ans1 += subt[i];
				}
			}
			
			int ans2 = 0;
			for( int i=0; i<N-1;i++){
				if( num[i] < max){
					ans2 += num[i];
				}
				else{
					ans2 += max;
				}
			}
			

			System.out.println("Case #"+(t+1)+": "+ans1+" "+ans2);			
			
		}
	}
}
