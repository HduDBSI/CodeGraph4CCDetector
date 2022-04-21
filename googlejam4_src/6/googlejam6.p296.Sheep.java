package googlejam6.p296;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sheep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int T = Integer.parseInt(sc.nextLine());
		for (int caseCount = 1; caseCount <= T; caseCount++) {
			System.out.print("Case #" + caseCount + ":");
			final int N = sc.nextInt();
			int[] arr = new int[2501];
			for (int i = 0; i < 2*N*N - N; i++) {
				arr[sc.nextInt()]++;
			}
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 != 0) {
					al.add(i);
				}
			}
			Collections.sort(al);
			for (int i = 0; i < al.size(); i++) {
				System.out.print(" " + al.get(i));
			}
			System.out.println();
		}
	}
}
