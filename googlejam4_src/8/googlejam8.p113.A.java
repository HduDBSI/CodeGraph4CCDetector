package googlejam8.p113;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A
{

	public static void main(String[] args) throws Exception
	{
		out = new PrintWriter(new FileWriter("outA.txt"));
		int testCases = Integer.parseInt(next());
		for (int r = 1; r <= testCases; r++)
		{
			int n = Integer.parseInt(next());
			int[] p = new int[n];

			int t = 0;
			for (int i = 0; i < n; i++)
			{
				p[i] = Integer.parseInt(next());
				t += p[i];
			}

			out.printf("Case #%d: ", r);

			if (t % 2 == 1)
			{
				int max = 0;
				for (int i = 1; i < n; i++)
					if (p[i] > p[max])
						max = i;
				p[max]--;
				t--;
				out.print((char) (max + 'A') + " ");
			}

			while (t > 0)
			{
				int max = 0;
				int max2 = -1;
				for (int i = 1; i < n; i++)
					if (p[i] > p[max])
						max = i;
					else if (p[i] == p[max])
						max2 = i;

				if (max2 != -1)
				{
					out.print((char) (max + 'A') + ""
							+ (char) (max2 + 'A')
							+ " ");
					p[max]--;
					p[max2]--;
					t -= 2;
				}
				else
				{
					if (p[max] == 1)
					{
						out.print((char) (max + 'A') + " ");
						p[max]--;
						t--;
					}
					else
					{
						out.print((char) (max + 'A') + ""
								+ (char) (max + 'A') + " ");
						p[max] -= 2;
						t -= 2;
					}
				}
			}

			out.println();
		}
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out = new PrintWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static String next() throws IOException
	{
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

}
