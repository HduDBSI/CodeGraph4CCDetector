package googlejam6.p175;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RankAndFile {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("rankandfile.out");
			for(int i = 1; i <= t; i++)
			{
				int n = Integer.parseInt(f.readLine());
				int[] count = new int[2501];
				for(int j = 0; j < 2*n - 1; j++)
				{
					StringTokenizer st = new StringTokenizer(f.readLine());
					for(int k = 0; k < n; k++)
					{
						int height = Integer.parseInt(st.nextToken());
						count[height]++;
					}
				}
				StringBuffer s = new StringBuffer("");
				for(int j = 1; j <= 2500; j++)
				{
					if(count[j]%2 == 1)
						s.append(j + " ");
				}
				String output = s.toString().trim();
				System.out.println("Case #" + i + ": " + output);
				fout.write("Case #" + i + ": " + output + "\n");
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}

}
