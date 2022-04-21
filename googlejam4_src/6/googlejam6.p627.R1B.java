package googlejam6.p627;
import java.util.Scanner;

public class R1B {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int N = sc.nextInt();
			int[] counts = new int[2501];
			for(int i=0;i<N*(2*N-1);i++){
				counts[sc.nextInt()]++;
			}
			System.out.print("Case #"+t+":");
			for(int i=0;i<2501;i++){
				if(counts[i]%2==1){
					System.out.print(" "+i);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}