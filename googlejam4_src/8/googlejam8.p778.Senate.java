package googlejam8.p778;
import java.io.*;
	import java.util.*;
	public class Senate
	{
		
		public static void main(String args[])
		{
				Scanner s= new Scanner(System.in);
				int t = s.nextInt();
				int is=1;
				while((t--)>0)
				{	int sum=0;
					int n= s.nextInt();
					int a[]=new int[n];
					System.out.print("Case #"+is+":");
					is++;
					for(int i=0;i<n;i++)
					{
						a[i]=s.nextInt();
						sum=sum+a[i];

					}
					while(sum!=0||sum>0)
					{

					int l1=0;
					int l2=0;
					for(int i=0;i<n;i++)
					{
						if(a[i]>=a[l1])
						{
							l2=l1;
							l1=i;

						}
						else if (a[i]>=a[l2])
						{
							l2=i;
						}
					}
					if(a[l1]==a[l2]&&a[l2]-2>=0)
					{
						
						char ac =(char) (65+l1);
						char b =(char) (65+l2);
						
						System.out.print(" "+b+ac);
						a[l1]--;
						a[l2]--;
						sum=sum-2;
					}
					else if(a[l1]==1&&a[l2]==1&&sum%2!=0)
					{
						char ac =(char) (65+l1);
							System.out.print(" "+ac);
						a[l1]--;
						sum=sum-1;
					}
					else if((a[l1]==1)&&(a[l2]==1)&&sum%2==0)
					{
						char ac =(char) (65+l1);
						char b =(char) (65+l2);
						
						System.out.print(" "+b+ac);
						a[l1]--;
						a[l2]--;
						sum=sum-2;
					}
					
					else if( a[l1]-2>=1)
					{	
						char ac =(char) (65+l1);
						System.out.print(" "+ac+ac);
						a[l1]=a[l1]-2;
						sum=sum-2;
					}
					else if(a[l1]==2)
					{
							char ac =(char) (65+l1);
							System.out.print(" "+ac);
							sum=sum-1;
							a[l1]--;
					}

					
}
				System.out.println();

				}
		}
	}
