package googlejam8.p066;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Senate {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("A-large.in"));
		// System.out.println("HELLO");
		//Scanner in = new Scanner(System.in);
		PrintWriter fileOut = new PrintWriter(new FileWriter("SenateLarge.out"));
		
		int T = in.nextInt();
		for (int test = 1; test <= T; test++)
		{
			int N = in.nextInt();
			ArrayList<Integer> all = new ArrayList<Integer>();
			int total = 0;
			for (int m = 0; m < N; m++)
			{
				int num = in.nextInt();
				total += num;
				all.add(num);				
			}
			fileOut.printf("Case #%d: ", test);
			while (total != 0)
			{
				int max = 0;
				int secondI = 0;
				boolean secondUsed = false;
				for (int i = 0; i < N; i++)
				{
					if (all.get(i) >= all.get(max))
						max = i;
					if (all.get(i) >= total/2.0 && !secondUsed)
					{
						secondI = i;
						secondUsed = true;
					}
				}
				
				if (secondUsed && secondI != max)
				{
					all.set(max, all.get(max) - 1);
					char c = (char) (max + 'A');
					fileOut.print(c);
					total--;
					all.set(secondI, all.get(secondI) - 1);
					c = (char) (secondI + 'A');
					fileOut.print(c + " ");
					total--;
				}
				else
				{
					all.set(max, all.get(max) - 1);
					char c = (char) (max + 'A');
					fileOut.print(c + " ");
					total--;
				}
			}
			fileOut.println();
		}
		fileOut.close();

	}

}
