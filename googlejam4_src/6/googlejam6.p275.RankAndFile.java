package googlejam6.p275;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class RankAndFile {

	static Scanner input;
	static PrintWriter output;
	static int testCases;
	static final String inFileName = "in.txt";
	static final String outFileName = "RankAndFile.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		input = new Scanner(new File(inFileName));
		output = new PrintWriter(new File(outFileName));
		testCases = input.nextInt();
		
		StringBuilder answer;
		int N;
		
		int[] list;
		
		
		for(int i = 0; i<testCases; i++)
		{
			N = input.nextInt();
			input.nextLine();
			
			answer = new StringBuilder();
			list = new int[2*N*N-N];
			for(int x = 0; x<2*N*N-N; x++)
			{
				list[x] = input.nextInt();
			}
			
			Arrays.sort(list);
			int temp,count=1;
			temp = list[0];
			for(int y = 1; y<list.length; y++)
			{
				if(temp == list[y])
					count++;
				else
				{
					if(count%2 != 0)
					{
						answer.append(temp + " ");
					}
					count = 1;
					temp = list[y];
				}
			}
			if(count%2 != 0)
			{
				answer.append(temp + " ");
			}
			
			output.write("Case #" + (i+1) + ": " + answer.toString().trim() + "\n");
		}
		
		input.close();
		output.close();
	}
	
}

