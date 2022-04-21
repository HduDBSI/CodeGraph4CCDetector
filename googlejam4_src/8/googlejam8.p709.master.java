package googlejam8.p709;
import java.io.*;
import java.lang.*;
import java.util.*;

class master
{
    public static void main(String[] args)
    {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int tcase=in.nextInt();
	for(int i=1;i<=tcase;i++)
	    {
		    int N=in.nextInt();
		    int[] data=new int[N];
		    int total=0;
		    for(int j=0;j<N;j++)
		    {
			    data[j]=in.nextInt();
			    total=total+data[j];
			    
		    }
		    System.out.print("Case #"+i+": ");
		    for(int k=1;k<=total;k++)
			{
				int total1=0;
				    for(int j=0;j<data.length;j++)
				    {
					    total1=total1+data[j];
				    }
				    int max1=0,max1index=-1,max2=0,max2index=-1;
				    for(int j=0;j<data.length;j++)
				    {
					    if(data[j]>max1)
					    {
						    max1=data[j];
						    max1index=j;
					    }
				    }
				   if(max1index>=0)
				   {
					   data[max1index]--;
					   System.out.print((char)(max1index+65));
				   }
				   if(total1!=3)
				   {
				    for(int j=0;j<data.length;j++)
				    {
					    if(data[j]>max2)
					    {
						    max2=data[j];
						    max2index=j;
					    }
				    }
				    if(max2index>=0)
				   {
					   data[max2index]--;
					   System.out.print((char)(max2index+65));
				   }
				   }
				   if(max2index>=0||max1index>=0)
				   {
					   System.out.print(" ");
				   }
				
			}
		System.out.println("");
	    }
	
    }
}