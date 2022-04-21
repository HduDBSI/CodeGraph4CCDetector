package googlejam1.p605;


import java.util.Scanner;

public class A {

	public static void main(String[] args) {

		A a = new A();

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();
			int[] mushrooms = new int[N];

			for (int i = 0; i < N; i++) {
				mushrooms[i] = sc.nextInt();
			}
			int ret = 0;
			for (int i = 1; i < N; i++) {
				int diff = Math.max(0, mushrooms[i - 1] - mushrooms[i]);
				ret += diff;
			}

			String y = Integer.toString(ret);
			int rate = 0;
			for (int i = 1; i < N; i++) {
				rate = Math.max(rate, mushrooms[i - 1] - mushrooms[i]);
			}
			
			int ret1 = 0;
			for (int i = 0; i < N - 1; i++) {
				int diff = Math.min(rate, mushrooms[i]);
				ret1 += diff;
			}
			String z = Integer.toString(ret1);
			System.out.format("Case #%d: %s %s", t + 1, y, z);
			System.out.println();
		}

		sc.close();

	}
}