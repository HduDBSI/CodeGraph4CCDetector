package googlejam4.p112;
import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 0; t<T; t++)
	{
		System.out.print("Case #"+(t+1)+": ");
		int n = input.nextInt(), m = input.nextInt();
		char[][] grid = new char[n][m];
		for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
		boolean poss = true;
		int[][] count = new int[n][m];
		boolean[][] bad = new boolean[n][m];
		int[] di = new int[]{0, 1, 0, -1};
		int[] dj = new int[]{1, 0, -1, 0};
		char[] cs = new char[]{'>','v','<','^'};
		for(int i = 0; i<n; i++)
			for(int j = 0; j<m; j++)
			{
				if(grid[i][j] == '.') continue;
				for(int k = 0; k<4; k++)
				{
					boolean edge = false;
					int ati = i, atj = j;
					while(true)
					{
						ati += di[k];
						atj += dj[k];
						if(ati < 0 || atj < 0 || ati >= n || atj >= m)
						{
							edge = true;
							break;
						}
						if((ati != i || atj != j) && grid[ati][atj] != '.') break;
					}
					if(edge)
					{
						count[i][j]++;
						if(grid[i][j] == cs[k]) bad[i][j] = true;
					}
				}
			}
		int res = 0;
		for(int i = 0; i<n && res != -1; i++)
			for(int j = 0; j<m && res != -1; j++)
			{
				if(bad[i][j]) res++;
				if(count[i][j] == 4) res = -1;
				
			}
		System.out.println(res == -1 ? "IMPOSSIBLE" : res);
	}
}
}
