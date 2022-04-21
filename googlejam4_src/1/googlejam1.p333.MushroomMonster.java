package googlejam1.p333;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MushroomMonster
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw = new PrintWriter("A-large.out");
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < t; test++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] mushrooms = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
			{
				mushrooms[i] = Integer.parseInt(st.nextToken());
			}
			int cur = 0;
			for (int i = 1; i < mushrooms.length; i++)
			{
				cur += Math.max(0, mushrooms[i - 1] - mushrooms[i]);
			}
			
			int m1 = cur;
			int maxDiff = 0;
			for (int i = 1; i < mushrooms.length; i++)
			{
				maxDiff = Math.max(maxDiff, mushrooms[i - 1] - mushrooms[i]);
			}
			int r = 0;
			for (int i = 0; i < mushrooms.length - 1; i++)
			{
				r += Math.min(maxDiff, mushrooms[i]);
			}
			int m2 = r;
			
			pw.printf("Case #%d: %d %d%n", test + 1, m1, m2);
		}
		br.close();
		pw.close();
	}
}