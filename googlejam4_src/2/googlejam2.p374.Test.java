package googlejam2.p374;
import java.util.Scanner;

/**
 * @author kumaryog
 *
 */
class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		int[] arr = new int[1000001];
		for (int j = 1, cnt = 1; j <= 1000000; ++j, ++cnt) {
			if (arr[j] > 0) {
				if (cnt < arr[j]) {
					arr[j] = cnt;
				} else {
					cnt = arr[j];
				}
				continue;
			}
			arr[j] = cnt;
			int n = j;
			int r1 = 0;
			while (n != 0) {
				r1 = r1 * 10;
				r1 = r1 + n % 10;
				n = n / 10;
			}
			int r = r1;
			if (r > j) {
				arr[r] = cnt + 1;
			}
		}

		for (int i = 0; i < t; ++i) {
			int n = input.nextInt();

			System.out.println("Case #" + (i + 1) + ": " + arr[n]);
		}

		input.close();
	}
}
