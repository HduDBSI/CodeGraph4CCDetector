package googlejam1.p161;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class ProblemA {

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("A-large.in"));
		PrintWriter out = new PrintWriter(new File("outputAlarge.txt"));
		int t = in.nextInt();
		for (int tnumber = 1; tnumber <= t; tnumber++)
		{
			int n = in.nextInt();
			int [] a = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) a[i] = in.nextInt();
			int ans = 0;
			for (int i = 1; i < n; i++) 
			{
				if (a[i - 1] - a[i] > 0)
				{
					ans += a[i - 1] - a[i];
					if (a[i - 1] - a[i] > max) max = a[i - 1] - a[i];
				}
			 }
			int ans1 = 0;
			
			for (int i = 1; i < n; i++)
				if (a[i - 1] < max) ans1 += a[i - 1]; else ans1 += max;
			
			out.println("Case #" + tnumber + ": " + ans + " " +  ans1);
		}
		in.close();
		out.close();
	}
}
