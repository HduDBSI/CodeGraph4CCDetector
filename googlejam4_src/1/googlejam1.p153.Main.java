package googlejam1.p153;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int z, N, i, j, k;
		int num[] = new int[1000];
		int answ1, answ2, max, min;
		boolean found;
		for(z = 1; z <= T; z++){
			N = in.nextInt();
			answ1 = answ2 = max = min = 0;
			for(i = 0; i < N; i++){
				num[i] = in.nextInt();
				if(i > 0 && num[i-1] > num[i])
					min = Math.max(min, num[i-1] - num[i]);
				max = Math.max(max, num[i]);
			}
			
			for(i = 1; i < N; i++)
				if(num[i - 1] > num[i])
					answ1 += num[i - 1] - num[i]; 
			
			for(k = min; k <= max; k++){
				found = true;
				answ2 = Math.min(num[0], k);
				for(i = 1; i < N; i++){
					if(num[i - 1] - k > num[i]){
						found = false;
						break;
					}
					if(i != N - 1)
						answ2 += Math.min(k, num[i]); 
				}
				if(found)
					break;
				
			}
			
			System.out.println("Case #" + z + ": " + answ1 + " " + answ2);
		}
	}
}
