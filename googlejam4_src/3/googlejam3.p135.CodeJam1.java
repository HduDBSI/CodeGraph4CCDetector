package googlejam3.p135;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeJam1 {
	
	public static void main(String[] args) {
		// Template starts here
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			int numTestCase = Integer.valueOf(br.readLine());
			for(int testCase=1; testCase<=numTestCase; testCase++)
			{
				System.out.print("Case #" + testCase + ": ");
				
				// Read each test case
				
				// Array
				String[] qArray = br.readLine().split(" ");
				// Do you need to use long or double?
				int r = Integer.valueOf(qArray[0]);
				int c = Integer.valueOf(qArray[1]);
				int w = Integer.valueOf(qArray[2]);
				
				long ansl = 0;
				
				// Logic goes here
				ansl = r*c/w;
				ansl += w;
				if((w == 1) ||(w == c) || (c%w == 0))
				{
					ansl--;
				}
				
				
				// Print output
				System.out.println(ansl);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Template ends here
	}
	
}
