package googlejam3.p387;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProblemA {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("A-small-attempt0.in"));
		Scanner sc = new Scanner(new File("A-large.in"));
//		Scanner sc = new Scanner(new File("A.in"));
		int cases = sc.nextInt();
		int count = 1;

		while(cases --> 0) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			int turns = 0;
			
			if ( W == 1) {
				turns = R * C;
			} else {
			
				for (int i = W-1; i < C; i += W) {
					turns += R;
				}
				
				turns += W - 1;
				
				if(C % W != 0) {
					turns++;
				}
				
			}
			
			System.out.println("Case #" + count + ": " + turns);
			
			count++;
		}
		
		sc.close();
	}
}