package googlejam6.p553;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class soldier{

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int count = in.nextInt();

		for (int k = 0; k < count; k++) {

		int sideSize = in.nextInt();
		int[] side = new int[sideSize * (2 * sideSize - 1)];
		ArrayList<Integer> sideToSort = new ArrayList<>();

			for (int i = 0; i < side.length; i++) {
				side[i] = in.nextInt();
			}

			for (int i = 0; i < side.length; i++) {
				int counter = 1;

				for (int j = 0; j < side.length; j++) {
					if (i != j && side[i] == side[j]) {
						counter++;
					}
				}

				if (counter % 2 != 0 && !sideToSort.contains(side[i])) {
					sideToSort.add(side[i]);
				}
				if (sideToSort.size() == sideSize) {
					break;
				}
			}

			Collections.sort(sideToSort);

				System.out.print("Case #" + (k + 1) +": ");
				for (int j = 0; j < sideToSort.size(); j++) {
					System.out.print(sideToSort.get(j) + " ");
				}
				System.out.println();
		}
	}

}
