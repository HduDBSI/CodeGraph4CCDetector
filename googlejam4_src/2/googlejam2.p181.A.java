package googlejam2.p181;
import java.util.Arrays;
import java.util.Scanner;


public class A {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++)
		{
			int N = in.nextInt();
			int[] min = new int[MAX];
			Arrays.fill(min, MAX+1);
			
			min[1] = 1;
			
			for (int cur = 1; cur <= N; cur++)
			{
				// The next is the minimum of this + 1 or its value
				min[cur + 1] = Math.min(min[cur + 1], min[cur] + 1);
				int num = cur;
				int ans1 = 0;
				while (num > 0) {
					ans1 *= 10;
					ans1 += (num % 10);
					num /= 10;
				}
			
				int reverse = ans1;
				min[reverse] = Math.min(min[reverse], min[cur] + 1);
			}
			int ans = min[N];
			System.out.printf("Case #%d: %d\n", i+1, ans);
		}

	}
	
	static int MAX = 1000005;

}
