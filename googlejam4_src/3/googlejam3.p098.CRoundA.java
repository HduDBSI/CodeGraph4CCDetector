package googlejam3.p098;
import java.util.Scanner;

public class CRoundA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int R = in.nextInt();
			int C = in.nextInt();
			int size = in.nextInt();
			
			int costPerRow = C / size;
			
			int ans1 = 0;
			
			// Need to iterate through all rows to first "hit" the ship
			ans1 += costPerRow * R;
			
			// Now that we've hit the ship, we need to hit the rest of it.
			
			// If it divides it evenly, it's jsut the cost of the rest of the ship.
			if (C % size == 0) {
				ans1 += (size - 1);
			}
			// Alternatively, he can guarantee at least one "miss"
			else {
				ans1 += size;
			}
			int ans = ans1;
			System.out.printf("Case #%d: %d\n", i + 1, ans);
		}

	}

}
