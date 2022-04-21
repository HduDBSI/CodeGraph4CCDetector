package googlejam6.p223;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int x = 1; x <= t; ++x){
			int n = scanner.nextInt();
			boolean[] soldiers = new boolean[2500];
			for(int i = 0; i < 2 * n - 1; ++i){
				for(int j = 0; j < n; ++j){
					int s = scanner.nextInt();
					soldiers[s-1] = !soldiers[s-1];
				}
			}
			int count = 0;
			System.out.print("Case #" + x + ": ");
			for(int i = 1; i <= 2500; ++i){
				if(soldiers[i-1]){
					++count;
					if(count < n){
						System.out.print(i + " ");
					}
					else{
						System.out.println(i);
					}
				}
				
			}
		}
	}
}
