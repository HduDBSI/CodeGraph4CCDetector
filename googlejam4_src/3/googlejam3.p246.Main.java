package googlejam3.p246;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int row = sc.nextInt();
			int column = sc.nextInt();
			int width = sc.nextInt();

			int ans = 0;
			ans += (column / width) * row;

			ans += (width - 1);
			if (column % width != 0) {
				ans++;
			}
			System.out.println("Case #" + (t + 1) + ": " + ans);

		}
		sc.close();

	}
}