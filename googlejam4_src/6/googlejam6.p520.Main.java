package googlejam6.p520;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static HashSet<Integer> sSet = new HashSet<Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
		    int n = in.nextInt();
		    sSet.clear();
			int totalNumber = n * (2 * n - 1);
			for (int count = 0; count < totalNumber; count++) {
			    int current = in.nextInt();
			    if (sSet.contains(current)) {
				    sSet.remove(current);
				} else {
				    sSet.add(current);
				}
			}
			Integer[] sorted = sSet.toArray(new Integer[]{});
			Arrays.sort(sorted);
            System.out.print("Case #" + i + ":");
			for (int c : sorted) {
			    System.out.print(" ");
			    System.out.print(c);
			}
			System.out.print("\n");
        }
    }

}
