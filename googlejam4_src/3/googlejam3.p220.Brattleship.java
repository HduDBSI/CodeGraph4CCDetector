package googlejam3.p220;
import java.util.Scanner;

public class Brattleship {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t=0; t<T; t++) {
			int R = scan.nextInt();
			int C = scan.nextInt();
			int W = scan.nextInt();
			int result = C / W * R + (W - 1);
			if (C % W > 0) {
				result++;
			}
			System.out.println("Case #"+(t+1)+": "+result);
		}
	}
}