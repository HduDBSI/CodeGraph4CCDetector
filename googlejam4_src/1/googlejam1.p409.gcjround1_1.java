package googlejam1.p409;
import java.util.*;
public class gcjround1_1
{
	static Scanner sc=new Scanner (System.in);
	public static void main (String[]args)
	{
		//String newLine=""+(char)13;
		//sc.useDelimiter(newLine);

		int T=sc.nextInt();
		for (int i=0;i<T;i++)
		{
			int N=sc.nextInt();
			int curr=0;
			int next=sc.nextInt();
			int[]a=new int[N];
				a[0]=next;
			int max=0;
			int meth1max=0;
			for (int i1=1;i1<N;i1++)
			{
				 curr=next;
				 next=sc.nextInt();
				 a[i1]=next;
				if (curr-next>max)
					max=curr-next;
				if (curr-next>0)
					meth1max+=curr-next;
			}
			int sum=0;
			for (int i2=0;i2<N-1;i2++)
			{
				if (a[i2]>max)
					sum+=max;
				else
					sum+=a[i2];
			}
				System.out.println("Case #"+(i+1)+": "+meth1max+" "+sum);
			//number of recorded times

			//System.out.println("Case #"+(i+1)+": "+f(N));
		}
	}
}