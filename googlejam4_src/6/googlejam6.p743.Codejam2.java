package googlejam6.p743;
import java.io.*;
import java.util.*;

class Codejam2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int arr[][]=new int[((2*n)-1)][n];
			int a[]=new int[2501];
			for(int j=0;j<(2*n)-1;j++)
			{
				for(int k=0;k<n;k++)
				{	arr[j][k]=sc.nextInt();
					a[arr[j][k]]++;
				}
			}
			int b[]=new int[n];
			int z=0;
			for(int j=1;j<=2500;j++)
				if(a[j]%2!=0)
					b[z++]=j;
			Arrays.sort(b);
			System.out.print("Case #"+(i+1)+": ");
			for(int j=0;j<n;j++)
				System.out.print(b[j]+" ");
			System.out.println();
		}
	}
}