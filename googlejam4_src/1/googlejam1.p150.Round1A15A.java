package googlejam1.p150;
import java.util.Scanner;

public class Round1A15A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nCases = scanner.nextInt();
		for(int z = 0; z < nCases; z++)
		{
			int nPeeks = scanner.nextInt();
			int total = 0;
			double maxRate = 0;
			int[] counts = new int[nPeeks];
			int prev = scanner.nextInt();
			counts[0] = prev;
			for(int i = 1; i < nPeeks; i++)
			{
				int cur = scanner.nextInt();
				if(prev > cur)
				{
					int diff = prev - cur;
					total += diff;
					maxRate = Math.max(maxRate, diff / 10d);
				}
				
				counts[i] = cur;
				prev = cur;
			}
			int total1 = 0;
			for(int i = 1; i < nPeeks; i++)
			{
				total1 += Math.min(Math.ceil(maxRate * 10), counts[i - 1]);
			}
			System.out.println("Case #" + (z+1) + ": " + total + " " + total1);
		}
		scanner.close();
	}

}
