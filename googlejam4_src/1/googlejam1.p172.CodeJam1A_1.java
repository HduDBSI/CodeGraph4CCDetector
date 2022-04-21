package googlejam1.p172;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeJam1A_1 {
	
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
				// Int
				int numObservation = Integer.valueOf(br.readLine());
				// Array
				String[] observationStr = br.readLine().split(" ");
				Long[] observation = new Long[numObservation];
				for(int i=0; i<numObservation; i++)
				{
					observation[i] = Long.valueOf(observationStr[i]);
				}
				
				long ans1 = 0;
				long ans2 = 0;
				long maxDiff = 0;
				for(int i=0; i<numObservation-1; i++)
				{
					long diff = observation[i] - observation[i+1];
					if(diff > 0)
					{
						ans1 += diff;
					}
					
					if(diff > maxDiff)
					{
						maxDiff = diff;
					}
				}
				
				for(int i=0; i<numObservation-1; i++)
				{
					if(maxDiff > observation[i])
					{
						ans2 += observation[i];
					}
					else
					{
						ans2 += maxDiff;
					}					
				}
				
				// Print output
				System.out.println(ans1 + " " + ans2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Template ends here
	}
	
}
