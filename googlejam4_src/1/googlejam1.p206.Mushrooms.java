package googlejam1.p206;
import java.util.Scanner;


public class Mushrooms 
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for (int i=0;i<t;++i)
		{
			int n = sc.nextInt();
			int []m = new int[n];
			for (int j=0;j<n;++j)
				m[j] = sc.nextInt();
			int first = 0;
			long second = 0;
			long maxEaten = Integer.MIN_VALUE;
			for (int j=1;j<n;++j)
			{
				if (m[j-1]-m[j] > maxEaten)
					maxEaten = m[j-1] - m[j];
				if (m[j] < m[j-1])
				{
					first += m[j-1] - m[j];
				}
			}
			for (int j=0;j<n-1;++j)
			{
				if (m[j] > maxEaten)
					second += maxEaten;
				else second += m[j];
			}
			System.out.println("Case #"+(i+1)+": "+first+" "+second);
		}
	}
}
