package googlejam6.p263;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Round1B {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input")));
		
		int test_no = Integer.parseInt(br.readLine());
		
		BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		
		for(int i = 1; i <= test_no; i++)
		{
			int N = Integer.parseInt(br.readLine());
			ArrayList<String> alllist = new ArrayList<String>();
			int[] count = new int[2500];
			for(int j = 0; j < 2 * N - 1;j++)
			{
				String[] oneline = br.readLine().split(" ");
				for(int k = 0; k < N; k++)
					count[Integer.parseInt(oneline[k]) - 1]++;
			}
			StringBuilder result = new StringBuilder();
			//System.out.println(count[14]);
			for(int m = 0; m < 2500; m++)
			{
				if(count[m] % 2 == 1)
				{
					result.append(String.valueOf(m+1));
					result.append(" ");
				}
			}
			System.out.println(result.toString().trim());
				

		    out.write("Case #");
			out.write(String.valueOf(i));
			out.write(": ");
			out.write(result.toString().trim());
			out.write("\n");	
//		    System.out.println(result.toString());
		}
		br.close();
		out.close();		
	}

}
