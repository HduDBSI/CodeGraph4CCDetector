package googlejam8.p812;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Senate
{
	private static final String PROBLEM_NAME = "Senate";
	private static final String PATH = "I:/EclipseWorkspace/CodeJam2016/src/com/devil/one_c/";
	private static PrintWriter writer;

	public static void main(String[] arg) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(PATH + PROBLEM_NAME + ".in"));
		writer = new PrintWriter(new BufferedWriter(new FileWriter(PATH + PROBLEM_NAME + ".out")));

		int testCases = Integer.parseInt(reader.readLine()); // input testcases

		for (int i = 0; i < testCases; i++)
		{
			int partyCount = Integer.parseInt(reader.readLine());
			int[][] dist = new int[partyCount][2];
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

			int count = 0;

			for (int j = 0; j < partyCount; j++)
			{
				dist[j][0] = Integer.parseInt(tokenizer.nextToken());
				dist[j][1] = j + 65; // 65 is ascii for A
				count += dist[j][0];
			}

			Arrays.sort(dist, comparator);

			// for (int j = 0; j < partyCount; j++)
			// {
			// System.out.println(dist[j][0] + " " + dist[j][1]);
			// }

			StringBuilder answer = new StringBuilder();

			while (dist[0][0] > 0)
			{
				if (dist[1][0] / ((float) (count - 1)) <= 0.5)
				{
					answer.append(((char) dist[0][1]) + " ");
					dist[0][0]--;
					count -= 1;
				}
				else
				{
					answer.append(((char) dist[0][1]) + "" + ((char) dist[1][1]) + " ");
					dist[0][0]--;
					dist[1][0]--;
					count -= 2;
				}
				Arrays.sort(dist, comparator);
			}

			answer.deleteCharAt(answer.length() - 1);
			writer.println("Case #" + (i + 1) + ": " + answer);

		}

		reader.close();
		writer.close();
	}

	private static Comparator comparator = new Comparator<int[]>()
	{

		@Override
		public int compare(int[] obj1, int[] obj2)
		{
			return obj1[0] < obj2[0] ? 1 : obj1[0] == obj2[0] ? 0 : -1;
		}
	};
}
