package googlejam6.p549;
import java.util.Scanner;

public class TaskB {
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		int numOfCases = in.nextInt();
		for(int i = 0 ; i < numOfCases; i++){
			int n = in.nextInt();
			int[] res = new int[n];
			int lists[][] = new int[2*n-1][n];
			int[] nums = new int[2501];
			for(int j = 0 ; j < 2*n-1;j++){
				for(int k = 0 ; k < n ; k++){
					lists[j][k] = in.nextInt();
				}
			}
			for(int j = 0 ; j < 2*n-1;j++){
				for(int k = 0 ; k < n ; k++){
					nums[lists[j][k]] ++;
				}
			}
			int cnt = 0;
			for(int j = 0 ; j < nums.length;j++){
				if(nums[j]%2 != 0){
					res[cnt] = j;
					cnt++;
				}
			}
			System.out.print("Case #" + (i+1) + ": ");
			for(int j  = 0 ; j < res.length ; j++){
				System.out.print(res[j] + " ");
			}
			System.out.println();
		}
	}
}
