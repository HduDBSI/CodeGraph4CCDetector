package googlejam6.p558;
import java.util.*;
public class Rank_Files {
public static void main(String ar[])
{
	Scanner input=new Scanner(System.in);
	int t=input.nextInt();
	int n;
	for(int i=1;i<=t;i++)
	{
		System.out.print("Case #"+i+": ");
		n=input.nextInt();
		int a[]=new int[2501];
		for(int j=0;j<2501;j++)
		a[j]=0;
		int l=(2*n*n-n);
		for(int j=0;j<l;j++)
		{
			int k=input.nextInt();
			a[k]++;
		}
		for(int j=0;j<2501;j++)
		{
			if(a[j]%2!=0)
				System.out.print(j+" ");
		}
		System.out.println();
	}
}
}
