package googlejam8.p748;
import java.util.*;

public class first1C
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T=in.nextInt();
		for(int t=0;t<T;t++)
		{
			int N = in.nextInt();
			ArrayList<Integer> A = new ArrayList<Integer>();
			for(int n=0;n<N;n++)
			{
				A.add(in.nextInt());
			}
			String S = "";
			int count_notzeroes = N ;
			while(true)
			{
				
				if(count_notzeroes==2)
				{
					int x=0,y=1;
					for(int i=0;i<N;i++)
					{
						if(A.get(i)!=0)
							x=i;
					}
					for(int i=0;i<N;i++)
					{
						if(A.get(i)!=0 && i!=x)
							y=i;
					}
					while(A.get(x)!=0 && A.get(y) != 0)
					{
						if(A.get(x)==A.get(y))
						{
							S = S + " "  +(char)(x+65) + (char)(y+65);
							A.set(x,A.get(x)-1);
							A.set(y,A.get(y)-1);
						}
						else if(A.get(x)>A.get(y))
						{
							S= S + " "  +(char)(x+65);
							A.set(x,A.get(x)-1);
						}
						else if(A.get(x)<A.get(y))
						{
							S =S +" " +(char)(y+65);
							A.set(y,A.get(y)-1);
						}
							//System.out.println("in inner while loop" +A.get(x) );
					}
				    break;
				}
				else 
				{
					int max_index;
					int max;
				
				
					max = A.get(0);
					max_index=0;
					for(int i=0;i<N;i++)
					{
						if(max<A.get(i))
						{
							max=A.get(i);
							max_index=i;
						}
					}
					
						A.set(max_index,A.get(max_index)-1);
						if(A.get(max_index)==0) {count_notzeroes--; }
						S = S + " " + (char)(max_index+65);
					
				}
			}

			System.out.println("Case #" +(t+1) +": " +S.substring(1));
		}

	}
}