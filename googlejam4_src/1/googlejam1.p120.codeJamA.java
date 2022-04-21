package googlejam1.p120;
import java.io.*;
import java.util.*;

public class codeJamA
{
	public static void main(String[] args) throws IOException
	{
	//pancakes
		File f = new File("test.txt");
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter(new FileWriter("testout.txt"));
		int numCases = in.nextInt();
		in.nextLine();

		//problem specific
		int times;
		
		for(int i = 0; i < numCases; i++){
			times = in.nextInt();
			//in.nextLine();
			int[] checks = new int[ times ];
			for(int j = 0; j < times; j++ ){	//for each interval
				checks[j] = in.nextInt();
			}
			//now find first method result: is total of positive consecutive differences
			long first = 0, second = 0;
			long secondMax = 0;
			long dif;
			for(int j = 1; j < times; j++ ){ //compare each neighboring pair
				dif = checks[j - 1] - checks[j];
				if (dif > 0 ){ //ate some
					first += dif;
					secondMax = Math.max(secondMax, dif); //take the maximum she could have ate. 
				}
			}
			//second *= times; // per round
			//calculation for the second one. 
			for(int j = 0; j < times - 1; j++ ){ //for each time period
				second += Math.min( secondMax, checks[j] );
			}
			out.format("Case #%d: %s\n", i + 1, first + " " + second);			
		}
		out.close();
	}
}
