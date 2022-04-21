package googlejam6.p427;
/* Filename: GCJ2016R1A_B.java
 * Author: Mushiyo
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GCJ2016R1A_B {
	public static void main(String[] args) throws FileNotFoundException {
//		 Scanner input = new Scanner(System.in);
//		 PrintWriter out = new PrintWriter(System.out);
		 Scanner input = new Scanner(new File("B-large.in"));
		 PrintWriter out = new PrintWriter(new File("pB.out"));

		while (input.hasNext()) {
			int T = input.nextInt();

			for (int t = 1; t <= T; ++t) {
				int N = input.nextInt();
				int lineNum = 2 * N - 1;
				int[] countHeight = new int[2500+1];
				
				for(int i = 0; i < lineNum; ++i){
					for(int j = 0; j < N; ++j){
						++countHeight[input.nextInt()];
					}
				}
				
				out.printf("Case #%d: ", t);
				boolean isFirstNum = true;
				for(int i = 0; i < countHeight.length; ++i){
					if(countHeight[i] % 2 == 1){
						if(isFirstNum){
							out.print(i);
							isFirstNum = false;
						} else {
							out.printf(" %d", i);
						}
					}
				}
				out.println();
			}
		}

		out.close();
		input.close();
	}
}
