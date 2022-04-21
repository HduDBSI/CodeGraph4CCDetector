package googlejam6.p198;
import java.util.*;
public class soldiers {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i<t+1; i++){
			int n = in.nextInt();
			int[] sol = new int[2501];
			for(int j = 0; j<(2*n)-1; j++){
				for(int k = 0; k<n; k++){
					int x = in.nextInt();
					sol[x] += 1;
				}
			}
			System.out.print("Case #"+i+": ");
			for(int j = 0; j<2501; j++){
				if(sol[j]%2 != 0){
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}
}
