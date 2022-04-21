package googlejam3.p451;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		int T = 0;
		try {
			Scanner scan = new Scanner(new File("A-small-attempt0.in"));
			T = scan.nextInt();
			scan.nextLine();
			//System.out.println("Number of test cases is " + T);
			for(int i = 0; i < T; i++) {
				int R, C, W;
				R = scan.nextInt();
				C = scan.nextInt();
				W = scan.nextInt();
				
				int answer = 0;
				
				for(int j = 0; j < R; j++) {
					for(int k = 0; k < C; k += W) {
						answer ++;
					}
				}
				answer += (W - 1);
				System.out.println("Case #" + (i+1) + ": " + answer);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
