package googlejam3.p313;
import java.util.Scanner;

public class A {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int R, C, W;
		for (int I = 1; I <= T; I++) {
			R = in.nextInt();
			C = in.nextInt();
			W = in.nextInt();
			if (C % W == 0) {
				System.out.println("Case #" + I + ": " + (R * (C / W) + W - 1));
			} else {
				System.out.println("Case #" + I + ": " + (R * (C / W) + W));
			}
		}
	}
}