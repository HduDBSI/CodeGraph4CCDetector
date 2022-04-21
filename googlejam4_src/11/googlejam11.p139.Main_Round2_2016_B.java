package googlejam11.p139;
import java.util.*;


public class Main_Round2_2016_B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int casei = 1; casei <= t; casei++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			double[] p = new double[n];
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextDouble();
			}

			double max = 0;
			for (int i = 0; i < 0x1 << n; i++) {
				if (Integer.bitCount(i) != k) {
					continue;
				}

				List<Double> pp = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					if ((i & 0x1 << j) != 0) {
						pp.add(p[j]);
					}
				}

				double tmp2 = 0;
				for (int j = 0; j < 0x1 << k; j++) {
					if (Integer.bitCount(j) != k / 2) {
						continue;
					}

					double tmp = 1;
					for (int l = 0; l < k; l++) {
						if ((j & 0x1 << l) == 0) {
							tmp *= (1 - pp.get(l));
						} else {
							tmp *= pp.get(l);
						}
					}
					tmp2 += tmp;
				}
				max = Math.max(max, tmp2);
			}

			System.out.printf("Case #%d: %.7f\n", casei, max);
		}

		sc.close();
	}
}
