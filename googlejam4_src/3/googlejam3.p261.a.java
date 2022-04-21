package googlejam3.p261;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class a
{

	public static void main(String [] args)
	{

		Scanner infile = null;
		try{
			//infile = new Scanner(new File("D-small.txt"));
			infile = new Scanner(new File("A-large.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		int numCases = infile.nextInt();
		int row;
		int col;
		int width;
		int ret = 0;
		int temp;
		for(int a = 0; a < numCases; a++)
		{
			row = infile.nextInt();
			col = infile.nextInt();
			width = infile.nextInt();
			if(col%width == 0)
				ret = width-1;
			else
				ret = width;
			temp = col/width;
			ret+=(temp*row);
			System.out.println("Case #" + (a+1) + ": " + ret);
		}



	}
}