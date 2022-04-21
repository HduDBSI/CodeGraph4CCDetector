package googlejam1.p806;
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.*;

public class mushroom
{
	public static void main(String[] args)throws IOException
	{
		Scanner scan = new Scanner(new File("input.txt"));
		//Scanner scan = new Scanner(System.in);
		FileWriter fw = new FileWriter("output.txt");
		ArrayList<String> output = new ArrayList<String>();

		int test_cases = scan.nextInt();

		for(int i=0; i<test_cases; i++)
		{
			int n = scan.nextInt();
			int[] middle = new int[n];
			int eaten_any_time = 0;
			int eaten_constant = 0;
			int eating_rate = 0; 
			int eaten = 0;

			int max_diff = 0;
			
			middle[0] = scan.nextInt();
			eating_rate = middle[0];
			eaten_constant = 0;

			//special case: start and end
			if(n == 2)
			{
				middle[1] = scan.nextInt();
				if(middle[1] <= middle[0])
				{
					eaten_constant = middle[0] - middle[1];
					eaten_any_time = middle[0] - middle[1];
				}	
			}
			else
			{
				//eaten_constant = middle[0];

				for(int j=1; j<n; j++)
				{
					middle[j] = scan.nextInt();
					
					//any # at any time min number of mushrooms eatin
					if(middle[j] >= middle[j-1])
						eaten = 0;
					else
						eaten = middle[j-1] - middle[j];

					if(middle[j] < middle[j-1])
						eaten_any_time += eaten;

					//find max diff
					int diff = difference(middle[j-1], middle[j]);
					if(max_diff < diff)
						max_diff = diff;
				}

				for(int j=0; j<n-1; j++)
				{
					if(middle[j] <= max_diff)
						eaten_constant += middle[j];
					else 
						eaten_constant += max_diff;
				}
			}
				
			
			output.add("Case #" + (i+1) + ": " + eaten_any_time + " " + eaten_constant);
		}

		for(String s : output)
		{
			fw.write(s + "\n");
			//System.out.println(s);
		}
		fw.close();
	}

	public static int difference(int x, int y)
	{
		if(x > y)
			return x-y;
		else return 0;
	}
}