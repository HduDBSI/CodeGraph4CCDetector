package googlejam1.p230;
import java.util.*;

public class GC1AA_15{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int ca = 1; ca <= T; ca++){
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i = 0; i < N ; i++)
				arr[i] = sc.nextInt();

			int a = 0;
			int b = 0;

			int max = 0;
			for(int i = 0; i < N-1; i++){
				if(arr[i] > arr[i+1]){
					a += arr[i] - arr[i+1];
					max = Math.max(max,arr[i] - arr[i+1]);
				}
			}

			for(int i = 0; i < N-1; i++)
				b += Math.min(max,arr[i]);
			System.out.printf("Case #%d: %d %d\n",ca,a,b);
		}
	}
}