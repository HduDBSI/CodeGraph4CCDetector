package googlejam1.p357;
/* Filename: A.java
 * Author: Mushiyo
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner input = new Scanner(System.in);
		Scanner input = new Scanner(new File("A-large.in"));
		PrintWriter out = new PrintWriter(new File("A.out"));

		while (input.hasNext()) {
			int T = input.nextInt();

			for (int caseNum = 1; caseNum <= T; ++caseNum) {
				int N = input.nextInt();
				int[] mushroom = new int[N];

				for (int i = 0; i < mushroom.length; ++i) {
					mushroom[i] = input.nextInt();
				}

				int method1 = 0;
				int rate = 0;

				for (int i = 1; i < mushroom.length; ++i) {
					if (mushroom[i] < mushroom[i - 1]) {
						method1 += mushroom[i - 1] - mushroom[i];
						rate = Math.max(rate, mushroom[i - 1] - mushroom[i]);
					}
				}

				int method2 = 0;
				for (int i = 0; i < mushroom.length - 1; ++i) {

					if (mushroom[i] <= rate) {
						method2 += mushroom[i];
					} else {
						method2 += rate;
					}
				}

				//out.printf("rate: %d\n", rate);
				out.printf("Case #%d: %d %d\n", caseNum, method1, method2);
			}
		}

		input.close();
		out.close();
	}

}
