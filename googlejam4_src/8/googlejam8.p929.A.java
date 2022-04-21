package googlejam8.p929;
import java.io.*;
import java.util.*;

class A
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintStream ot = new PrintStream(new FileOutputStream("Out1C_A.txt"));
        System.setOut(ot);
		int t = sc.nextInt(),t1=t;
		while(t-->0)
		{
			int n = sc.nextInt(),lg=-1,p1=-1,p2=-1,c=0,p3=-1;
			int a[] = new int[n];
			for(int i=0; i<n; i++) 
			{
				a[i] = sc.nextInt();
				if(a[i]>lg) 
				{
					lg=a[p1=i];
					p2=p3=-1;
				}
				else if(p2==-1&&a[i]==lg) p2=i;
				else if(p3==-1&&a[i]==lg) p3=i;
				c+=a[i];
			}
			String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			System.out.print("Case #"+(t1-t)+": ");
			do{
				if(c!=1)
				{
					if(p3!=-1)
					{
						System.out.print(s1.charAt(p1)+" ");
						a[p1]--;
						c--;
					}
					else if(p2!=-1&&a[p1]==a[p2])
					{
						System.out.print(s1.charAt(p1)+""+s1.charAt(p2)+" ");
						a[p1]--;
						a[p2]--;
						c-=2;
					}
					else
					{
						System.out.print(s1.charAt(p1)+""+s1.charAt(p1)+" ");
						a[p1]-=2;
						c-=2;
					}
				}
				else
				{
					System.out.print(s1.charAt(p1)+" ");
					a[p1]--;
					c--;
				}
				lg=p1=p2=p3=-1;
				for(int i=0; i<n; i++)
				{
					if(a[i]>lg) lg=a[p1=i];
					else if(p2==-1&&a[i]==lg) p2=i;
					else if(p3==-1&&a[i]==lg) p3=i;
				}
			}while(c!=0);
			System.out.println();
		}
	}
}