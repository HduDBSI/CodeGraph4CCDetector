package googlejam1.p573;
import java.util.Scanner;


public class MushroomMonster {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int zz = 1; zz <= T;zz++){

			int N = in.nextInt();
			
			int[] marr = new int[N]; 
			for (int i = 0; i < N; i++) {
				marr[i] = in.nextInt();
			}
			
			int m1 = 0;
			int m2 = 0;
			
			int prev = 0;
			int minRate = 0;
			for (int i =0; i < N; i++){
				if (prev > marr[i]) {
					m1 += (prev - marr[i]);
					
					if ((prev - marr[i]) > minRate) {
						minRate = prev - marr[i];
					}					
				}
				prev = marr[i];
			}
			
//			System.out.println("minRate: " + minRate);
			
			for (int i =0; i < N - 1; i++){				
				m2+= (marr[i]>minRate)? minRate : marr[i];				
			}
			
			
			
			System.out.format("Case #%d: %d %d\n", zz, m1, m2);
		}		
	}
}
