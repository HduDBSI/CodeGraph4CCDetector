package googlejam1.p260;
import java.util.*;
import java.io.*;

public class Mushroom
{
	public static int n;
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new File("Mushroom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Mushroom.out")));
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int size = sc.nextInt();
			ArrayList<Integer> plate = new ArrayList<Integer>();
			for (int j = 0; j < size; j++)
			{
				plate.add(sc.nextInt());
			}
			//get the first number and the max diff
			int num1 = 0;
			int max = 0;
			for (int i2 = 0; i2 < plate.size() - 1; i2++)
			{
				int med = plate.get(i2) - plate.get(i2+1);
				if (med > 0) num1 += med;
				if (med > max) max = med;
			}
			
			//she eats at max per 10 seconds
			
			//get the second number
			int num2 = 0;
			for (int i1 = 0; i1 < plate.size() - 1; i1++)
			{
				num2 += Math.min(plate.get(i1), max);
			}
			String ans = "" + num1 + " " + num2;
			out.println("Case #" + (i+1) + ": " + ans);
		}
		
		out.close();
		System.exit(0);
	}
}