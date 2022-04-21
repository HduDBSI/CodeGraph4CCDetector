package googlejam1.p577;
import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int caseCount = input.nextInt();

		for (int caseNo = 1; caseNo <= caseCount; caseNo++) {
			int N = input.nextInt();
			int cs1 = 0;
			int cr2 = 0;
			int cs2 = 0;
			int ary[] = new int[1000];

			int prev = input.nextInt();
			ary[0] = prev;

			for (int i = 1; i < N; i++) {
				int nw = input.nextInt();
				ary[i] = nw;
				// System.out.println("nw " + nw);
				if (prev > nw) {
					cs1 = cs1 + (prev - nw);
					if (cr2 < (prev - nw)) {
						cr2 = (prev - nw);
					}
				}
				prev = nw;
				// System.out.println("cs1 " + cs1);
			}

			for (int j = 0; j < N - 1; j++) {
				if (ary[j] > cr2) {
					cs2 = cs2 + cr2;
				} else {
					cs2 = cs2 + ary[j];
				}
			}

			System.out.println("Case #" + caseNo + ": " + cs1 + " " + cs2);
		}
	}
}
