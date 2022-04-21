package googlejam1.p506;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Mushroom {

	public static void main (String [] args) throws IOException{

		//Timing
		//long s = System.currentTimeMillis ();

		//Set up the reader and printer
		BufferedReader in = new BufferedReader (new FileReader ("A-large.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("OUT.txt")));
		int noCases = Integer.parseInt(in.readLine());
		
		//Solve the cases
		for (int caseNo = 1; caseNo <= noCases; caseNo++){
			
			int n = Integer.parseInt(in.readLine());
			String [] data = in.readLine().split(" ");
			int [] m = new int [n];
			for (int i = 0; i < n; i++)
				m[i] = Integer.parseInt(data[i]);
			
			//Get min at any rate
			int min1 = 0;
			for (int i = 1; i < n; i++)
				if (m[i]-m[i-1] < 0)
					min1 += m[i-1]-m[i];
			
			//Get min at constant rate
			int maxDifference = 0;
			for (int i = 1; i < n; i++)
				maxDifference = Math.max(maxDifference, m[i-1] - m[i]);
			
			int min2 = 0;
			for (int i = 0; i < n-1; i++)
			{
				if (m[i] < maxDifference)
					min2+=m[i];
				else
					min2+=maxDifference;
			}
			
			String answer = String.format("%d %d", min1, min2);
			out.println(String.format("Case #%d: %s", caseNo, answer));
			out.flush();//So I can see how my program is doing
		}

		//Close the files
		in.close();
		out.close();

		//Timing
		//long e = System.currentTimeMillis();
		//System.out.println((e - s) / 1000.0);

		//Terminate the program
		System.exit(0);

	} //Main method
}
