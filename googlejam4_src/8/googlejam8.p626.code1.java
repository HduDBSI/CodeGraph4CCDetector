package googlejam8.p626;
import java.util.*;

class code1{
public static void main(String args[])
{
	int t,i,ind=1,n,temp;
	Scanner sc=new Scanner(System.in);
	t=sc.nextInt();
	String s;
	while(t-- >0)
	{
		s=sc.next();
		n=s.length();
		int arr[]=new int[26],ans[]=new int[10];
		for(i=0;i<26;++i)
			arr[i]=0;
		
		for(i=0;i<10;++i)
			ans[i]=0;

		
		for(i=0;i<n;++i)
		{
			arr[(int)s.charAt(i)-65]++;			
		}
		
		if(arr[6]!=0)
		{
			temp=arr[6];
			ans[8]=temp;//eight
			
			arr[6]=0;
			arr[4]-=temp;
			arr[8]-=temp;
			arr[7]-=temp;
			arr[19]-=temp;
		}
		if(arr[20]!=0)//four
		{
			temp=arr[20];
			ans[4]=temp;
			
			arr[5]-=temp;
			arr[14]-=temp;
			arr[20]-=temp;
			arr[17]-=temp;
		}
		if(arr[25]!=0)//zero
		{
			temp=arr[25];
			ans[0]=temp;
			
			arr[25]-=temp;
			arr[4]-=temp;
			arr[14]-=temp;
			arr[17]-=temp;
		}
		if(arr[22]!=0)//two
		{
			temp=arr[22];
			ans[2]=temp;
			
			arr[22]-=temp;
			arr[19]-=temp;
			arr[14]-=temp;
		}
		if(arr[23]!=0)//six
		{
			temp=arr[23];
			ans[6]=temp;
			
			arr[18]-=temp;
			arr[23]-=temp;
			arr[8]-=temp;
		}
		
		
		if(arr[14]!=0)//one
		{
			temp=arr[14];
			ans[1]=temp;
			
			arr[14]=0;
			arr[13]-=temp;
			arr[4]-=temp;
		}
		
		if(arr[5]!=0)//five
		{
			temp=arr[5];
			ans[5]=temp;
			
			arr[5]=0;
			arr[8]-=temp;
			arr[21]-=temp;
			arr[4]-=temp;
		}
		if(arr[21]!=0)//seven
		{
			temp=arr[21];
			ans[7]=temp;
			
			arr[21]=0;
			arr[18]-=temp;
			arr[13]-=temp;
			arr[4]-=temp;
			arr[4]-=temp;
		}
		if(arr[8]!=0)//nine
		{
			temp=arr[8];
			ans[9]=temp;
			
			arr[8]=0;
			arr[13]-=temp;
			arr[13]-=temp;
			arr[4]-=temp;
		}
		if(arr[19]!=0)//three
		{
			temp=arr[19];
			ans[3]=temp;
			
			arr[14]=0;
			arr[17]-=temp;
			arr[7]-=temp;
			arr[4]-=temp;
			arr[4]-=temp;
		}
		System.out.print("Case #"+ind+": ");
		for(i=0;i<10;++i)
		while(ans[i]-- >0)	
		System.out.print(i);
	System.out.println();
	++ind;
	}
}
}