package googlejam9.p056;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Slides {

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new File("B-large.in"));
		// System.out.println("HELLO");
		//Scanner in = new Scanner(System.in);
		PrintWriter fileOut = new PrintWriter(new FileWriter("SlidesLarge.out"));
		int T = in.nextInt();
		for (int test = 1; test <= T; test++)
		{
			int B = in.nextInt();
			long M = in.nextLong();
			long maxB = (long) Math.pow(2, B-2);
			if (M <= maxB)
			{
				fileOut.printf("Case #%d: POSSIBLE\n", test);
				int[][] arr = new int[B][B];
				for (int r = 1; r < B; r++)
				{
					for (int c = 0; c < B; c++)
					{
						if (c > r)
							arr[r][c] = 1;
						else
							arr[r][c] = 0;
					}
				}
				// Lower triangle now
				// Make first line binary of M;
				// work from back...
				M --;
				arr[0][B-1] = 1;
				String bin = Long.toBinaryString(M);
				int l = bin.length();
				//System.out.println(bin);
				for (int i = 0; i < l; i++)
				{
					if (bin.charAt(l-i-1) == '1')
					{
						arr[0][B-i-2] = 1;
					}
				}
				// Now print arr
				for(int i = 0; i< B; i++)
				{
				    for(int j = 0; j< B; j++)
				    {
				        fileOut.print(arr[i][j]);
				    }
				    fileOut.println();
				}
			}
			else
			{
				// Not possible
				fileOut.printf("Case #%d: IMPOSSIBLE\n", test);
			}
		}
		fileOut.close();

	}

}
