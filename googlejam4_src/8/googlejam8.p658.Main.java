package googlejam8.p658;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Main
{  

public static void main(String[] args)throws java.lang.Exception
{
//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//PrintWriter out=new PrintWriter(System.out);

BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
PrintWriter out=new PrintWriter("output.txt");


int x1,t,i,n,sum,new_sum,max1,max2;
boolean found;

String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

t=Integer.parseInt(in.readLine());

for(x1=0;x1<t;x1++)
{
	n=Integer.parseInt(in.readLine());

	int[][] a=new int[n][2];

	StringTokenizer st=new StringTokenizer(in.readLine());


	sum=0;

	for(i=0;i<n;i++)
	{
		a[i][0]=Integer.parseInt(st.nextToken());
		a[i][1]=i;
		sum+=a[i][0];
	}


	out.print("Case #"+(x1+1)+":");

	while(sum>0)
	{
		Arrays.sort(a,new Comparator<int[]>(){
		public int compare(int[] c1,int[] c2)
		{
		int t2=c1[0]-c2[0];
			return t2;
		}
		});



		//Arrays.sort(a);
		max1=a[n-1][0];
		max2=a[n-2][0];

		new_sum=sum-2;


		found=true;

		if(new_sum>0)
		{

		for(i=0;i<n-2;i++)
		{
			if(a[i][0]/new_sum>0.5)
			{
				found=false;
			}
		}

		}


		if(found)				//	Remove two elements
		{
			out.print(" "+str.charAt(a[n-1][1])+str.charAt(a[n-2][1]));

			a[n-1][0]--;
			a[n-2][0]--;

			sum-=2;
		}
		else  					//  Remove one element
		{
			out.print(" "+str.charAt(a[n-1][1]));

			a[n-1][0]--;

			sum-=1;
		}

	}

	out.println();

}



out.flush();
out.close();
}
}  






