package googlejam1.p411;

import java.util.Scanner;
public class MushroomMonster {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for(int i=1; i<=numCases; i++){
			case1 = 0;
			case2 = 0;
			maxDiff = 0;
			int n = input.nextInt();
			int[] arr = new int[n];
			for(int i1=0; i1<n; i1++){
				arr[i1] = input.nextInt();
			}
			// Case 1
			for(int k=0; k<(n-1); k++){
				int current = arr[k];
				int next = arr[k+1];
				maxDiff = Math.max(maxDiff,  current - next);
				if(current > next){
					case1 += current - next;
				}
			}
			// Case 2
			for(int k=0; k<(n-1); k++){
				int current = arr[k];
				if(current >= maxDiff){
					case2 += maxDiff;
				}
				else{
					case2 += current;
				}
			}
			System.out.printf("Case #%d: %d %d", i, case1, case2);
			if(i!=numCases)
				System.out.println();
		}
 
	}
 
 
	public static int case1;
	public static int case2;
	public static int maxDiff;
 
 
}