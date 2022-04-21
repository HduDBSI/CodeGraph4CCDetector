package googlejam3.p241;
import java.io.*;
import java.util.*;

class F
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int nData = in.nextInt();
		in.nextLine();
		
		for (int asdf = 0; asdf < nData; asdf++)
		{
			//solve the problem
			int rows = in.nextInt();
			int cols = in.nextInt();
			int width = in.nextInt();
			
			//main answer
			int perrow = cols / width;
			int answer = perrow * rows;
			answer += width - 1;
			
			//extra guesses
			if (cols % width != 0)
			{
				answer++;
			}
			
			System.out.println("Case #" + (asdf+1) + ": " + answer);
		}
	}
}
