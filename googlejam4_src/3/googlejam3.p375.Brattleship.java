package googlejam3.p375;


import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Brattleship
{
	private static final String PROBLEM_NAME = Brattleship.class.getSimpleName();
	private static final String WORK_DIR = "/Development/Projects/GCJ/15-1C/" + PROBLEM_NAME + "/";
//	private static final String INPUT_PATH = WORK_DIR + "sample.in";
//	private static final String INPUT_PATH = WORK_DIR + "A-small-attempt0.in";
//	private static final String INPUT_PATH = WORK_DIR + "A-small-attempt1.in";
	private static final String INPUT_PATH = WORK_DIR + "A-large.in";
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
				Brattleship r = new Brattleship();
				int R = in.nextInt();
				int C = in.nextInt();
				int W = in.nextInt();
				
				int mod = C % W;
				int div = C / W;
				
				int y = W + (mod == 0 ? 0 : 1) + (div - 1);
				
				if (R > 1)
					y += Math.max(1, div * (R - 1));
				
				out.println(y);
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
