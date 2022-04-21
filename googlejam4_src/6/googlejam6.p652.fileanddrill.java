package googlejam6.p652;
import java.io.*;
import java.util.*;
public class fileanddrill
{	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int c=1;
		
		while(t>0)
		{
			System.out.print("Case #"+c+": ");
			int n=s.nextInt();
			int [][]a=new int[2*n-1][n];
			int []r=new int[2501];
			for (int i =0;i<2*n-1 ;i++ ) {
				for (int j=0;j<n; j++) {
					a[i][j]=s.nextInt();
					
				}
			}

			for (int i =0;i<2*n-1 ;i++ ) {
				for (int j =0;j<n; j++) {
					r[a[i][j]]=r[a[i][j]]+1;
					
				}
			}
			for (int i=0; i<2501;i++ ) {
				if(r[i]%2==1)
					System.out.print(i+" ");
			}
			System.out.println();
			t--;
			c++;
		}
	}
}