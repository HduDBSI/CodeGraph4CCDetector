package googlejam1.p801;
import java.util.Scanner;


public class AMush {

	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=0; t<T; t++){
			int n = sc.nextInt();
			int[] data = new int[n];
			for (int i=0; i<n; i++){
				data[i] = sc.nextInt();
			}
			int n1 = data.length;
			int sum1 = 0;
			int sum2 = 0;
			int rate = 0;
			for (int i=1; i<n1; i++){
				int dm = data[i-1] - data[i];
				if (dm > 0){
					sum1 += dm;
					rate = (rate < dm) ? dm : rate;
				}			
			}
			
			for (int i=0; i<n1-1; i++){
				int dm = (data[i] < rate) ? data[i] : rate;
				sum2 += dm;
			}
			System.out.println("Case #"+(t+1)+": "+sum1+" "+sum2);
		}
		
	}
}
