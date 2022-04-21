package googlejam3.p301;
import java.util.Scanner;

public class Brattleship {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int r = input.nextInt();
			int c = input.nextInt();
			int w = input.nextInt();
			
			int solution;
			if (c % w == 0)
				solution = (c/w) * r+w-1;
			else {
				solution = (c/w) * r+w;
			}
			System.out.println("Case #" + (i+1) + ": "  + solution);
		}
		input.close();
	}

}
