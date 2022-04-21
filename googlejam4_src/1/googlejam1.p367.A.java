package googlejam1.p367;
import java.io.*;
import java.util.Scanner;

public class A
{

	static int N;

	public static void main(String[] args) throws IOException
	{
		String fileName = "A-large";
		Scanner in = new Scanner(new File(fileName + ".in"));
		PrintWriter out = new PrintWriter(new FileWriter(fileName + ".out"));

		int noOfCases = in.nextInt();
		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			N = in.nextInt();
			int[] mushrooms = new int[N];
			for (int i = 0; i < N; i++)
				mushrooms[i] = in.nextInt();

			int first = 0;
			int second = 0;

			int rate = 0;

			for (int i = 1; i < N; i++)
			{
				int diff = mushrooms[i-1] - mushrooms[i];
				if (diff > 0)
				{
					rate = Math.max(rate, diff);
					first += diff;
				}

			}
			for (int i = 0; i < N - 1; i++)
			{
				second += Math.min(rate, mushrooms[i]);
			}

			System.out.printf("Case #%d: %d %d%n", caseNo, first, second);
			out.printf("Case #%d: %d %d%n", caseNo, first, second);
		}
		in.close();
		out.close();

	}

}
