package googlejam2.p301;
import java.util.Scanner;


public class Problem1 {


	public static void main(String[] args) {
		
		int maxN = 1000000;
		int[] minCount = new int[maxN+1]; // minCount[i] is for counting from 1 to i
		minCount[1] = 1;
		
		int reverseN;
		for(int N=2; N<maxN+1; N++){
			int input = N;
			int reversedNum = 0;
			while (input != 0) {
			    reversedNum = reversedNum * 10 + input % 10;
			    input = input / 10;   
			}
			reverseN = reversedNum;
			if((N%10 != 0) && reverseN<N){
				minCount[N] = Math.min(1+minCount[N-1], 1+minCount[reverseN]);
			} else {
				minCount[N] = 1+minCount[N-1];
			}
		}
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		
		for(int caseNb=0; caseNb<T; caseNb++){
			int N = scan.nextInt();
			scan.nextLine();
			System.out.println("Case #"+(caseNb+1)+": "+minCount[N]);
		}
	}

}
