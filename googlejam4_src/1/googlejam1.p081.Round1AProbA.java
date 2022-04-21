package googlejam1.p081;
import java.util.*;
import java.io.*;
public class Round1AProbA {
	
	public static void main(String[] args) throws Exception
	{
		String file = "Round1A/A-large.in";

		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintWriter writer = new PrintWriter("outAlarge.txt", "UTF-8");
		String line;

		int T = Integer.parseInt(br.readLine());
		for(int test=0;test<T;test++)
		{
			int N = Integer.parseInt(br.readLine());
			String[] lines = br.readLine().split(" ");
			int[] m = new int[N];
			for(int i=0;i<lines.length;i++)
			{
				m[i] = Integer.parseInt(lines[i]);
			}
			int num = 0;
			for(int i=1;i<N;i++)
			{
				if(m[i]<m[i-1])
				{
					num+=m[i-1]-m[i];
				}
			}
			
			int num1 = num;
			int rate = 0;
			for(int i=1;i<N;i++)
			{
				if(m[i]<m[i-1])
				{
					rate=Math.max(rate,m[i-1]-m[i]);
				}
			}
			int num3 = 0;
			for(int i=0;i<N-1;i++)
			{
				num3 += Math.min(rate,m[i]);
			}
			int num2 = num3;
			
			writer.println("Case #"+(test+1)+": " + num1 + " " + num2);
		}
		writer.close();
	}
}