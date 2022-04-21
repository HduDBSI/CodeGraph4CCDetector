package googlejam6.p242;
import java.util.*;

public class rankandfile {
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt();
		
		for( int c = 1; c <= T; c++ )
		{
			HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
			
			int N = scn.nextInt();
			
			for( int i = 0; i < 2*N - 1; i++ )
			{
				for( int j = 0; j < N; j++ )
				{
					int number = scn.nextInt();
					
					//System.out.println(number);
					
					if(!hM.containsKey(number))
						hM.put(number, 1);
					else
						hM.put(number, hM.get(number) + 1);
				}
			}
			
			int[] list = new int[N];
			int counter = 0;
			//System.out.println(hM.keySet().size());
			for( Integer number : hM.keySet() )
			{
				//System.out.println(" " + number);
				if( hM.get(number)%2 != 0 )
				{
					list[counter] = number;
					//System.out.println(list[counter]);
					counter++;
				}
			}
			
			Arrays.sort(list);
			
			System.out.print("Case #" + c + ": ");
			for( int i = 0; i < list.length; i++ )
			{
				System.out.print( list[i] + " ");
			}
			System.out.println();
		}
	}
}
