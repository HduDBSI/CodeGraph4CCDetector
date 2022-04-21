package googlejam4.p136;
import java.util.Scanner;


public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nT = sc.nextInt();
		for(int T=1; T<=nT; ++T)
		{
			int R=sc.nextInt(), C=sc.nextInt();
			
			int[][] map = new int[R][C];
			char[] line = new char[C];

			int[] dr = {0,-1, 0, 1, 0};
			int[] dc = {0, 0, 1, 0,-1};
			
			for(int r=0; r<R; ++r)
			{
				line = sc.next().toCharArray();
				for(int c=0; c<C; ++c)
				{
					switch(line[c])
					{
					case '.': map[r][c]=0; break;
					case '^': map[r][c]=1; break;
					case '>': map[r][c]=2; break;
					case 'v': map[r][c]=3; break;
					case '<': map[r][c]=4; break;
					}
				}
			}
			

			int total=0;
			boolean possible=true;
			for(int r=0; r<R && possible; ++r)
			{
				for(int c=0; c<C && possible; ++c)
				{
					if(map[r][c]==0)
						continue;
					int d=1;
					int r1 = r+d*dr[map[r][c]];
					int c1 = c+d*dc[map[r][c]];
					while((0<=r1 && r1<R && 0<=c1 && c1<C) && map[r+d*dr[map[r][c]]][c+d*dc[map[r][c]]]==0)
						++d;
					int r2 = r+d*dr[map[r][c]];
					int c2 = c+d*dc[map[r][c]];
					if(!(0<=r2 && r2<R && 0<=c2 && c2<C)) //fell off
					{
						boolean found = false;
						for(int del=1; del<=4; ++del)
						{
							d=1;
							int r3 = r+d*dr[del];
							int c3 = c+d*dc[del];
							while((0<=r3 && r3<R && 0<=c3 && c3<C) && map[r+d*dr[del]][c+d*dc[del]]==0)
								++d;
							int r4 = r+d*dr[del];
							int c4 = c+d*dc[del];
							if((0<=r4 && r4<R && 0<=c4 && c4<C)) //found arrow
							{
								found = true;
								break;
							}
						}
						if(!found)
							possible=false;
						else
							++total;
					}
				}
			}
			
			if(possible)
				System.out.println("Case #"+T+": "+total);
			else
				System.out.println("Case #"+T+": IMPOSSIBLE");
		}
			
	}
}
