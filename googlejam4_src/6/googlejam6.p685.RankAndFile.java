package googlejam6.p685;


import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class RankAndFile
{
	private static final String PROBLEM_NAME = RankAndFile.class.getSimpleName();
	private static final String WORK_DIR = "/Development/Projects/GCJ/16-1A/" + PROBLEM_NAME + "/";
//	private static final String INPUT_PATH = WORK_DIR + "sample.in";
//	private static final String INPUT_PATH = WORK_DIR + "B-small-attempt2.in";
	private static final String INPUT_PATH = WORK_DIR + "B-large.in";
//	private static final String INPUT_PATH = WORK_DIR + "debug.in";
	private static final String OUTPUT_PATH = INPUT_PATH.replace(".in", ".out");
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("Solving " + PROBLEM_NAME + "...");
		System.out.println("Input: " + INPUT_PATH);
		System.out.println("Output: " + OUTPUT_PATH);
		
		PrintWriter out = new PrintWriter(OUTPUT_PATH, "US-ASCII");
		Scanner in = new Scanner(new File(INPUT_PATH), "US-ASCII");
		in.useLocale(Locale.US);
		
		int testCasesNumber = in.nextInt();
		in.nextLine();
		System.out.println("Test cases: " + testCasesNumber);
		
		try
		{
			for (int testCase = 1; testCase <= testCasesNumber; testCase++)
			{
				System.out.println("Solving test case: " + testCase + "...");
				out.print("Case #" + testCase + ": ");
				RankAndFile r = new RankAndFile();
				int N = in.nextInt();
				Map<Integer, Integer> M = new HashMap<>((2 * N - 1) * N);
				
				for (int i = 0; i < 2 * N - 1; i++)
				{
					for (int j = 0; j < N; j++)
					{
						int h = in.nextInt();
						if (M.containsKey(h))
							M.put(h, M.get(h) + 1);
						else
							M.put(h, 1);
					}
				}
				
				ArrayList<Integer> result = new ArrayList<>();
				
				for (Map.Entry<Integer, Integer> entry : M.entrySet())
				{
					if (entry.getValue() % 2 != 0)
						result.add(entry.getKey());
				}
				
				Collections.sort(result);
				
				for (Integer i : result)
				{
					out.print(i + " ");
				}
				
				out.println();
				out.flush();
			}
		}
		finally
		{
			in.close();
			out.close();
		}
		
		System.out.println("All test cases solved!");
	}
}
