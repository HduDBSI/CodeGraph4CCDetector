package googlejam6.p196;
import java.util.*;

public class rank
{
	static Scanner scan;
	static int N, T;
	
	public static void main(String[] args)
	{
		
		scan= new Scanner(System.in);
		T= scan.nextInt();
		
		for(int zz=1; zz<=T; zz++)
		{
			N= scan.nextInt();
			int[] s= new int[2501];
			
			for(int i=0; i<(2*N-1)*N; i++)
			{
				int a= scan.nextInt();
				s[a]++;
			}
			
			String ans="";
			
			int j=0;
			for(int i=1; i<s.length; i++)
				if(s[i]%2==1)
				{
					ans+= i+" ";
					j++;
				}			
			ans= ans.trim();
			
			System.out.println("Case #"+zz+": "+ans);
			
		}
	}
}