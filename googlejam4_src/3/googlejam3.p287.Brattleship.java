package googlejam3.p287;
import java.util.*;

/* Version: 0.0.1
 * Date: 5/10/15
 * Author: Rahul Butani
 */

class Brattleship //Darn siblings, man.
{
	static Scanner sc = new Scanner(System.in);
	static int testCases[][];
	static int outputs[];

	public static void main(String[] args)
	{
		testCases = new int[sc.nextInt()][3];
		outputs = new int[testCases.length];
		
		for(int i = 0; i < testCases.length; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				testCases[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < testCases.length; i++)
		{
			outputs[i] = (((int)(testCases[i][1]/testCases[i][2])) * testCases[i][0]) + (testCases[i][2]-1) + ((int)Math.ceil((double)testCases[i][1]/(double)testCases[i][2])-((int)(testCases[i][1]/testCases[i][2])));
		}
		for(int i = 0; i < outputs.length; i++)
		{
			System.out.println("Case #" + (i+1) + ": " + outputs[i] + "");
		}
	}
}