package googlejam8.p467;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class R1C2016 {

	static int parties[];
	static int total;

	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < cases; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			parties = new int[scan.nextInt()];
			total = 0;

			for (int j = 0; j < parties.length; j++) {
				parties[j] = scan.nextInt();
				total += parties[j];
			}

			while (total > 0) {
				int maxArg = 0;
				int secondMax = 0;
				for (int i1 = 0; i1 < parties.length; i1++) {
					if (parties[i1] >= parties[maxArg]) {
						secondMax = maxArg;
						maxArg = i1;
					} else if (parties[i1] >= parties[secondMax]) {
						secondMax = i1;
					}
				}
			
				if (total == 3) {
					System.out.print((char) (65 + maxArg) + " ");
			
					parties[maxArg]--;
					total--;
				} else if (secondMax != maxArg && (parties[maxArg] - 1) <= ((total - 2) / 2)) {
					System.out.print((char) (65 + maxArg) + "" + (char) (65 + secondMax) + " ");
			
					parties[maxArg]--;
					parties[secondMax]--;
					total -= 2;
				} else if (parties[maxArg] - 2 <= ((total - 2) / 2)) {
					System.out.print((char) (65 + maxArg) + "" + (char) (65 + maxArg) + " ");
			
					parties[maxArg] -= 2;
					total -= 2;
				} else if ((parties[maxArg] - 1) <= ((total - 1) / 2)) {
					System.out.print((char) (65 + maxArg) + " ");
			
					parties[maxArg]--;
					total--;
				}
			}
			System.out.println();
		}

		scan.close();
	}
}
