package googlejam1.p267;
import java.util.*;

public class A
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int test = 1; test <= t; ++test)
		{
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; ++i)
				arr[i] = in.nextInt();
			
			long totalWithChoice = 0;
			for (int i = 1; i < arr.length; ++i)
			{
				if (arr[i] < arr[i-1])
					totalWithChoice += arr[i-1] - arr[i];
			}
			
			long totalWithConstant = 0;
			int maxChange = 0;
			for (int i = 1; i < arr.length; ++i)
				maxChange = Math.max(maxChange, arr[i-1] - arr[i]);
			
			for (int i = 0; i < arr.length - 1; ++i)
			{
				totalWithConstant += Math.min(arr[i], maxChange);
			}
			
			System.out.printf("Case #%d: %d %d\n", test, totalWithChoice, totalWithConstant);
		}
	}
}