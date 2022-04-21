package googlejam8.p729;
import java.util.*;
class q1
{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int t=T;
		
		while(T-- > 0) {
			String ans = "";
			int  N =  in.nextInt();
			int ar[] = new int[N];
			char arr[] = new char[N];
			int sum = 0;

			for(int i = 0 ; i < N; i++) {
				ar[i] =  in.nextInt();
				sum = sum + ar[i];
				arr[i] =   (char)('A' + i);
			}
			while(sum != 0) {
			//	Arrays.sort(ar);
				int max = 0;
				int index= 0;
				for(int i = 0 ; i < N; i++) {
					if(ar[i] > max) {
						max=ar[i];
						index = i;
					}
				}
			
				int sec_max = 0;
				int sec_index= 0;
				ar[index] = -1;
				for(int i = 0 ; i < N; i++) {
					if(ar[i] > sec_max ) {
						sec_max=ar[i];
						sec_index = i;
					}
				}
				ar[index] = max;
			
						
				 if(ar[index] > 2 && ar[index] != ar[sec_index]) {
					ar[index] -= 2;	// print arr[index]x2
					sum -= 2;
					ans = ans + arr[index] + arr[index]  + ' ';
				}
				else if(ar[index] > 0 ){ 
					if(sum % 2 == 0) {		// print arr[index] arr[sec_index]
						ar[index]--;
						ar[sec_index]--;
						sum -= 2;
						ans = ans + arr[index] + arr[sec_index]  + ' ';
					}
					else {
						ar[index]--;			//print arr[index]
						sum -= 1;
						ans = ans + arr[index] + ' ';
					}
				}
				
			}		
			System.out.println("Case #"+(t-(T))+": "+ans);
			
		
		}
	}
}



