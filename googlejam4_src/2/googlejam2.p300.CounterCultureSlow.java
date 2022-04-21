package googlejam2.p300;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CounterCultureSlow {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int cases;
		int[] distances1 = new int[1000000 + 1];
		Queue<Integer> ordering = new LinkedList<Integer>();
		ordering.add(0);
		while (!ordering.isEmpty())
		{
			int n1 = ordering.remove();
			if (n1 + 1 <= 1000000 && distances1[n1 + 1] == 0)
			{
				distances1[n1 + 1] = distances1[n1] + 1;
				ordering.add(n1 + 1);
			}
			char[] digits = String.valueOf(n1).toCharArray();
			int val = 0;
			for (int k = digits.length - 1; k >= 0; k--)
				val = 10 * val + digits[k] - '0';
			
			int nr = val;
			if (nr <= 1000000 && distances1[nr] == 0)
			{
				distances1[nr] = distances1[n1] + 1;
				ordering.add(nr);
			}
		}
		
		// Precompute solutions
		// This only works for the small cases, but I want it for testing.
		int[] distances = distances1;
		
		cases = input.nextInt();
		for (int c = 1; c <= cases; c++)
		{
			int n = input.nextInt();
			System.out.printf("Case #%d: %d\n", c, distances[n]);
		}
	}

}
