package googlejam1.p671;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A
{
	public static void main(String[] args) throws IOException
	{
		String FILE = "files/A-large";
		BufferedReader in = new BufferedReader(new FileReader(FILE + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter
				(new FileWriter(FILE + ".out")));

		StringTokenizer st;
		int testCases = Integer.parseInt(in.readLine());
		for (int test = 1; test <= testCases; test++)
		{
			int N = Integer.parseInt(in.readLine());
			int[] m = new int[N];

			st = new StringTokenizer(in.readLine());
			m[0] = Integer.parseInt(st.nextToken());
			long x = 0, y = 0;

			int jump = 0;

			int current = m[0];
			for (int i = 1; i < N; i++)
			{
				m[i] = Integer.parseInt(st.nextToken());
				if (m[i] < current)
				{
					y += current - m[i];

					int diff = current - m[i];
					if (diff > jump)
						jump = diff;
				}
				current = m[i];
			}

			for (int i = 0; i < N - 1; i++)
				if (m[i] < jump)
					x += m[i];
				else
					x += jump;

			out.printf("Case #%d: %d %d%n", test, y, x);
		}

		in.close();
		out.close();
	}
}
