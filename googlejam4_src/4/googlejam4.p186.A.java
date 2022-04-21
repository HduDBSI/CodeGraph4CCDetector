package googlejam4.p186;
import java.util.*;
import java.io.*;

public class A
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		int numRuns=Integer.parseInt(in.readLine());
		for (int run=1; run<=numRuns; run++)
		{
			StringTokenizer tok=new StringTokenizer(in.readLine());
			int r=Integer.parseInt(tok.nextToken()), c=Integer.parseInt(tok.nextToken());
			int[][] dir=new int[r][c];
			int[][] row=new int[r][c];
			int[][] col=new int[c][r];
			int[] inRow=new int[r];
			int[] inCol=new int[c];
			
			for (int i=0; i<r; i++)
			{
				String line=in.readLine();
				for (int j=0; j<c; j++)
				{
					if (line.charAt(j)!='.')
					{
						row[i][inRow[i]]=j;
						inRow[i]++;
						col[j][inCol[j]]=i;
						inCol[j]++;
					}
					if (line.charAt(j)=='<')
						dir[i][j]=0;
					else if (line.charAt(j)=='^')
						dir[i][j]=1;
					else if (line.charAt(j)=='>')
						dir[i][j]=2;
					else if (line.charAt(j)=='v')
						dir[i][j]=3;
				}
			}
			
			int changes=0;
			boolean[] okay={false, false, false, false};
			int colPos;
			for (int i=0; i<r && changes>=0; i++)
				for (int j=0; j<inRow[i] && changes>=0; j++)
				{
					colPos=Arrays.binarySearch(col[row[i][j]], 0, inCol[row[i][j]], i);
					okay[0]=j>0;
					okay[1]=colPos>0;
					okay[2]=j<inRow[i]-1;
					okay[3]=colPos<inCol[row[i][j]]-1;
					
					if (okay[dir[i][row[i][j]]])
						continue;
					else if (okay[0] || okay[1] || okay[2] || okay[3])
						changes++;
					else
						changes=-1;
				}
			System.out.print("Case #"+run+": ");
			if (changes==-1)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(changes);
		}
	}
}