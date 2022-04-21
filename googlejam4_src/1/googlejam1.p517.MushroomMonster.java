package googlejam1.p517;
import java.util.Scanner;

public class MushroomMonster
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			int r1 = 0, r2 = 0, maxd = 0;
			for (int i = 0; i + 1 < n; i++)
				r1 += Math.max(0, a[i] - a[i + 1]);
			for (int i = 0; i + 1 < n; i++)
				maxd = Math.max(maxd, a[i] - a[i + 1]);
			for (int i = 0; i + 1 < n; i++)
				r2 += Math.min(a[i], maxd);
			System.out.printf("Case #%d: %d %d\n", tc, r1, r2);
		}
	}
}
