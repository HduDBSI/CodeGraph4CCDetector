package googlejam1.p784;
import java.util.*;

public class A {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		for (int i = 0; i < t; i++) {
			int n = input.nextInt();
			int m[] = new int[n];

			for (int j = 0; j < n; j++) {
				m[j] = input.nextInt();
			}

			int case1 = 0;

			for (int j = 1; j < n; j++) {
				if (m[j - 1] > m[j]) {
					case1 += m[j - 1] - m[j];
				}
			}

			int case2 = 0;

			double difference = -1;

			for (int j = 0; j < n - 1; j++) {
				if (m[j] >= m[j + 1]) {
					if (m[j] - m[j + 1] > difference) {
						difference = m[j] - m[j + 1];
					}
				}
			}

			double time = difference / 10;

			for (int j = 0; j < n - 1; j++) {
				double amountToEat = 10 * time;
				if (m[j] != 0) {
					if (amountToEat >= m[j]) {
						case2 += m[j];
					} else {
						case2 += amountToEat;
					}
				}
			}

			System.out.println("Case #"+(i+1)+": "+case1 + " " + case2);
			case1 = 0;
			case2 = 0;
		}

	}

}
