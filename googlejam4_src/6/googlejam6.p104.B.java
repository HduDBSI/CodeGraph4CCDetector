package googlejam6.p104;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B
{
	public static void main(String[] args) throws Exception
	{
		out = new PrintWriter(new FileWriter("out.txt"));
		int t = Integer.parseInt(next());
		for (int r = 1; r <= t; r++)
		{
			int n = Integer.parseInt(next());
			int[] heights = new int[2501];
			for (int i = 0; i < 2 * n - 1; i++)
				for (int j = 0; j < n; j++)
					heights[Integer.parseInt(next())]++;
			
			ArrayList<Integer> missing = new ArrayList<Integer>();
			for (int i = 1; i <= 2500; i++)
				if (heights[i] % 2 != 0)
					missing.add(i);
			Collections.sort(missing);
			
			String ans = "";
			for (int num : missing)
				ans += num + " ";
			ans = ans.trim();
			out.printf("Case #%d: %s\n", r, ans);
		}
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out;
	static StringTokenizer st;

	static String next() throws IOException
	{
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
