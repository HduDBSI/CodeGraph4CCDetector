package googlejam1.p369;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mushrooms {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File("b.in"));
		//Scanner in = new Scanner (System.in);
		int cases = in.nextInt();
		for (int caseNo = 1; caseNo <= cases; caseNo++)
		{
			int size = in.nextInt();
			int []pieces = new int[size];
			for (int i = 0; i < size; i++)
			{
				pieces[i] = in.nextInt();
			}
			int count = 0;
			int base = pieces[0];
			for (int i = 1; i < pieces.length; i++)
			{
				int curr = pieces[i];
				if (curr < base)
					count += (base - curr);
				base = curr;
			}
			int res1 = count;
			int max= 0;
			int base1 = pieces[0];
			for (int i = 1; i < pieces.length; i++)
			{
				int curr = pieces[i];
				if (curr < base1)
				{
					int diff = (base1 - curr);
					if (diff > max)
						max = diff;
				}
				base1 = curr;
			}
			int rate = max/10;
			int count1 = 0;
			base1 = pieces[0];
			int eaten = max;
			for (int i = 0; i < pieces.length-1; i++)
			{
				int curr = pieces[i];
				if (curr < eaten)
					count1 += curr;
				else
					count1 += max;
				//System.out.println("Eaten =  " + count);
				base1 = curr;
			}
			int res2 = count1;
			
			System.out.println("Case #" + caseNo + ": " + res1 + " " + res2);
			
		}
	}

}
