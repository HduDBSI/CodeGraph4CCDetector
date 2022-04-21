package googlejam6.p237;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B
{
	static String FILE_IN = "B-large.in";
	static String FILE_OUT = "B.out";

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader
				(new FileReader("files/" + FILE_IN));
		PrintWriter out = new PrintWriter(new BufferedWriter
				(new FileWriter("files/" + FILE_OUT)));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++)
		{
			int N = Integer.parseInt(in.readLine());
			int lines = 2 * N - 1;
			
			ArrayList<Integer> set = new ArrayList<Integer>();
			StringTokenizer st;
			
			for(int i = 1; i <= lines; i++)
			{
				st = new StringTokenizer(in.readLine());
				int next, index;
				
				for(int j = 1; j <= N; j++)
				{
					next = Integer.parseInt(st.nextToken());
					
					index = set.indexOf(next);
					if(index >= 0)
						set.remove(index);
					else
						set.add(next);
				}
			}
			
			Collections.sort(set);
			StringBuilder res = new StringBuilder(Integer.toString(set.get(0)));
			
			int length = set.size();
			for(int i = 1; i < length; i++)
				res.append(" ").append(set.get(i));
			String result = res.toString();
			System.out.printf("Case #%d: %s%n", t, result);
			out.printf("Case #%d: %s%n", t, result);
		}

		System.out.println("Complete");
		in.close();
		out.close();
	}
}
