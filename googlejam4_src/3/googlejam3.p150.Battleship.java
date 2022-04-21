package googlejam3.p150;
import java.util.Scanner;


public class Battleship {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; t++) {
			int R = scan.nextInt();
			int C = scan.nextInt();
			int W = scan.nextInt();
			System.out.println("Case #" + t + ": " + (R*(C/W) + W-1 + (C%W==0?0:1)));
		}
	}
}
