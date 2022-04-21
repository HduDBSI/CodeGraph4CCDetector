package googlejam6.p059;
import java.util.*;

public class b {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();


		for (int loop=1; loop<=numCases; loop++) {

			int[] freq = new int[2501];
			int n = stdin.nextInt();

			for (int i=0; i<n*(2*n-1); i++)
				freq[stdin.nextInt()]++;

			System.out.print("Case #"+loop+":");
			for (int i=1; i<2500; i++)
				if (freq[i]%2 == 1)
					System.out.print(" "+i);
			System.out.println();
		}
	}


}