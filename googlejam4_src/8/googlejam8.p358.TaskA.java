package googlejam8.p358;
import java.util.HashSet;
import java.util.Scanner;

public class TaskA {
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		int numOfCases = in.nextInt();
		for(int i = 0 ; i < numOfCases; i++){
			int n = in.nextInt();
			int[] partyNum = new int[n];
			System.out.print("Case #" + (i+1) + ": ");
			
			int k =0;
			for(int j = 0 ;j  < n ; j++){
				partyNum[j] = in.nextInt();
				k+= partyNum[j];
			}
			int max = 0;
			while( max != 1){
				max = 0;
				int maxIdx1 = -1;
				int maxIdx2 = -1;
				for(int j = 0; j < n ; j++){
					if(partyNum[j] == max && max != 0){
						maxIdx2 = j;
					}
					if(partyNum[j] > max){
						maxIdx2 = -1;
						max = partyNum[j];
						maxIdx1 = j;
					}
					
				}
				if(max != 1) {
					partyNum[maxIdx1]--;
					if(maxIdx2 != -1){
						partyNum[maxIdx2]--;
						System.out.print((char)(65 + maxIdx2));
					}
					System.out.print((char)(65 + maxIdx1) + " ");
				}
			}
			int cnt = 3;
			while(cnt > 2){
				cnt = 0;
				for(int j = 0; j < n ; j++){
					if(partyNum[j] == 1) cnt++; 
				}
				if(cnt > 2){
					for(int j = 0 ; j < n; j++){
						if(partyNum[j] == 1) {
							System.out.print((char)(65 + j) + " ");
							partyNum[j]--;
							break;
						}
					}
				}
			}
			for(int j = 0; j < n ; j++){
				if(partyNum[j] == 1) {
					System.out.print((char)(65 + j));
				}
			}
			System.out.println();
			

		}

	}
}
