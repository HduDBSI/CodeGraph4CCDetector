package googlejam4.p071;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ProbA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numcases = sc.nextInt();
		for(int curcase = 1; curcase<=numcases; curcase++)
		{
			int R = sc.nextInt();
			int C = sc.nextInt();
			sc.nextLine();
			int [][] board = new int[R][C];
			HashSet[][] restrictions = new HashSet[R][C];
			for(int i=0;i<R;i++)
			{
				String s = sc.nextLine();
				
				for(int j=0;j<C;j++)
				{
					restrictions[i][j] = new HashSet();
					if(s.charAt(j)=='^')
					board[i][j] = 1;
					if(s.charAt(j)=='>')
					board[i][j] = 2;
					if(s.charAt(j)=='v')
					board[i][j] = 3;
					if(s.charAt(j)=='<')
					board[i][j] = 4;					
				}
			}

			for(int i=0;i<R;i++)
			{
					for(int j=0;j<C;j++)
					{
						if(board[i][j]!=0)
						{
							restrictions[i][j].add(4);
							break;
						}
					}
					for(int j=C-1;j>=0;j--)
					{
						if(board[i][j]!=0)
						{
							restrictions[i][j].add(2);
							break;
						}
					}
			}
			
			for(int j=0;j<C;j++)
			{
					for(int i=0;i<R;i++)
					{
						if(board[i][j]!=0)
						{
							restrictions[i][j].add(1);
							break;
						}
					}
					for(int i=R-1;i>=0;i--)
					{
						if(board[i][j]!=0)
						{
							restrictions[i][j].add(3);
							break;
						}
					}
			}
			
			long count = 0;
			LOOP:
			for(int i=0;i<R;i++)
			{
				for(int j=0;j<C;j++)
				{
					if(restrictions[i][j].size()==4)
					{
						count = Long.MAX_VALUE;
						break LOOP;
					}else{
						if(restrictions[i][j].contains(board[i][j]))
							count++;
					}
					
				}
			}
						
			if(count < Long.MAX_VALUE)
			System.out.println("Case #"+curcase+": "+count);
			else
			System.out.println("Case #"+curcase+": IMPOSSIBLE");
		}
	}
}
