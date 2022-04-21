package googlejam3.p108;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int caseNum = 1;  caseNum <= t; caseNum++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();

			int tries;
			if (c % w == 0) {
				tries = (r * (c / w)) + (w - 1);
			}
			else {
				tries = (r * (c / w)) + w;
			}
			System.out.printf("Case #%d: %d\n", caseNum, tries);
		}
	}
}
