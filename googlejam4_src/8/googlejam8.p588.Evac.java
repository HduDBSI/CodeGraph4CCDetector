package googlejam8.p588;


import java.io.*;
import java.util.*;

public class Evac {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Enter no. of test cases.");
		FileInputStream fis = new FileInputStream("A3.txt");
		Scanner in = new Scanner(fis);
		//Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=1;i<=t;i++)
		{
			int N = in.nextInt();
			ArrayList<Integer> tp = new ArrayList<Integer>();
			int sum=0;
			for ( int j=0;j<N;j++)
			{
				int nt = in.nextInt();
				tp.add(nt);
				sum += nt;
			}
			StringBuilder sb = new StringBuilder();
			while (sum>0)
			{
				int max1 = 0;
				int imax1 = -1;
				for (int k=0;k<N;k++)
				{
					if(tp.get(k)>max1)
					{
						max1 = tp.get(k);
						imax1 =k;
					}
				}
				int max2 = 0;
				int imax2 = -1;
				for (int k=0;k<N;k++)
				{
					if(tp.get(k)>max2&&(max2<=max1&&k!=imax1))
					{
						max2 = tp.get(k);
						imax2 =k;
					}
				}
				//System.out.println(imax1);
				//System.out.println(imax2);
				int k=0;
				for (k=0;k<N;k++)
				{
					if ((k==imax1||k==imax2)&&(2*(tp.get(k)-1)>sum-2))
							break;
					else if (k!=imax1&&k!=imax2&&(2*tp.get(k)>(sum-2)))
						break;	
				}
				if(k==N)
				{
					char c =(char)('A'+imax1);
					char d =(char)('A'+imax2);
					sb.append(c);
					sb.append(d);
					sb.append(" ");
					sum -=2;
					tp.set(imax1, tp.get(imax1)-1);
					tp.set(imax2, tp.get(imax2)-1);
				}
				else
				{
					char c =(char)('A'+imax1);
					sb.append(c);
					sb.append(" ");
					sum-=1;
					tp.set(imax1, tp.get(imax1)-1);
				}				
			}
			System.out.println("Case #"+i+": "+sb.toString());			
		}
	}

}
