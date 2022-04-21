package googlejam9.p048;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Slides
{
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; ++t)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			int B = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			long MAX = (1L<<(B-2));
			if (M > MAX) System.out.printf("Case #%d: IMPOSSIBLE\n", t+1);
			else
			{
				System.out.printf("Case #%d: POSSIBLE\n", t+1);
				String S = Long.toBinaryString(M-1)+"1";
				while (S.length() < B) S = "0"+S;
				System.out.println(S);
				for (int i = 1; i < B-1; ++i)
				{
					for (int j = 0; j < B; ++j)
					{
						if (j <= i) System.out.print("0");
						else System.out.print("1");
					}
					System.out.println();
				}
				for (int i = 0; i < B; ++i) System.out.print("0");
				System.out.println();
			}
		}
	}
}
