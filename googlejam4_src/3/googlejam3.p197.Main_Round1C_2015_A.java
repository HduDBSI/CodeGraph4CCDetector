package googlejam3.p197;
import java.util.Scanner;


public class Main_Round1C_2015_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int casei = 1; casei <= t; casei++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();

			int ret = c / w * r + w - 1 + (c % w != 0 ? 1 : 0);

			System.out.printf("Case #%d: %d\n", casei, ret);
		}

		sc.close();
	}
}
