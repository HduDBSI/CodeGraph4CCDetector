package googlejam1.p425;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class R1Q1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));
		PrintWriter output = new PrintWriter(new File("out.txt"));
		int count = input.nextInt();
		int round;
		int[] mushrooms;
		int minMethodOne;
		int minMethodTwo;
		for(int i = 0; i<count; i++)
		{
			round = input.nextInt();
			mushrooms = new int[round];
			for(int x = 0; x<round; x++)
				mushrooms[x] = input.nextInt();
			int min1 = 0;
			for(int a1 = 0; a1<mushrooms.length-1; a1++)
			{
				if(mushrooms[a1] > mushrooms[a1+1])
					min1+= mushrooms[a1] - mushrooms[a1+1];
			}
			
			minMethodOne = min1;
			int max = 0;
			int min = 0;
			for(int a = 0; a<mushrooms.length-1; a++)
			{
				if(mushrooms[a] - mushrooms[a+1] > max)
					max = mushrooms[a] - mushrooms[a+1];
			}
			for(int b = 0; b<mushrooms.length-1; b++)
			{
				if(mushrooms[b] < max)
					min+= mushrooms[b];
				else
					min+=max;
			}
			minMethodTwo = min;
			output.write("Case #" + (i+1) + ": " + minMethodOne + " " + minMethodTwo + "\n");
		}
		output.close();
	}

}
